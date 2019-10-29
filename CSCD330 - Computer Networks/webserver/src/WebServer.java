/************************
 * Muangkong Yang		*
 * CSCD330 				*
 * WebServer			*
 ************************/

import java.io.*;
import java.net.*;

public class WebServer
{
	public static void main(String[] args) throws Exception
	{
		int port = 8080;

		ServerSocket sSocket = new ServerSocket(port);
		
		while (true)
		{
			Socket cSocket = sSocket.accept();
			
			HttpRequest request = new HttpRequest(cSocket);
			Thread thread = new Thread(request);
			thread.start();
		}
	}
}

final class HttpRequest implements Runnable
{
	Socket socket;
	
	public HttpRequest(Socket socket) throws Exception 
	{ 
		this.socket = socket; 
	}
	
	public void run()
	{
		try 
		{ 
			processRequest(); 
		}
		catch(Exception e) 
		{ 
			System.out.println("e"); 
		}
	}
	
	private void processRequest() throws Exception
	{
		InputStream is = socket.getInputStream();
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
		
		String status = "HTTP/1.1 200 OK\r\n";
		String body = "Hello World!";

		os.writeBytes(status);
		os.writeBytes("\r\n");
		os.writeBytes(body);
		
		is.close();
		os.close();
		br.close();
		socket.close();
	}

}
