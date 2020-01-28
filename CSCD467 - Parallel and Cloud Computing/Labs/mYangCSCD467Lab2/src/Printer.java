/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab2									*
 ****************************************/

public class Printer implements Runnable
{
	private Counter counter;
	private Thread waiter;
	
	public Printer(Counter counter, Thread waiter)
	{
		this.counter = counter;
		this.waiter = waiter;
	}
	
	@Override
	public void run() 
	{
		for(; counter.getCounter() <= 50; counter.increment())
		{
			System.out.println("Message i = " + counter.getCounter() + ", from " + Thread.currentThread().getName());
				
			if(counter.getCounter() == 25)
				waiter.interrupt();	
		}
		
		System.out.println("Printer has done its work, terminating.");
	}

}
