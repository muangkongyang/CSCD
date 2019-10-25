package shapes;

public abstract class Shape implements Comparable<Shape>
{
	public abstract String name();
	public abstract double computeArea();
	
	public void printArea()
	{
		System.out.printf(this.name() + " area is %.2f\n", this.computeArea());
	}
	
	@Override
	public int compareTo(Shape other)
	{
		int res;
		res = this.name().compareToIgnoreCase(other.name());
		if(res != 0)
			res = Double.compare(this.computeArea(), other.computeArea());
		
		return res;

	}
}
