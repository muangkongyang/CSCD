/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab4									*
 ****************************************/

public class MyThreads implements Runnable 
{	
	private int ID;
	private Watcher watch;
	
	public MyThreads(int currThreadID, Watcher watch)
	{
		this.ID = currThreadID;
		this.watch = watch;
	}
	
	public int ID()
	{
		return this.ID;
	}
	
	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
		{
			this.watch.setNextTurn(ID());
		}
	}
}
