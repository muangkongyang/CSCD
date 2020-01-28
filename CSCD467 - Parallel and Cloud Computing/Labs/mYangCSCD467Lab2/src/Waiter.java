/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab2									*
 ****************************************/

public class Waiter implements Runnable
{	
	@Override
	public void run() 
	{
		// This utilizes handling methods that do not throw an Interrupted Exception
		int loop = 1;
		while(loop == 1)
		{
			if(Thread.interrupted())
			{
				System.out.println("Printer has already got his work half done!");
				loop = 2;
			}
		}
		
		System.out.println("Waiter has done its work, terminating.");
		
		/*//This utilizes handling methods that throws an Interrupted Exception
		try
		{
			while(true)
			{
				Thread.sleep(100);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Printer has already got his work half done!");
			System.out.println("Waiter has done its work, terminating.");
			return;
		}
		*/
	}
}
