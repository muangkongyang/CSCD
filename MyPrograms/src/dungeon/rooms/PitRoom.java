package dungeon.rooms;

import dungeon.Utils;
import dungeon.dungeonCharacters.DungeonCharacter;

public class PitRoom extends Room 
{	
	public PitRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	@Override
	public String type() 
	{	
		return "P";
	}
	
	@Override
	public void effect() 
	{
		System.out.println("You fell into a pit!");
		int pitDamage = Utils.randInt(20) + 1;
		System.out.println(super.getHero().getName() + " takes <" + pitDamage + "> points of damage.");
		
		super.getHero().setHitPoints(super.getHero().getHitPoints() - pitDamage);
	}
}
