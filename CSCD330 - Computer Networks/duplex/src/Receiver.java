import java.io.*;
import java.net.*;

public class Receiver implements Runnable 
{
	private Socket socket;

	public Receiver(Socket s) 
	{
		this.socket = s;
	}

	@Override
	public void run() 
	{
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) 
		{
			String received;
			do 
			{
				received = in.readLine();
				if (received == null) 
					break;
				System.out.println(">> " + received);
			} 
			while (!received.contains("/exit"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}