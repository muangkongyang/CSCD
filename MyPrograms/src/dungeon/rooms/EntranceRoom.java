package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;

public class EntranceRoom extends Room 
{	
	private static EntranceRoom instance = null;
	
	private EntranceRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	public static EntranceRoom getEntranceInstance(DungeonCharacter hero)
	{
		if(instance == null)
			instance = new EntranceRoom(hero);
		
		return instance;
	}
	
	@Override
	public String type() 
	{	
		return "I";
	}

	@Override
	public void effect() 
	{
	
	}

	
}
