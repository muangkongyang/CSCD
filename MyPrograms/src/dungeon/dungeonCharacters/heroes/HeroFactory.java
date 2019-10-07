package dungeon.dungeonCharacters.heroes;

public class HeroFactory
{
	public Hero createHeroClass(final String characterName, int type)
	{
		if(type == 1)
			return new Warrior(characterName);
		else if(type == 2)
			return new Sorceress(characterName);
		else if(type == 3)
			return new Thief(characterName);
		else
			return new Gunner(characterName);
	}
}
