public class Dungeon 
{
	public static void main(String[] args)
	{
		Hero theHero;
		Monster theMonster;
		HeroFactory heroFactory = new HeroFactory();
		MonsterFactory monsterFactory = new MonsterFactory();
		
		do
		{
		    theHero = chooseHero(heroFactory);
		    theMonster = randomMonster(monsterFactory);
			battle(theHero, theMonster);

		} while (playAgain());

    }//end main method
	
	// Refactor 5
	public static Hero chooseHero(HeroFactory heroFactory)
	{
		int choice;

		System.out.println("Choose a hero:\n" +
						   "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		do
		{
			choice = Utils.readInt();
		} while(choice < 1 || choice > 3);
		
		System.out.print("Enter character name: ");
		String characterName = Utils.readString();
		
		return heroFactory.createHeroClass(characterName, choice);
	}
	
	public static Monster randomMonster(MonsterFactory monsterFactory)
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;
		
		return monsterFactory.generateMonster(choice);
	}
	
	public static boolean playAgain()
	{
		String again;

		System.out.println("Play again (y/n)?");
		do 
		{
			again = Utils.readString();
		} while(!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n"));
		
		return (again.equalsIgnoreCase("y"));
	}//end playAgain method
	
	public static boolean quit()
	{
		String quit = "p";
		System.out.print("\n-->q to quit, anything else to continue: ");
		quit = Utils.readString();

		return (quit.equalsIgnoreCase("q"));
	}//end quit method
	
	public static void battle(Hero theHero, Monster theMonster)
	{
		boolean quit = false;
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && !quit)
		{
		    //hero goes first
			theHero.battleChoices(theMonster);
			
			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			quit = quit();

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method
}
