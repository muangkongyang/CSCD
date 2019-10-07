package dungeon.rooms;

import dungeon.Utils;
import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.dungeonCharacters.heroes.Hero;
import dungeon.dungeonCharacters.monsters.Monster;
import dungeon.dungeonCharacters.monsters.MonsterFactory;

public class MonsterRoom extends Room 
{	
	private MonsterFactory monster = new MonsterFactory();
	private int numOfMonsterTypes = 5;
	
	public MonsterRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	@Override
	public String type() 
	{	
		return "X";
	}
	
	@Override
	public void effect() 
	{
		Monster theMonster = randomMonster(monster);
		battle(((Hero) super.getHero()), theMonster);
	}
	
	private Monster randomMonster(MonsterFactory monsterFactory)
	{
		int choice;

		choice = (int)(Math.random() * this.numOfMonsterTypes) + 1;
		
		return monsterFactory.generateMonster(choice);
	}
	
	private void battle(Hero theHero, Monster theMonster)
	{
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive())
		{
		    //hero goes first
			theHero.battleChoices(theMonster);
			
			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

		}//end battle loop

		if (!theMonster.isAlive())
		{
		    System.out.println(theHero.getName() + " was victorious!");
		    if(Math.random() <= 0.1)
		    {
		    	System.out.println(theMonster.getName() + " drops a healing potion!");
		    	theHero.setNumHealingPotions(theHero.getNumHealingPotions() + 1);
		    }
		}
		else
			System.out.println(theHero.getName() + " was defeated :-(");

	}//end battle method
	
	private boolean quit()
	{
		String quit = "p";
		System.out.print("\n-->q to quit, anything else to continue: ");
		quit = Utils.readString();

		return (quit.equalsIgnoreCase("q"));
	}//end quit method
}
