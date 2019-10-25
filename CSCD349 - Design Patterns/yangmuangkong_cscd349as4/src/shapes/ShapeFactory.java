package shapes;

public class ShapeFactory 
{
	public Shape createCircle(double radius) 
	{
		return new Circle(radius);
	}
	
	public Shape createTriangle(double base, double height) 
	{
		return new Triangle(base, height);
	}
	
	public Shape createSquare(double length) 
	{
		return new Square(length);
	}
	
	public Shape createRectangle(double length, double width) 
	{
		return new Rectangle(length, width);
	}
}
