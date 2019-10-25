// Refactor 2
public abstract class Hero extends DungeonCharacter
{	
	// Some unique functions for Heroes only that differ
	// List them here:
	public abstract void commandMenu();
	public abstract double chanceToBlock();
	public abstract void special(DungeonCharacter character);
	
	public Hero(String name, int hitPoints) 
	{
		super(name, hitPoints);
	}
	
	// Refactor 4, 9
	public void battleChoices(DungeonCharacter character)
	{
		int choice;
		this.calculateTurns(character);

		do
		{
			choice = heroMenu();
			System.out.println();
			
			switch (choice)
			{
				case 1: attack(character);
				    break;
				case 2: special(character);
				    break;
		    }//end switch
			
			// Refactor 10
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
	
	// Refactor 4
	public int heroMenu()
	{
		int choice;
		this.commandMenu();
		System.out.print("Choose an option: ");
		do
		{
			choice = Utils.readInt();
		} while(choice < 1 || choice > 2);
		
		return choice;
	}
}//end Hero class