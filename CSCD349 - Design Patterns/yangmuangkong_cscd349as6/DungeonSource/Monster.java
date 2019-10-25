public abstract class Monster extends DungeonCharacter
{
	// Some unique functions for Monsters only that differ
	// List them here:
	public abstract double chanceToHeal();
	public abstract int minHealPoints();
	public abstract int maxHealPoints();
		
	public Monster(String name, int hitPoints) 
	{
		super(name, hitPoints);
	}
	
	public void attack(DungeonCharacter character) 
	{
		super.attack(character);
	}
	
	public void heal()
	{
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal()) && (this.getHitPoints() > 0);

		if (canHeal)
		{
			healPoints = (int)(Math.random() * (maxHealPoints() - minHealPoints() + 1)) + minHealPoints();
			addHealPoints(healPoints);
			System.out.println(this.getName() + " healed itself for " + healPoints + " points.\n"
								+ "Total hit points remaining are: " + this.getHitPoints());
			System.out.println();
		}//end can heal
	}//end heal method
	
	public void subtractHitPoints(DungeonCharacter character, int damage)
	{
		if (((Hero) character).defend())
		{
			System.out.println(character.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(character, damage);
		}
	}
	
}
