package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;

public class EmptyRoom extends Room 
{	
	public EmptyRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	@Override
	public String type() 
	{	
		return "E";
	}
	
	@Override
	public void effect() 
	{
		
	}
}
