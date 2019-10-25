public class MonsterFactory
{
	public Monster generateMonster(int type)
	{
		if(type == 1)
			return new Ogre();
		else if(type == 2)
			return new Gremlin();
		else
			return new Skeleton();
	}
}
