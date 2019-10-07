package dungeon.dungeonCharacters.heroes;

import dungeon.Utils;
import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.rooms.potions.HealingPotion;
import dungeon.rooms.potions.Potions;

public abstract class Hero extends DungeonCharacter
{	
	public abstract void commandMenu();
	public abstract double chanceToBlock();
	public abstract void special(DungeonCharacter character);
	
	private Potions healPots;
	private int numHealingPotions;
	private int numVisionPotions;
	private int numPillars;
	
	public Hero(String name, int hitPoints) 
	{
		super(name, hitPoints);
		setNumHealingPotions(0);
		setNumVisionPotions(0);
		setNumPillars(0);
		healPots = new HealingPotion(this);
	}
	
	public int getNumHealingPotions() 
	{
		return this.numHealingPotions;
	}
	
	public void setNumHealingPotions(int numHealingPotions) 
	{
		if(numHealingPotions < 0)
			this.numHealingPotions = 0;
		
		this.numHealingPotions = numHealingPotions;
	}
	
	public int getNumVisionPotions() 
	{
		return this.numVisionPotions;
	}
	
	public void setNumVisionPotions(int numVisionPotions) 
	{
		if(numVisionPotions < 0)
			this.numVisionPotions = 0;
		
		this.numVisionPotions = numVisionPotions;
	}
	
	public int getNumPillars() 
	{
		return this.numPillars;
	}
	
	public void setNumPillars(int numPillars) 
	{
		if(numPillars < 0 || numPillars > 4)
			throw new IllegalArgumentException("Invalid number of pillars.");
		
		this.numPillars = numPillars;
	}
	
	public void battleChoices(DungeonCharacter character)
	{
		int choice;
		this.calculateTurns(character);

		do
		{
			System.out.println(this.getHitPoints() + "/" + this.originalHitPoints());
			choice = heroMenu();
			System.out.println();
			
			switch (choice)
			{
				case 1: attack(character);
				    break;
				case 2: special(character);
				    break;
				case 3: 
					itemMenu();
					break;
		    }//end switch
			
			if(character.isAlive())
			{
				this.setNumTurns(this.getNumTurns() - 1);
				if (this.getNumTurns() > 0)
					System.out.println("Number of turns remaining is: " + this.getNumTurns());	
			}
			else
				this.setNumTurns(0);

		} while(this.getNumTurns() > 0);

	}//end battleChoices method
	 
	public boolean defend()
	{
		return Math.random() <= chanceToBlock();
	}//end defend method
	
	private int heroMenu()
	{
		int choice;
		this.commandMenu();
		System.out.print("Choose an option: ");
		do
		{
			choice = Utils.readInt();
		} while(choice < 1 || choice > 3);
		
		return choice;
	}
	
	private void itemMenu()
	{
		int choice;
		
		do
		{
			System.out.println("-- Items --");
			System.out.println("1. Healing Potion x" + this.getNumHealingPotions());
			System.out.println("2. Back");
			System.out.print("> ");
			choice = Utils.readInt();
			
			if(choice == 1 && this.getNumHealingPotions() == 0)
				choice = 2;
			
		} while(choice != 1 && choice != 2);
		
		if(choice == 1)
			super.useItem(this);
		else
			System.out.println("No more healing potions!");
	}
	
	public String toString()
	{
		String info = this.getName() + " (" + this.getClass().getSimpleName() + ")\n";
		info += "HP: " + this.getHitPoints() + "/" + this.originalHitPoints() + "\n";
		info += "Healing Potions: " + this.getNumHealingPotions() + "\n";
		info += "Vision Potions: " + this.getNumVisionPotions() + "\n";
		info += "Pillars of OO: " + this.getNumPillars() + "/4";
		
		return info;
	}
	
	public void printHeroStats()
	{
		System.out.println(this.toString());
	}
}//end Hero class