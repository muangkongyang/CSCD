package holiday_decorations;

public abstract class TreeDecorator implements HolidayTree
{
	protected HolidayTree decoration;
	
	protected TreeDecorator(HolidayTree decoration)
	{
		if(decoration != null)
			this.decoration = decoration;
	}
}
