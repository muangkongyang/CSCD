package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

public class Ruffles extends TreeDecorator 
{
	public Ruffles(HolidayTree decoration) 
	{
		super(decoration);
	}

	@Override
	public double cost() 
	{	
		return 1.00 + decoration.cost();
	}

	@Override
	public String description() 
	{
		return decoration.description() + "with Ruffles, ";
	}
	
}
