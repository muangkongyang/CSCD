package dungeon.dungeonCharacters.monsters;

public class Ogre extends Monster
{
    public Ogre()
	{
		super("Oscar the Ogre", 200);

    }//end constructor

	@Override
	public int originalHitPoints() 
	{
		return 200;
	}

	@Override
	public int attackSpeed() 
	{
		return 2;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.6;
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
		return 0.1;
	}

	@Override
	public int minHealPoints() 
	{
		return 30;
	}

	@Override
	public int maxHealPoints() 
	{
		return 60;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" slowly swings a club toward's ");
	}


}//end Ogre class