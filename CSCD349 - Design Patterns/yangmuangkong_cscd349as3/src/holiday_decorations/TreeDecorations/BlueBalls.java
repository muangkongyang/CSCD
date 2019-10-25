package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

public class BlueBalls extends TreeDecorator 
{
	public BlueBalls(HolidayTree decoration) 
	{
		super(decoration);
	}

	@Override
	public double cost() 
	{	
		return 2.00 + decoration.cost();
	}

	@Override
	public String description() 
	{
		return decoration.description() + "with Blue Balls, ";
	}
	
}
