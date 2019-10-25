package shapes;

public class Triangle extends Shape 
{
	private double base;
	private double height;
	
	public Triangle(double base, double height)
	{
		setBase(base);
		setHeight(height);
	}
	
	public double getBase() 
	{
		return this.base;
	}
	
	public double getHeight() 
	{
		return this.height;
	}
	
	public void setBase(double base)
	{
		if(base > 0.0)
			this.base = base;
		else
			System.out.println(name() + " base must be non-negative and greater than 0.0");
	}
	
	public void setHeight(double height)
	{
		if(height > 0.0)
			this.height = height;
		else
			System.out.println(name() + " height must be non-negative and greater than 0.0");
	}
	
	@Override
	public double computeArea() 
	{
		if(getBase() >= 0.0 && getHeight() >= 0.0)
			return (getBase()/2) * getHeight();
		else
			System.out.println(name() + " has negative dimensions.");
		
		return 0.0;
	}
	
	@Override
	public String name()
	{
		return "Triangle";
	}
}
