package dungeon.rooms.potions;

import dungeon.dungeonCharacters.DungeonCharacter;

public abstract class Potions 
{
	public abstract String potionType();
	public abstract void potionEffect(DungeonCharacter character);
	@SuppressWarnings("unused")
	private DungeonCharacter character;
	
	public Potions(DungeonCharacter character)
	{
		this.character = character;
	}
}
