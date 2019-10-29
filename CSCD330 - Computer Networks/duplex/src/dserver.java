import java.io.*;
import java.net.*;

public class dserver 
{
	public static void main(String[] args) throws IOException 
	{
		int port = 5000;
		ServerSocket serverSocket = new ServerSocket(port);
		Socket clientSocket = serverSocket.accept();
		try 
		{
			System.out.println("Connected to client: " + clientSocket.getLocalAddress());
			
			if (!clientSocket.isClosed())
				new Thread(new Receiver(clientSocket)).start();
			if (!clientSocket.isClosed())
				new Thread(new Sender(clientSocket)).start();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}