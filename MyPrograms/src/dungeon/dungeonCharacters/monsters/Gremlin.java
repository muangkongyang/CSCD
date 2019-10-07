package dungeon.dungeonCharacters.monsters;

public class Gremlin extends Monster
{
	public Gremlin()
	{
		super("Gnarltooth the Gremlin", 70);

    }//end constructor

	@Override
	public int originalHitPoints() 
	{
		return 70;
	}

	@Override
	public int attackSpeed() 
	{
		return 5;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.8;
	}

	@Override
	public int damageMin() 
	{
		return 15;
	}

	@Override
	public int damageMax() 
	{
		return 30;
	}

	@Override
	public double chanceToHeal() 
	{
		return 0.4;
	}

	@Override
	public int minHealPoints() 
	{
		return 20;
	}

	@Override
	public int maxHealPoints() 
	{
		return 40;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" jabs his kris at ");
	}


}//end Gremlin class