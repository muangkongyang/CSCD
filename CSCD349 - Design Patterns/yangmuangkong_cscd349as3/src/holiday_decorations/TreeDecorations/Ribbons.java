package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

public class Ribbons extends TreeDecorator 
{
	public Ribbons(HolidayTree decoration) 
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
		return decoration.description() + "with Ribbons, ";
	}
	
}
