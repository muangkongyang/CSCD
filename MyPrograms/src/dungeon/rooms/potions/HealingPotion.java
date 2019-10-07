package dungeon.rooms.potions;
import dungeon.Utils;
import dungeon.dungeonCharacters.DungeonCharacter;

public class HealingPotion extends Potions
{
	public HealingPotion(DungeonCharacter character) 
	{
		super(character);
	}

	@Override
	public String potionType() 
	{
		return "Healing Potion";
	}

	@Override
	public void potionEffect(DungeonCharacter character) 
	{
		System.out.println("The healing potion takes effect.");
		int healAmount = Utils.randInt(11) + 5;
		character.addHealPoints(healAmount);
	}
}
