// This class supports the EyeOfSauron class by keeping track of the enemy count
public class Enemies
{
	private int hobbitCount, dwarfCount, elfCount, manCount;
	
	public Enemies(int hobbitCount, int dwarfCount, int elfCount, int manCount)
	{
		this.hobbitCount = hobbitCount;
		this.dwarfCount = dwarfCount;
		this.elfCount = elfCount;
		this.manCount = manCount;
	}
	
	public int getHobbitCount()
	{
		return this.hobbitCount;
	}
	
	public int getDwarfCount()
	{
		return this.dwarfCount;
	}
	
	public int getElfCount()
	{
		return this.elfCount;
	}
	
	public int getManCount()
	{
		return this.manCount;
	}
	
	public void setHobbitCount(int newHobbitCount)
	{
		if(newHobbitCount < 0)
			throw new IllegalArgumentException("Negative count for hobbits.");
		
		this.hobbitCount = newHobbitCount;
	}
	
	public void setDwarfCount(int newDwarfCount)
	{
		if(newDwarfCount < 0)
			throw new IllegalArgumentException("Negative count for dwarves.");
		
		this.dwarfCount = newDwarfCount;
	}
	
	public void setElfCount(int newElfCount)
	{
		if(newElfCount < 0)
			throw new IllegalArgumentException("Negative count for elves.");
		
		this.elfCount = newElfCount;
	}
	
	public void setManCount(int newManCount)
	{
		if(newManCount < 0)
			throw new IllegalArgumentException("Negative count for men.");
		
		this.manCount = newManCount;
	}
}
