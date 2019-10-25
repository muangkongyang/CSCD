package shapes;

public class Square extends Shape 
{
	private double length;
	private double width;
	
	public Square(double length)
	{
		setLength(length);
	}
	
	public double getLength() 
	{
		return this.length;
	}
	
	public double getWidth() 
	{
		return this.width;
	}
	
	public void setLength(double length)
	{
		if(length > 0.0)
		{
			this.length = length;
			this.width = length;
		}
		else
			System.out.println(name() + " edge length must be non-negative and greater than 0.0");
	}
	
	@Override
	public double computeArea() 
	{
		if(getLength() >= 0.0 && getWidth() >= 0.0 && getLength() == getWidth())
			return getLength() * getWidth();
		else
			System.out.println(name() + " length or width is negative.");
		
		return 0.0;
	}
	
	@Override
	public String name()
	{
		return "Square";
	}
}