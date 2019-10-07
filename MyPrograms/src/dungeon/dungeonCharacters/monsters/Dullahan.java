package dungeon.dungeonCharacters.monsters;

public class Dullahan extends Monster 
{
	public Dullahan()
	{
		super("Dullahan the Headless", 150);
	}

	@Override
	public double chanceToHeal() 
	{
		return 0.1;
	}

	@Override
	public int minHealPoints() 
	{
		return 15;
	}

	@Override
	public int maxHealPoints() 
	{
		return 30;
	}

	@Override
	public int originalHitPoints() 
	{
		return 150;
	}

	@Override
	public int attackSpeed() 
	{
		return 9;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.65;
	}

	@Override
	public int damageMin() 
	{
		return 10;
	}

	@Override
	public int damageMax() 
	{
		return 60;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" swings it's scythe towards ");
	}
	
}
