import java.io.*;
import java.net.*;

public class dclient 
{
	public static void main(String[] args) throws IOException 
	{
		String host = "localhost";
		int port = 5000;
		Socket socket = new Socket(host, port);
		try 
		{
			System.out.println("Connected to server: " + host);
			if (!socket.isClosed())
				new Thread(new Sender(socket)).start();
			if (!socket.isClosed())
				new Thread(new Receiver(socket)).start();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}