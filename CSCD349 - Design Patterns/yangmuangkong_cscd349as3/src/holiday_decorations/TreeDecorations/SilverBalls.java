package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

public class SilverBalls extends TreeDecorator 
{
	public SilverBalls(HolidayTree decoration) 
	{
		super(decoration);
	}

	@Override
	public double cost() 
	{	
		return 3.00 + decoration.cost();
	}

	@Override
	public String description() 
	{
		return decoration.description() + "with Silver Balls, ";
	}
	
}
