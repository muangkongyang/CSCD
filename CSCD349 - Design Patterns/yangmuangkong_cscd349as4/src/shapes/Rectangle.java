package shapes;

public class Rectangle extends Shape 
{
	private double length;
	private double width;
	
	public Rectangle(double length, double width)
	{
		setLength(length);
		setWidth(width);
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
			this.length = length;
		else
			System.out.println(name() + " length must be non-negative and greater than 0.0");
	}
	
	public void setWidth(double width)
	{
		if(width > 0.0)
			this.width = width;
		else
			System.out.println(name() + " width must be non-negative and greater than 0.0");
	}
	
	@Override
	public double computeArea() 
	{
		if(getLength() >= 0.0 && getWidth() >= 0.0)
			return getLength() * getWidth();
		else
			System.out.println(name() + " length or width is negative.");
		
		return 0.0;
	}
	
	@Override
	public String name()
	{
		return "Rectangle";
	}
}
