import javax.swing.JTextArea;

public class DisplayMode implements Runnable 
{
	private JTextArea output;
	private String message;
	
	public DisplayMode(JTextArea output, String message)
	{
		this.output = output;
		this.message = message;
	}
	
	@Override
	public void run() 
	{	
		while(true)
		{
			try
			{
				output.append(this.message);
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				return;
			}
		}
	}
}
