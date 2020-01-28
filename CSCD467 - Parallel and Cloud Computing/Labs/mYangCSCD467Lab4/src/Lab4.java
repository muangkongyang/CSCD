/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab4									*
 ****************************************/

public class Lab4 
{
	public static void main(String[] args) throws InterruptedException 
	{
		if(args.length < 1)
		{
			System.out.println("Arguments are not correctly inputted.");
			System.exit(0);
		}
		
		int numInputtedThreads = Integer.parseInt(args[0]);
		Thread[] numThreads = new Thread[numInputtedThreads];
		Watcher watch = new Watcher(numInputtedThreads);
		
		for(int i = 0; i < numThreads.length; i++)
		{
			numThreads[i] = new Thread(new MyThreads(i, watch));
			numThreads[i].start();
		}
		
		for(int i = 0; i < numThreads.length; i ++)
		{
			numThreads[i].join();
		}
	}

}
