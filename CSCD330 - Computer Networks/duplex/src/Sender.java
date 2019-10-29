import java.io.*;
import java.net.*;

public class Sender implements Runnable 
{
	private Socket socket;

	public Sender(Socket s) 
	{
		this.socket = s;
	}

	@Override
	public void run() 
	{
		try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) 
		{
			String send;
			do 
			{
				send = in.readLine();
				if (send == null) 
					break;
				out.println(send);
			} while (!send.contains("/exit"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}