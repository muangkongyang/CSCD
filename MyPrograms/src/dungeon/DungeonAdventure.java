package dungeon;

import dungeon.dungeonCharacters.heroes.*;
import dungeon.dungeonCharacters.monsters.*;

/* ****************************
 * @author Muangkong Yang     *
 * CSCD349 - Design Patterns  *
 * Final Project              *
 ******************************/

public class DungeonAdventure
{
	public static void main(String[] args)
	{
		instructions();
		
		HeroFactory heroFactory = new HeroFactory();
		Hero theHero;
		Dungeon map;
		Controls control;
		int dimensions;
		
		do
		{
			theHero = chooseHero(heroFactory);
			dimensions = userChoiceMap();
			map = new Dungeon(theHero, dimensions);
			control = new Controls(theHero, map);
		    control.controlMenu();
		    System.out.println("-- Dungeon Map -- ");
		    map.printMap(map.getCompleteMap());
		} while (playAgain());
		
		
		System.out.println("Play again next time!");
    }//end main method

	private static void instructions() 
	{
		System.out.println("\t\t\t--------------------------\n");
		System.out.println("\t\t\t- THE FOUR PILLARS OF OO -\n");
		System.out.println("\t\t\t--------------------------\n");
		System.out.println();
		System.out.println("Welcome to this Dungeon Adventure. Your goal is to navigate through the dungeon\n");
		System.out.println("and find the pillars of OO. You will need to gather all four pillar pieces and \n");
		System.out.println("bring them to the exit room. Exit room is indicated by the symbol 'O'.\n");
		System.out.println("A game over is achieved anytime your hero's hitpoints reaches 0.\n\n");
		System.out.println("There will be rooms that will hinder your process, and also rooms that\n");
		System.out.println("are beneficial for you. BE AWARE OF MONSTERS! You cannot run when battling.\n");
		System.out.println("Your current location in the dungeon will be marked with parenthesis () around\n");
		System.out.println("the symbol of the room. (e.g. (E) for empty room)\n");
		System.out.println("--GETTING STARTED--\n");
		System.out.println("You will first be prompted to create a dungeon size of 5x5 to 25x25 of your\n");
		System.out.println("choice. Then you will create your hero and will be ready to begin. Each hero\n");
		System.out.println("class has their own unique abilities. Be sure to test them all out! Have fun!\n");
		System.out.println();
		System.out.println("--FOR DEVELOPERS ONLY--\n");
		System.out.println("You can open the developer's cheat sheet by inputting in the number '10' when\n");
		System.out.println("determining your next move. There are currently two options.\n");
		System.out.println("1. Show the complete dungeon map\n");
		System.out.println("2. Recover all of your HP\n");
		
		System.out.println();
		System.out.print("Press any button to continue...");
		Utils.readString();
		System.out.flush();
	}

	private static int userChoiceMap() 
	{
		int choice;
		
		System.out.print("Enter wanted dungeon size (5 - 25):");
		do
		{
			choice = Utils.readInt();
		} while(choice < 5 || choice > 25);
		
		return choice;
	}
	
	private static Hero chooseHero(HeroFactory heroFactory)
	{
		int choice;

		System.out.println("Choose a hero:\n" +
						   "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "4. Gunner");
		System.out.print("> ");
		
		do
		{
			choice = Utils.readInt();
		} while(choice < 1 || choice > 4);
		
		System.out.print("Enter character name: ");
		String characterName = Utils.readString();
		
		return heroFactory.createHeroClass(characterName, choice);
	}
	
	private static boolean playAgain()
	{
		String again;

		System.out.println("Play again (y/n)?");
		do 
		{
			again = Utils.readString();
		} while(!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n"));
		
		return (again.equalsIgnoreCase("y"));
	}//end playAgain method
	
}
