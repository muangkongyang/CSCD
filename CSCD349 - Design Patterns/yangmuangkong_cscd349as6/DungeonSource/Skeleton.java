public class Skeleton extends Monster
{
	public Skeleton()
	{
		super("Sargath the Skeleton", 100);

    }//end constructor

	@Override
	public int originalHitPoints() 
	{
		return 100;
	}

	@Override
	public int attackSpeed() 
	{
		return 3;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.8;
	}

	@Override
	public int damageMin() 
	{
		return 30;
	}

	@Override
	public int damageMax() 
	{
		return 50;
	}

	@Override
	public double chanceToHeal() 
	{
		return 0.3;
	}

	@Override
	public int minHealPoints() 
	{
		return 30;
	}

	@Override
	public int maxHealPoints() 
	{
		return 50;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" slices his rusty blade at ");
	}


}//end Skeleton class