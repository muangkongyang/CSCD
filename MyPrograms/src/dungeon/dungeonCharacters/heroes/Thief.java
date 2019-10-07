package dungeon.dungeonCharacters.heroes;

import dungeon.dungeonCharacters.DungeonCharacter;

public class Thief extends Hero
{	
	public Thief(final String name) 
	{
		super(name, 75);
	}
	
	@Override
	public int originalHitPoints()
	{
		return 75;
	}
	
	@Override
	public int attackSpeed() 
	{
		return 6;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.8;
	}

	@Override
	public int damageMin() 
	{
		return 20;
	}

	@Override
	public int damageMax() 
	{
		return 40;
	}
	
	@Override
	public double chanceToBlock() 
	{
		return 0.4;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" quickly goes in to stab ");
	}
	
	@Override
	public void special(DungeonCharacter character) 
	{	
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								this.getName() + " gets an additional turn.");
			this.setNumTurns(getNumTurns() + 1);
			attack(character);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + character.getName() + " saw you and" +
								" blocked your attack!");
			System.out.println();
		}
		else
		    attack(character);
	}

	@Override
	public void commandMenu() 
	{
		System.out.println("1. Attack Opponent");
	    System.out.println("2. Surprise Attack");
	    System.out.println("3. Use Item");
	}
}//end Thief class