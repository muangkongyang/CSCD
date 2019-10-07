package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;

public class RoomFactory
{
	public Room generateRoom(DungeonCharacter hero, int type)
	{
		double chance = Math.random();
		
		if(type == 1)
			return EntranceRoom.getEntranceInstance(hero);
		else if(type == 2)
			return ExitRoom.getExitInstance(hero);
		else if(type == 3)
			return new PillarsRoom(hero);
		else
		{
			if(chance <= 0.1)
				return new PitRoom(hero);
			else if(chance >= 0.2 && chance < 0.3)
				return new HealingPotionRoom(hero);
			else if(chance >= 0.3 && chance < 0.4)
				return new MonsterRoom(hero);
			else if(chance >= 0.4 && chance < 0.5)
				return new MultipleRoom(hero);
			else
				return new EmptyRoom(hero);
		}
	}
}
