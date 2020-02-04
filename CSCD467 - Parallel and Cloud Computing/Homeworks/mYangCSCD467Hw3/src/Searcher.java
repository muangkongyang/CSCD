/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * HW4									*
 ****************************************/

public class Searcher implements Runnable
{
	private SharedQueue queue;
	private String pattern;
	private int numPatternFound;
	private int lineNum;
	
	public Searcher(SharedQueue queue, String fname, String pattern)
	{
		this.queue = queue;
		this.pattern = pattern;
		this.numPatternFound = 0;
		this.lineNum = 0;
	}
	
	@Override
	public void run() 
	{
		//DEBUG: System.out.println("Searcher started.");
		while(!queue.getReaderStatus())
		{
			searcherLoop();
		}
		
		//DEBUG: System.out.println("Searcher next loop started.");
		searcherLoop();
		//DEBUG: System.out.println("Searcher done.");
		System.out.println("Total number of lines searched in parallel is " + this.lineNum);
		System.out.println("Total occurrence of pattern " + this.pattern + " is " + this.numPatternFound);
	}
	
	private void searcherLoop()
	{
		while(!this.queue.isEmpty())
		{			
			find();
		}
	}
	
	private void find()
	{
		String line = (String) queue.dequeue();
		//DEBUG: System.out.println("Searcher dequeued a line.");
		int numFound = SerialSearchFile.searchLine(line, this.pattern);
		//if(numFound > 0)
			//System.out.println("Number of pattern found on line " + this.lineNum + ": " + numFound);
		this.numPatternFound += numFound;
		this.lineNum++;
	}
}
