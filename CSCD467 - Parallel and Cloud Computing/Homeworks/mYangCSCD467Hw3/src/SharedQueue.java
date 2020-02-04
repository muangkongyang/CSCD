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
	private int capacity;

    public SharedQueue(int capacity)
    {
    	this.myQueue = new LinkedList<String>();
    	this.readerIsDone = false;
    	this.capacity = capacity;;
	}
	 
	public synchronized void readerDone()
	{
		this.readerIsDone = true;
		this.notifyAll();
	}
	   
	public synchronized boolean getReaderStatus()
	{
		return this.readerIsDone;
	}
	
	public synchronized boolean isEmpty() 
	{  
		if(this.myQueue.isEmpty())
			return true;
		
		return false;
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

		while(isEmpty()) 
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
		
		val = this.myQueue.remove();
	    this.notify();
	    return val;
	}
}
