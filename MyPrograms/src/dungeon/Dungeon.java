/* ****************************
 * @author Muangkong Yang     *
 * CSCD349 - Design Patterns  *
 * Final Project              *
 ******************************/

package dungeon;

import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.dungeonCharacters.heroes.Hero;
import dungeon.rooms.Room;
import dungeon.rooms.RoomFactory;

import java.util.Arrays;
import java.util.Random;

public class Dungeon 
{
	private DungeonCharacter hero;
	private String completeMap;
	private String playerMap;
	private int[] heroLocation;
	private int[] entranceRoom, exitRoom, pillar1, pillar2, pillar3, pillar4;
	private Room[][] dungeon;
	private final int DEFAULT = 5;
	
	public Dungeon(Hero character, int grid)
	{
		dungeon = theDungeon(grid);
		hero = character;
		determineSpecialRooms();
		heroLocation = entranceRoom;
		createDungeon();
		setPlayerMap(newMap());
	}

	public int getDungeonLength()
	{
		return dungeon.length;
	}
	
	public int getHeroLocation(int rowOrCol) 
	{
		if(rowOrCol == 0)
			return heroLocation[0];
		else
			return heroLocation[1];
	}

	public void setHeroLocation(int[] heroLocation) 
	{
		this.heroLocation = heroLocation;
	}
	
	public Room getDungeonRoom(int row, int col)
	{
		if(row < 0 || row > getDungeonLength())
			throw new IllegalArgumentException("Room row out of range.");
		if(col < 0 || col > getDungeonLength())
			throw new IllegalArgumentException("Room column out of range.");
		
		return dungeon[row][col];
	}
	
	public String getCompleteMap() 
	{
		return completeMap;
	}
	
	private void setCompleteMap(String map) 
	{
		if(map == null || map.isEmpty())
			throw new IllegalArgumentException("Invalid set for map.");
		
		this.completeMap = map;
	}
	
	public String getPlayerMap() 
	{
		return playerMap;
	}

	public void setPlayerMap(String playerMap) 
	{
		if(playerMap == null || playerMap.isEmpty())
			throw new IllegalArgumentException("Invalid hidden map.");
		this.playerMap = playerMap;
	}

	private Room[][] theDungeon(int dimensions)
	{
		if(dimensions < DEFAULT)
			return new Room[DEFAULT][DEFAULT];
		else
			return new Room[dimensions][dimensions];
	}
	
	private void createDungeon()
	{	
		String map = "     ";
		
		for(int i = 0; i < dungeon.length; i++)
		{
			if(i < 10)
				map += i + "   ";
			else
				map += i + "  ";
		}
		map += "\n   ";
		for(int i = 0; i < dungeon.length - 1; i++)
			map += "* * ";
		map += "* * *\n";
		
		for(int row = 0; row < dungeon.length; row++)
		{
			if(row < 10)
				map += " " + row + " *";
			else
				map += row + " *";
		
			for(int col = 0; col < dungeon.length; col++)
			{
				createRoom(row, col);
				if(col == dungeon.length - 1)
					map += " " + dungeon[row][col].toString() + " *\n";
				else
					map += " " + dungeon[row][col].toString() + " |";
				
			}
			
			if(row == dungeon.length - 1)
			{
				map += "   ";
				for(int i = 0; i < dungeon.length - 1; i++)
					map += "* * ";
				map += "* * *\n";
			}
			else
			{
				map += "   ";
				for(int i = 0; i < dungeon.length - 1; i++)
					map += "* - ";
				map += "* - *\n";
			}
		
			setCompleteMap(map);
		}
	}
	
