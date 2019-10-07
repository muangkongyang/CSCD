package dungeon.rooms;

import dungeon.Utils;
import dungeon.dungeonCharacters.DungeonCharacter;
import dungeon.dungeonCharacters.heroes.Hero;

public class MultipleRoom extends Room 
{	
	private int numHealingPotion = 1;
	
	public MultipleRoom(DungeonCharacter hero) 
	{
		super(hero);
	}

	@Override
	public String type() 
	{	
		return "M";
	}
	
	private int getNumHealingPotion() 
	{
		return numHealingPotion;
	}

	private void setNumHealingPotion(int numHealingPotion) 
	{
		this.numHealingPotion = numHealingPotion;
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
		
		System.out.println("You fell into a pit!");
		int pitDamage = Utils.randInt(20) + 1;
		System.out.println(super.getHero().getName() + " takes <" + pitDamage + "> points of damage.");
		
		super.getHero().setHitPoints(super.getHero().getHitPoints() - pitDamage);
	}
}
