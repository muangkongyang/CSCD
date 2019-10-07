package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.dungeonCharacters.heroes.Hero;

public class PillarsRoom extends Room 
{	
	private int aPiller = 1;
	
	public PillarsRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	@Override
	public String type() 
	{	
		return "!";
	}
	
	private int getaPiller() 
	{
		return aPiller;
	}

	private void setaPiller(int aPiller) 
	{
		this.aPiller = aPiller;
	}
	
	@Override
	public void effect() 
	{
		if(this.getaPiller() == 1)
		{
			System.out.println(super.getHero().getName() + " stumbled across a pillar of OO!");
			this.setaPiller(this.getaPiller() - 1);
			((Hero) super.getHero()).setNumPillars(((Hero) super.getHero()).getNumPillars() + 1);
		}
	}
}
