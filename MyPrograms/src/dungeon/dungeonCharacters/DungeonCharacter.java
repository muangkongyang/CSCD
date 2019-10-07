/* ****************************
 * @author Muangkong Yang     *
 * CSCD349 - Design Patterns  *
 * Final Project              *
 ******************************/

package dungeon.dungeonCharacters;

import dungeon.dungeonCharacters.heroes.Hero;
import dungeon.dungeonCharacters.monsters.Monster;
import dungeon.rooms.potions.HealingPotion;
import dungeon.rooms.potions.Potions;

public abstract class DungeonCharacter 
{
	// All Heroes and Monsters have these abstract attributes
	public abstract int originalHitPoints();
	public abstract int attackSpeed();
	public abstract double chanceToHit();
	public abstract int damageMin();
	public abstract int damageMax();
	public abstract void attackMotion();
	
	private String name;
	private int hitPoints;
	private int numTurns;
	private boolean victory;
	private Potions potion;
	
	public DungeonCharacter(final String name, int hitPoints)
	{
		setName(name);
		setHitPoints(hitPoints);
		setNumTurns(1);
		potion = new HealingPotion(this);
	}
	
	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		if(name == null)
			throw new IllegalArgumentException("Hero name is null.");
		if(name.isEmpty())
			throw new IllegalArgumentException("Hero name is empty.");
				
		this.name = name;
	}
	
	public int getHitPoints() 
	{
		return this.hitPoints;
	}

	public void setHitPoints(int hitPoints) 
	{
		if(hitPoints < 0)
			this.hitPoints = 0;
		else if(hitPoints > this.originalHitPoints())
			this.hitPoints = this.originalHitPoints();
		else
			this.hitPoints = hitPoints;
	}
	
	public int getNumTurns() 
	{
		return numTurns;
	}
	
	public void setNumTurns(int numTurns) 
	{
		if(numTurns < 0)
			numTurns = 0;
		
		this.numTurns = numTurns;
	}
	
	public boolean isAlive()
	{
		return this.getHitPoints() > 0;
	}

	public boolean checkVictory() 
	{
		return victory;
	}
	
	public void setVictory() 
	{
		this.victory = true;
	}
	
	public int calculateTurns(DungeonCharacter character)
	{
		int numTurns = this.attackSpeed()/character.attackSpeed();
		if (numTurns == 0)
			numTurns++;
		this.setNumTurns(numTurns);
		
		System.out.println("Number of turns this round is: " + this.getNumTurns());
		
		return this.getNumTurns();
	}
	
	public void attack(DungeonCharacter character)
	{
		boolean canAttack;
		int damage = 0;
		
		canAttack = Math.random() <= chanceToHit();

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageMax() - damageMin() + 1))
						+ damageMin();
			System.out.print(this.getName());
			this.attackMotion();
			System.out.println(character.getName() + ":");
			this.subtractHitPoints(character, damage);
			
		}//end if can attack
		else
		{
			System.out.println(this.getName() + "'s attack on " + character.getName() +
								" failed!");
			System.out.println();
		}//end else
		
	}
	
	public void subtractHitPoints(DungeonCharacter character, int damage)
	{
		if (character.hitPoints < 0)
			System.out.println("Hitpoint amount must be positive.");
		else if (this.hitPoints > 0)
		{
			int tempHitPoints = character.hitPoints - damage;
			character.setHitPoints(tempHitPoints);
			System.out.println(getName() + " hit " + character.getName() +
								" for <" + damage + "> points damage.");
			System.out.println(character.getName() + " now has " +
								character.getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if
		
		if(character instanceof Monster && character.isAlive())
			((Monster) character).heal();
		
		if (character.hitPoints == 0)
			System.out.println(character.getName() + " has been killed :-(");
	}
	
	public void addHealPoints(int healPoints)
	{
		if (this.getHitPoints() <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			int tempHP = 0;
			tempHP = this.getHitPoints() + healPoints;
			this.setHitPoints(tempHP);
			System.out.println(this.getName() + " recovers <" + healPoints + "> amount of hit points.");
		}
	}
	
	public void useItem(DungeonCharacter character)
	{
		if(character instanceof Hero)
		{
			((Hero) character).setNumHealingPotions(((Hero) character).getNumHealingPotions() - 1);
			potion.potionEffect(character);
		}
	}
}
