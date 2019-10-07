package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.dungeonCharacters.heroes.Hero;

public class ExitRoom extends Room 
{	
	private static ExitRoom instance = null;
	
	private ExitRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	public static ExitRoom getExitInstance(DungeonCharacter hero)
	{
		if(instance == null)
			instance = new ExitRoom(hero);
		
		return instance;
	}
	
	@Override
	public String type() 
	{	
		return "O";
	}

	@Override
	public void effect() 
	{
		if(((Hero) super.getHero()).getNumPillars() == 4)
		{
			System.out.println("Congratulations! You have won the game!");
			super.getHero().setVictory();
		}
	}
}
