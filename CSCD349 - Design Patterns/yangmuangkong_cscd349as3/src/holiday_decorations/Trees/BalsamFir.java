package holiday_decorations.Trees;
import holiday_decorations.*;

public class BalsamFir implements HolidayTree
{
	@Override
	public double cost() 
	{
		return 25.00;
	}

	@Override
	public String description() 
	{
		return "A Balsam Fir tree ";
	}
	
}
