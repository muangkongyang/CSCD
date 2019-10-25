package holiday_decorations.Trees;
import holiday_decorations.*;

public class FraserFir implements HolidayTree
{
	@Override
	public double cost() 
	{
		return 35.00;
	}

	@Override
	public String description() 
	{
		return "A Fraser Fir tree ";
	}
	
}
