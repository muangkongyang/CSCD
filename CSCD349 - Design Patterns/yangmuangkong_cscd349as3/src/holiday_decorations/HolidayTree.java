package holiday_decorations;

import holiday_decorations.TreeDecorations.Star;

public interface HolidayTree 
{
	public double cost();
	public String description();
	
	public default void print()
	{
		System.out.println(this.description() + "costs $" + this.cost() + ".");
		Star.setStarInstanceToNull(); //will reset star instance after every tree
	}
	
	public default HolidayTree checkStar(HolidayTree decoration)
	{
		if(Star.checkForStar(decoration))
			decoration = (HolidayTree) Star.getStar(decoration);
		
		return decoration;
	}
}
