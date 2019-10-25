public abstract class DungeonCharacter 
{
	// Refactor 2
	// All Heroes and Monsters have these abstract attributes
	public abstract int originalHitPoints();
	public abstract int attackSpeed();
	public abstract double chanceToHit();
	public abstract int damageMin();
	public abstract int damageMax();
	public abstract void attackMotion();
	
	// Refactor 1
	private String name;
	private int hitPoints;
	private int numTurns;
	private boolean isAlive;
	
	public DungeonCharacter(final String name, int hitPoints)
	{
		setName(name);
		setHitPoints(hitPoints);
		setNumTurns(1);
		this.isAlive = true;
		
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
	
	// Refactor 6
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
	
	// Refactor 10
	public boolean isAlive()
	{
		if(this.getHitPoints() == 0)
			this.isAlive = false;
		
		return this.isAlive;
	}

	// Refactor 9
	public int calculateTurns(DungeonCharacter character)
	{
		int numTurns = this.attackSpeed()/character.attackSpeed();
		if (numTurns == 0)
			numTurns++;
		this.setNumTurns(numTurns);
		
		System.out.println("Number of turns this round is: " + this.getNumTurns());
		
		return this.getNumTurns();
	}
	
	// Refactor 8
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
	
	// Refactor 7
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
	
	// Refactor 6
	public void addHealPoints(int healPoints)
	{
		if (this.getHitPoints() <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			int tempHP = 0;
			tempHP = this.getHitPoints() + healPoints;
			this.setHitPoints(tempHP);
		}
	}
}
