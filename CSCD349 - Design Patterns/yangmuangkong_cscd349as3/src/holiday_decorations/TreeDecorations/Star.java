package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

// Will use some aspects of Singleton pattern
public class Star extends TreeDecorator
{
	private static Star instance;
	
	private Star(HolidayTree decoration)
	{	
		super(decoration);
	}
	
	public static Star getStar(HolidayTree decoration)
	{
		if(instance == null)
			instance = new Star(decoration);
			
		return instance;
	}
	
	// Quick check so the decoration doesn't get set to the location of the instance
	public static boolean checkForStar(HolidayTree decoration)
	{
		if(instance == null)
			return true;
		else
			System.out.println("The tree already has a star.");
		
		return false;
	}
	
	public static void setStarInstanceToNull()
	{
		instance = null;
	}
	
	@Override
	public double cost() 
	{
		return 4.00 + decoration.cost();
	}

	@Override
	public String description() 
	{
		return decoration.description() + "with a Star, ";
	}
}
