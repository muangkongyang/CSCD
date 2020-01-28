/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab2									*
 ****************************************/

public class Counter 
{
	private int counter;
	
	public Counter(int counter)
	{
		setCounter(counter);
	}
	
	public void increment()
	{
		setCounter(getCounter() + 1);
	}
	
	public void decrement()
	{
		setCounter(getCounter() - 1);
	}
	
	public int getCounter()
	{
		return this.counter;
	}
	
	private void setCounter(int counter)
	{
		if(getCounter() < 0)
			this.counter = 0;
		else
			this.counter = counter;
	}
	
}
