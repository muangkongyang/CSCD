package dungeon.rooms;

import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.dungeonCharacters.heroes.Hero;

public class HealingPotionRoom extends Room 
{
	private int numHealingPotion = 1;

	public HealingPotionRoom(DungeonCharacter hero) 
	{
		super(hero);
	}
	
	@Override
	public String type() 
	{	
		return "H";
	}
	
	private int getNumHealingPotion() 
	{
		return numHealingPotion;
	}

	private void setNumHealingPotion(int numPotion) 
	{	
		this.numHealingPotion = numPotion;
	}
	
	@Override
	public void effect() 
	{
		if(this.getNumHealingPotion() == 1)
		{
			System.out.println(getHero().getName() + " picks up a healing potion!");
			this.setNumHealingPotion(this.getNumHealingPotion() - 1);
			((Hero) super.getHero()).setNumHealingPotions(((Hero) super.getHero()).getNumHealingPotions() + 1);
		}
	}
}