	private void determineSpecialRooms()
	{
		Random rand = new Random(System.currentTimeMillis());

		do
		{
			int entranceRow = rand.nextInt(this.getDungeonLength());
			int entranceCol = rand.nextInt(this.getDungeonLength());
			entranceRoom = new int[] {entranceRow, entranceCol};
			
			int exitRow = rand.nextInt(this.getDungeonLength());
			int exitCol = rand.nextInt(this.getDungeonLength());
			exitRoom = new int[] {exitRow, exitCol};
			
			int pillar1Row = rand.nextInt(this.getDungeonLength());
			int pillar1Col = rand.nextInt(this.getDungeonLength());
			pillar1 = new int[] {pillar1Row, pillar1Col};
			
			int pillar2Row = rand.nextInt(this.getDungeonLength());
			int pillar2Col = rand.nextInt(this.getDungeonLength());
			pillar2 = new int[] {pillar2Row, pillar2Col};
			
			int pillar3Row = rand.nextInt(this.getDungeonLength());
			int pillar3Col = rand.nextInt(this.getDungeonLength());
			pillar3 = new int[] {pillar3Row, pillar3Col};
			
			int pillar4Row = rand.nextInt(this.getDungeonLength());
			int pillar4Col = rand.nextInt(this.getDungeonLength());
			pillar4 = new int[] {pillar4Row, pillar4Col};
			
		} while ((Arrays.equals(entranceRoom, exitRoom) && Arrays.equals(entranceRoom, pillar1) && Arrays.equals(entranceRoom, pillar2) && Arrays.equals(entranceRoom, pillar3) && Arrays.equals(entranceRoom, pillar4)) ||
				 (Arrays.equals(exitRoom, pillar1) && Arrays.equals(exitRoom, pillar2) && Arrays.equals(exitRoom, pillar3) && Arrays.equals(exitRoom, pillar4)) ||
				 (Arrays.equals(pillar1, pillar2) && Arrays.equals(pillar1, pillar3) && Arrays.equals(pillar1, pillar4)) ||
				 (Arrays.equals(pillar2, pillar3) && Arrays.equals(pillar2, pillar4)) ||
				 (Arrays.equals(pillar3, pillar4)));
	}
	
	private void createRoom(int row, int col)
	{
		RoomFactory rf = new RoomFactory();
		
		int regularRoomType = 0;
		int entranceRoomType = 1;
		int exitRoomType = 2;
		int pillarRoomType = 3;
		
		if(row == entranceRoom[0] && col == entranceRoom[1])
			dungeon[row][col] = rf.generateRoom(hero, entranceRoomType);
		else if(row == exitRoom[0] && col == exitRoom[1])
			dungeon[row][col] = rf.generateRoom(hero, exitRoomType);
		else if(row == pillar1[0] && col == pillar1[1])
			dungeon[row][col] = rf.generateRoom(hero, pillarRoomType);
		else if(row == pillar2[0] && col == pillar2[1])
			dungeon[row][col] = rf.generateRoom(hero, pillarRoomType);
		else if(row == pillar3[0] && col == pillar3[1])
			dungeon[row][col] = rf.generateRoom(hero, pillarRoomType);
		else if(row == pillar4[0] && col == pillar4[1])
			dungeon[row][col] = rf.generateRoom(hero, pillarRoomType);
		else
			dungeon[row][col] = rf.generateRoom(hero, regularRoomType);
	}
	
	public void printMap(String map)
	{
		System.out.println(map);
	}
	
	public void printCurrentLocation()
	{
		System.out.println("Current Room: " + getHeroLocation(0) + "," + getHeroLocation(1));
	}
	
	public String newMap()
	{
		String map = "     ";
		
		for(int i = 0; i < dungeon.length; i++)
		{
			if(i < 10)
				map += i + "   ";
			else
				map += i + "  ";
		}
		map += "\n   ";
		for(int i = 0; i < dungeon.length - 1; i++)
			map += "* * ";
		map += "* * *\n";
		
		for(int row = 0; row < dungeon.length; row++)
		{
			if(row < 10)
				map += " " + row + " *";
			else
				map += row + " *";
		
			for(int col = 0; col < dungeon.length; col++)
			{
				if(row == getHeroLocation(0) && col == getHeroLocation(1))
				{
					map += "(";
					if(dungeon[row][col].hasVisited())
					{
						if(col == dungeon.length - 1)
							map += dungeon[row][col].toString() + ")*\n";
						else
							map += dungeon[row][col].toString() + ")|";
					}
					else if(col == dungeon.length - 1)
						map += " " + ")*\n";
					else
						map += " " + ")|";
				}
				else
				{
					if(dungeon[row][col].hasVisited())
					{
						if(col == dungeon.length - 1)
							map += " " + dungeon[row][col].toString() + " *\n";
						else	
							map += " " + dungeon[row][col].toString() + " |";
					}
					else if(col == dungeon.length - 1)
						map += "  " + " *\n";
					else
						map += "  " + " |";
				}
			}
			
			if(row == dungeon.length - 1)
			{
				map += "   ";
				for(int i = 0; i < dungeon.length - 1; i++)
					map += "* * ";
				map += "* * *\n";
			}
			else
			{
				map += "   ";
				for(int i = 0; i < dungeon.length - 1; i++)
					map += "* - ";
				map += "* - *\n";
			}
		}
		
		return map;
	}
}
