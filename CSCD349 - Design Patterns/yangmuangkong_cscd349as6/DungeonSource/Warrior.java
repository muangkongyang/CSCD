public class Warrior extends Hero
{	
	public Warrior(final String name) 
	{
		super(name, 125);
	}
	
	@Override
	public int originalHitPoints()
	{
		return 125;
	}
	
	@Override
	public int attackSpeed() 
	{
		return 4;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.8;
	}

	@Override
	public int damageMin() 
	{
		return 35;
	}

	@Override
	public int damageMax() 
	{
		return 60;
	}
	
	@Override
	public double chanceToBlock() 
	{
		return 0.2;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" swings a mighty sword at ");
	}
	
	@Override
	public void special(DungeonCharacter character) 
	{	
		int damage = 0;
		if (Math.random() <= .4)
		{
			damage = (int)(Math.random() * 76) + 100;
			System.out.println(getName() + " lands a CRUSHING BLOW for " + damage
								+ " damage!");
			subtractHitPoints(character, damage);
		}//end blow succeeded
		else
		{
			System.out.println(getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
	}

	@Override
	public void commandMenu() 
	{
		System.out.println("1. Attack Opponent");
		System.out.println("2. Crushing Blow on Opponent");
	}

}//end Hero class