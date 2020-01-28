import javax.swing.JTextArea;

public class Displayer implements Runnable
{
	private JTextArea output;
	
	public Displayer(JTextArea output)
	{
		this.output = output;
	}
	
	@Override
	public void run() 
	{	
		while(!Thread.currentThread().isInterrupted())
		{
			try
			{
				output.append("Message from Thread --> " + Thread.currentThread().getName() + "\n");
				Thread.sleep(1000); // sleeps for 1 second
			}
			catch(InterruptedException e)
			{
				output.append(Thread.currentThread().getName() + " gets interrupted! Terminate!\n");
				return;
			}
		}
	}
}
