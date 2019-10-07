/* ****************************
 * @author Muangkong Yang     *
 * CSCD349 - Design Patterns  *
 * Final Project              *
 ******************************/

package dungeon;

import dungeon.dungeonCharacters.heroes.Hero;

public class Controls 
{
	private static Hero player;
	private static Dungeon map;
	private static final int ROW = 0;
	private static final int COL = 1;
	
	public Controls(Hero thePlayer, Dungeon theMap)
	{
		player = thePlayer;
		map = theMap;
	}
	
	public void controlMenu()
	{
		int choice;
		activateRoom();
		map.setPlayerMap(map.newMap());
		
		do
		{	
			do
			{
				map.printMap(map.getPlayerMap());
				map.printCurrentLocation();
				player.printHeroStats();
				System.out.println("1. North");
				System.out.println("2. East");
				System.out.println("3. West");
				System.out.println("4. South");
				System.out.println("5. Use Item");
				System.out.println("6. Quit Game");
				System.out.print("> ");
				choice = Utils.readInt();
			
				if(choice == 10)
					devMenu();
			
			} while(!ableToMovePlayer(choice));
			
			if(choice == 6)
			{
				System.out.println("You have quitted!");
				break;
			}
			else if(choice == 5)
			{
				if(player.getNumHealingPotions() > 0)
				{
					player.useItem(player);
				}
				else
					System.out.println("No more healing potions!");
			}
			else
			{
				movePlayer(choice);
				activateRoom();
				map.setPlayerMap(map.newMap());
			}
		} while(player.isAlive() && !player.checkVictory());
		
		if(!player.isAlive())
			System.out.println("GAME OVER");
	}
	
	private static boolean ableToMovePlayer(int direction)
	{
		if(direction < 1 || direction > 6)
			return false;
		else if(direction == 1 && map.getHeroLocation(ROW) == 0)
			return false;
		else if(direction == 2 && map.getHeroLocation(COL) == map.getDungeonLength() - 1)
			return false;
		else if(direction == 3 && map.getHeroLocation(COL) == 0)
			return false;
		else if(direction == 4 && map.getHeroLocation(ROW) == map.getDungeonLength() - 1)
			return false;
		else
			return true;
	}
	
	private static void movePlayer(int choice)
	{
		if(choice == 1)
			map.setHeroLocation(new int[] {map.getHeroLocation(ROW) - 1, map.getHeroLocation(COL)});
		else if(choice == 2)
			map.setHeroLocation(new int[] {map.getHeroLocation(ROW), map.getHeroLocation(COL) + 1});
		else if(choice == 3)
			map.setHeroLocation(new int[] {map.getHeroLocation(ROW), map.getHeroLocation(COL) - 1});
		else
			map.setHeroLocation(new int[] {map.getHeroLocation(ROW) + 1, map.getHeroLocation(COL)});
	}
	
	private static void activateRoom()
	{
		map.getDungeonRoom(map.getHeroLocation(ROW), map.getHeroLocation(COL)).isVisited();
		map.getDungeonRoom(map.getHeroLocation(ROW), map.getHeroLocation(COL)).roomEffect();
	}
	
	private static void devMenu()
	{
		int choice;
		do
		{
			System.out.println("-- Developer's Only Cheat Sheet --");
			System.out.println("1. Show Complete Map");
			System.out.println("2. Rejuvenate! (Heals all HP)");
			System.out.println("3. Exit");
			System.out.print("> ");
			choice = Utils.readInt();
			
		} while(choice < 1 || choice > 3);
		
		if(choice == 1)
			map.printMap(map.getCompleteMap());
		else if(choice == 2)
			player.setHitPoints(player.originalHitPoints());
		else
			System.out.flush();
	}
	
}
