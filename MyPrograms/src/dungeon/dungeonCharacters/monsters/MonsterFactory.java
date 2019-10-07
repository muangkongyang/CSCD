package dungeon.dungeonCharacters.monsters;

public class MonsterFactory
{
	public Monster generateMonster(int type)
	{
		if(type == 1)
			return new Ogre();
		else if(type == 2)
			return new Gremlin();
		else if(type == 3)
			return new Skeleton();
		else if(type == 4)
			return new Witch();
		else
			return new Dullahan();
	}
}
