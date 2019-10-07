package dungeon.dungeonCharacters.heroes;

import dungeon.dungeonCharacters.DungeonCharacter;

public class Sorceress extends Hero
{	
	public Sorceress(final String name) 
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
		return 5;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.7;
	}

	@Override
	public int damageMin() 
	{
		return 25;
	}

	@Override
	public int damageMax() 
	{
		return 45;
	}
	
	@Override
	public double chanceToBlock() 
	{
		return 0.3;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" casts a spell of fireball at ");
	}
	
	@Override
	public void special(DungeonCharacter character) 
	{	
		int healPoints;
		final int minHeal = 25;
		final int maxHeal = 50;
		
		healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		System.out.println(this.getName() + " uses CURE!");
		addHealPoints(healPoints);
		System.out.println(this.getName() + " added [" + healPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ this.getHitPoints());
		System.out.println();
	}

	@Override
	public void commandMenu() 
	{
		System.out.println("1. Attack Opponent");
	    System.out.println("2. Heal");
	    System.out.println("3. Use Item");
	}
}//end Sorceress class