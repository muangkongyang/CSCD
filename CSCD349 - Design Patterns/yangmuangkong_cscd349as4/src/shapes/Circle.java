package shapes;

public class Circle extends Shape 
{
	private double radius;
	
	public Circle(double radius)
	{
		setRadius(radius);
	}
	
	public double getRadius() 
	{
		return this.radius;
	}
	
	public void setRadius(double radius)
	{
		if(radius > 0.0)
			this.radius = radius;
		else
			System.out.println(name() + " radius must be non-negative and greater than 0.0");
	}
	
	@Override
	public double computeArea() 
	{
		if(getRadius() >= 0.0)
			return Math.PI * Math.pow(getRadius(), 2);
		else
			System.out.println(name() + " radius is negative.");
		
		return 0.0;
	}
	
	@Override
	public String name()
	{
		return "Circle";
	}
}
