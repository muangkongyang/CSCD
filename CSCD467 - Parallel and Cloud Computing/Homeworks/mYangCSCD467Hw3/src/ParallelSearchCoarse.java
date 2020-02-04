/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * HW4									*
 ****************************************/

import java.io.IOException;

public class ParallelSearchCoarse 
{	
	public static void main(String args[]) throws InterruptedException, IOException 
	{
		if( args.length < 2) {
			System.out.println("Usage: Java ParallelSearchCoarse FileName Pattern");
			System.exit(0);
		}
		
		String fname = args[0];         // fileName = files/wikipedia2text-extracted.txt
		String pattern = args[1];       // pattern = "(John) (.+?) ";
		
		// Serial Solution
		long startOriginal = System.currentTimeMillis();
		SerialSearchFile sf = new SerialSearchFile();
	    int num = sf.searchPattern(fname, pattern);
	    System.out.println("Total occurrence of pattern " + pattern + " is " + num);
	    long endOriginal = System.currentTimeMillis();
		long originalTime = endOriginal - startOriginal;
		System.out.println("Time cost for serial solution is " + originalTime + " ms.");
		System.out.println();
		
		// Parallel Solution
		SharedQueue myQueue = new SharedQueue(100);
		long start = System.currentTimeMillis();
		Thread reader = new Thread(new Reader(myQueue, fname));
		Thread searcher = new Thread(new Searcher(myQueue, fname, pattern));
		reader.start();
		searcher.start();
		reader.join();
		searcher.join();
		
		//DEBUG: System.out.println("Threads finished.");
		long end = System.currentTimeMillis();
		long parallelTime = end - start;
		System.out.println("Time cost for parallel solution is " + parallelTime + " ms.");
		
		System.out.format("\nThe speedup ration is by using concurrent programming: %5.2f. %n", (double)originalTime/parallelTime);
				
	}

}
