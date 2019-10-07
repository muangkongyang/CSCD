package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;

public abstract class Room 
{
	public abstract String type();
	public abstract void effect();
	
	private final DungeonCharacter hero;
	private boolean visited = false;
	
	public Room(final DungeonCharacter hero)
	{
		this.hero = hero;
	}
	
	public boolean hasVisited() 
	{
		return visited;
	}
	
	public void isVisited() 
	{
		this.visited = true;
	}
	
	public String toString()
	{
		return type();
	}
	
	public DungeonCharacter getHero() 
	{
		return hero;
	}
	
	public void roomEffect()
	{
		if(!hasVisited())
			isVisited();
		effect();
	}
}
