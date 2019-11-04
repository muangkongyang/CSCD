/********************
 * @Muangkong Yang  *
 * CSCD330          *
 * FileTransfer     *
 ********************/

import java.io.*;
import java.net.*;

public class FileTransferServer 
{
	public static void main(String[] args) throws IOException 
	{
		int port = 8080;
		ServerSocket sSocket = new ServerSocket(port);
		
		while(true)
		{
			Socket cSocket = sSocket.accept();
			System.out.println("Connected to " + cSocket.getLocalAddress());
			
			FileTransfer fileTransfer = new FileTransfer(cSocket);
			new Thread(fileTransfer).start();
		}

	}
}

final class FileTransfer implements Runnable
{
	Socket socket;
	
	public FileTransfer(Socket socket)
	{
		this.socket = socket;
	}
	
	public void run()
	{
		try
		{
			sendFile();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private void sendFile() throws IOException
	{
		File myFile = new File("*PATH HERE*\\filetransfer\\src\\Classical-guitar-music.mp3");
		byte[] fileBuffer = new byte[(int) myFile.length()];
		FileInputStream fis = null; 
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int bytesPerSend = 3000;
		
		try
		{
			fis = new FileInputStream(myFile);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(socket.getOutputStream());
			System.out.println("Sending file..."); 
			int bytesSent = bis.read(fileBuffer, 0, bytesPerSend);
			int count = bytesSent;
			int total = 0;
			do
			{
				System.out.println("Sent " + total + "/" + fileBuffer.length + " bytes");
				total += count;
				bos.write(fileBuffer, 0, count);
				
			} while((count = bis.read(fileBuffer, 0, bytesPerSend)) > 0);
			
			System.out.println("Done sending file.");
			bos.flush();
			bos.close();
			socket.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}
}