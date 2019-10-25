package holiday_decorations.Trees;
import holiday_decorations.*;

public class DouglasFir implements HolidayTree
{
	@Override
	public double cost() 
	{
		return 30.00;
	}

	@Override
	public String description() 
	{
		return "A Douglas Fir tree ";
	}
	
}
