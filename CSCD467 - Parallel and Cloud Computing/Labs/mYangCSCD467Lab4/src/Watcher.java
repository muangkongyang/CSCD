/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab4									*
 ****************************************/

public class Watcher 
{
	private int nextTurn;
	private int numThreads;
	private int message;
	private int switchMessage;
	
	public Watcher(int numThreads)
	{
		this.nextTurn = 0;
		this.numThreads = numThreads;
		this.message = 0;
		this.switchMessage = 1;
	}
	
	public synchronized void setNextTurn(int ThreadID)
	{
		while(ThreadID != getNextTurn())
		{
			try
			{
				this.wait();
			}
			catch(InterruptedException e)
			{
				
			}
		}
		
		this.nextTurn = (this.nextTurn + 1) % this.numThreads;
		printMessage(ThreadID);
		this.notifyAll();
	}
	
	public int getNextTurn()
	{
		return this.nextTurn;
	}	
	
	private void printMessage(int ThreadID)
	{
		if(this.switchMessage == 1)
			System.out.println("1st Message from thread " + ThreadID + ".");
		else if(this.switchMessage == 2)
			System.out.println("2nd Message from thread " + ThreadID + ".");
		else if(this.switchMessage == 3)
			System.out.println("3rd Message from thread " + ThreadID + ".");
		else
			System.out.println(this.switchMessage + "th Message from thread " + ThreadID + ".");
		
		this.message++;
		checkMessageNumber();
	}
	
	private void checkMessageNumber() 
	{	
		if(this.message == this.numThreads)
		{
			this.switchMessage++;
			this.message = 0;
		}
	}
}
