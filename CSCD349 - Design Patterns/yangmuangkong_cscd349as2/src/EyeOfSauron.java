import java.util.*;

@SuppressWarnings("deprecation")
public class EyeOfSauron extends Observable
{
	private Enemies num;
	
	public EyeOfSauron()
	{
		this.num = new Enemies(0, 0, 0, 0);
	}
	
	public void showCurrentEnemyCount()
	{
		System.out.println("\"Current Enemies: " + num.getHobbitCount() + " hobbits, " + num.getDwarfCount() + " dwarves, " 
				           + num.getElfCount() + " elves, " + num.getManCount() + " men.\"");
	}
	
	public void setEnemies(int hobCount, int dwarfCount, int elfCount, int manCount)
	{
		if(checkForChangesInEnemyCount(hobCount, dwarfCount, elfCount, manCount))
		{    
			this.num.setHobbitCount(hobCount);
			this.num.setDwarfCount(dwarfCount);
			this.num.setElfCount(elfCount);
			this.num.setManCount(manCount);
			
			this.setChanged();
		}
		
		if(this.hasChanged())
			this.notifyObservers();
		else
			System.out.println("   Current enemy count has not changed. Nothing to report.");
			// clearChanged() is automatically called
	}

	private boolean checkForChangesInEnemyCount(int hobCount, int dwarfCount, int elfCount, int manCount)
	{
		if(this.num.getHobbitCount() != hobCount || this.num.getDwarfCount() != dwarfCount ||
				   this.num.getElfCount() != elfCount || this.num.getManCount() != manCount)  
			return true;
		
		return false;
	}
}
