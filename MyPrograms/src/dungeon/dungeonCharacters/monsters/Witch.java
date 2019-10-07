package dungeon.dungeonCharacters.monsters;

public class Witch extends Monster 
{
	public Witch()
	{
		super("Witch of the Night", 60);
	}

	@Override
	public double chanceToHeal() 
	{
		return 0.4;
	}

	@Override
	public int minHealPoints() 
	{
		return 10;
	}

	@Override
	public int maxHealPoints() 
	{
		return 20;
	}

	@Override
	public int originalHitPoints() 
	{
		return 60;
	}

	@Override
	public int attackSpeed() 
	{
		return 7;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.85;
	}

	@Override
	public int damageMin() 
	{
		return 10;
	}

	@Override
	public int damageMax() 
	{
		return 30;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" screams a shock wave at ");
	}
	
}
