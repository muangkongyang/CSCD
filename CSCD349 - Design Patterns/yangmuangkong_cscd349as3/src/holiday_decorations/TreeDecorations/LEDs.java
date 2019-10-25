package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

public class LEDs extends TreeDecorator 
{
	public LEDs(HolidayTree decoration) 
	{
		super(decoration);
	}

	@Override
	public double cost() 
	{	
		return 10.00 + decoration.cost();
	}

	@Override
	public String description() 
	{
		return decoration.description() + "with LEDs, ";
	}
	
}
