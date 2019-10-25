import java.util.*;

@SuppressWarnings("deprecation")
public class BadGuy implements Observer
{
	private EyeOfSauron eye;
	private String name;
	
	public BadGuy(EyeOfSauron eye, String name)
	{
		this.eye = eye;
		this.name = name;
		// will automatically add the new BadGuy to observer list
		eye.addObserver((BadGuy) this); 
	}
	
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		eye = (EyeOfSauron) arg0;
		System.out.print(this.getName() + " obtains the report from Eye of Sauron: ");
		eye.showCurrentEnemyCount();
			
	}
	
	public void defeated()
	{
		System.out.println("\t*" + this.getName() + " has been defeated.");
		this.eye.deleteObserver((BadGuy) this);
	}
	
	public String getName()
	{
		return this.name;
	}
}
