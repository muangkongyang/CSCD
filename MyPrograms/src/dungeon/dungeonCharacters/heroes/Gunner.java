package dungeon.dungeonCharacters.heroes;

import dungeon.dungeonCharacters.DungeonCharacter;

public class Gunner extends Hero
{	
	public Gunner(final String name) 
	{
		super(name, 90);
	}
	
	@Override
	public int originalHitPoints()
	{
		return 90;
	}
	
	@Override
	public int attackSpeed() 
	{
		return 6;
	}

	@Override
	public double chanceToHit() 
	{
		return 0.9;
	}

	@Override
	public int damageMin() 
	{
		return 15;
	}

	@Override
	public int damageMax() 
	{
		return 40;
	}
	
	@Override
	public double chanceToBlock() 
	{
		return 0.25;
	}

	@Override
	public void attackMotion() 
	{
		System.out.print(" takes position and shoots at ");
	}
	
	@Override
	public void special(DungeonCharacter character) 
	{	
		int damage = 0;
		if(character.getHitPoints() <= character.originalHitPoints()/2)
		{
			damage = (int)(Math.random() * (damageMax() - damageMin()) + damageMin()) * 2;
			System.out.println(this.getName() + " shotgun blasts at the weakened " + character.getName() +
								" for <" + damage + "> points of damage!");
			subtractHitPoints(character, damage);
		}
		else
		{
			damage = (int)(Math.random() * (damageMax() - damageMin()) + damageMin()) * 1/2;
			System.out.println(this.getName() + " shotgun blasts at " + character.getName() + 
								" but it quickly moves avoiding most pellets taking only <" + damage + "> points of damage!");
			subtractHitPoints(character, damage);
		}
			
	}

	@Override
	public void commandMenu() 
	{
		System.out.println("1. Attack Opponent");
		System.out.println("2. Shotgun Blast");
		System.out.println("3. Use Item");
	}

}//end Hero class