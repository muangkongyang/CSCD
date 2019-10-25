package holiday_decorations.TreeDecorations;
import holiday_decorations.*;

public class Lights extends TreeDecorator 
{
	public Lights(HolidayTree decoration) 
	{
		super(decoration);
	}

	@Override
	public double cost() 
	{	
		return 5.00 + decoration.cost();
	}

	@Override
	public String description() 
	{
		return decoration.description() + "with Lights, ";
	}
	
}
