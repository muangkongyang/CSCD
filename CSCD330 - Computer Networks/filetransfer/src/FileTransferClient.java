/********************
 * @Muangkong Yang  *
 * CSCD330          *
 * FileTransfer     *
 ********************/

import java.io.*;
import java.net.*;

public class FileTransferClient 
{
	public static void main(String[] args) throws IOException 
	{
		int port = 8080;
		Socket cSocket = new Socket("localhost", port);
		
		try 
		{
			FileTransferCli fileTransfer = new FileTransferCli(cSocket);
			new Thread(fileTransfer).start();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

final class FileTransferCli implements Runnable
{
	Socket socket;
	
	public FileTransferCli(Socket socket)
	{
		this.socket = socket;
	}
	
	public void run()
	{
		try
		{
			recieveFile();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private void recieveFile() throws IOException
	{
		int bytesToRead = 4000;
		byte[] fileReader = new byte[bytesToRead];
		int bytesRead;
		InputStream is = null; 
		
		try
		{
			is = socket.getInputStream();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			if(is != null)
			{	
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;
				try
				{
					fos = new FileOutputStream("src\\testFileTransfer.mp3");
					bos = new BufferedOutputStream(fos);
					bytesRead = is.read(fileReader, 0, fileReader.length);
					System.out.println("Starting to recieve file...");
					do
					{
						System.out.println("(" + bytesRead + " bytes read/" + fileReader.length + " bytes)");
						baos.write(fileReader, 0, bytesRead);
						bytesRead = is.read(fileReader, 0, fileReader.length);
					} while (bytesRead != -1);
					
					bos.write(baos.toByteArray());
					System.out.println("Done recieving file!");
					bos.flush();
					bos.close();
					socket.close();
					
					return;
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}
}