/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * HW4									*
 ****************************************/

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue 
{
	private Queue<String> myQueue;
	private boolean readerIsDone;
	private boolean searcherIsDone;
	private int capacity;

    public SharedQueue(int capacity)
    {
    	this.myQueue = new LinkedList<String>();
    	this.readerIsDone = false;
    	this.searcherIsDone = false;
    	this.capacity = capacity;
	}
	 
	public synchronized void readerDone()
	{
		this.readerIsDone = true;
		this.notifyAll();
	}
	
	public synchronized void searcherDone()
	{
		this.searcherIsDone = true;
		this.notifyAll();
	}
	   
	public synchronized boolean getReaderStatus()
	{
		return this.readerIsDone;
	}
	
	public synchronized boolean getSearcherStatus()
	{
		return this.searcherIsDone;
	}
	
	public synchronized boolean isEmpty() 
	{  
		return this.myQueue.isEmpty();
	}

	public synchronized void enqueue(String val)
	{
		while(this.myQueue.size() >= this.capacity) 
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
		    }
		}

	    this.myQueue.add(val);
	    this.notifyAll();
	}

	public synchronized String dequeue()
	{
		String val;
		
		
		while(this.myQueue.size() == 0 && !searcherIsDone) 
		{
			try 
			{
				//System.out.println( " WAITING TO CONSUME" );
				wait();
			}
	    	catch(InterruptedException e) 
			{
	    		e.printStackTrace();
	    	}
		}
		
		if(this.myQueue.size() == 0 && searcherIsDone)
			return null;
		
		val = this.myQueue.remove();
		
		if(myQueue.size() == 0)// && readerIsDone)
			searcherIsDone = true;
		
		this.notify();
	    
	    return val;
	}
}
