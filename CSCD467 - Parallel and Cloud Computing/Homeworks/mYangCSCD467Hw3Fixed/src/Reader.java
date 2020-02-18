/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * HW4									*
 ****************************************/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable 
{	
	private SharedQueue queue;
	private BufferedReader reader;
	
	public Reader(SharedQueue queue, String fname) 
	{
		this.queue = queue;
		openFile(fname);
	}
	
	@Override
	public void run()
	{
		try
		{
			//DEBUG: System.out.println("Reader started.");
			String currentLine = "";

			while((currentLine = reader.readLine()) != null)
			{
				//DEBUG: System.out.println(currentLine);
				queue.enqueue(currentLine);
				//DEBUG: System.out.println("Reader enqueued a line");
			}
			//DEBUG: System.out.println("Reader done.");
			queue.readerDone();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(reader != null)
					reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void openFile(String fname) 
	{
		try
		{
			reader = new BufferedReader(new FileReader(fname));
		}
		catch (IOException e)
		{
			System.out.println(e.getStackTrace());
		}
	}
	
}
