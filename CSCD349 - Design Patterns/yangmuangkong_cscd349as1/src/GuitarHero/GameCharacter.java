package GuitarHero;
import GuitarHero.Guitars.*;
import GuitarHero.Solos.*;

public abstract class GameCharacter
{
	private GuitarBehavior guitar;
	private SoloBehavior solo;
	private String name;
	
	// Sets to a default guitar and solo
	public GameCharacter(String name)
	{
		this.name = name;
		this.guitar = (GuitarBehavior) new GibsonSG();
		this.solo = (SoloBehavior) new PutTheGuitarOnFire();
	}
	
	public GuitarBehavior getGuitar()
	{
		return this.guitar;
	}
	
	public void setGuitar(GuitarBehavior guitar)
	{
		if(guitar == null)
			throw new IllegalArgumentException("Guitar is invalid.");
		
		this.guitar = guitar;
	}
	
    public SoloBehavior getSolo()
    {
    	return this.solo;
    }
    
	public void setSolo(SoloBehavior solo)
	{
		if(solo == null)
			throw new IllegalArgumentException("Solo is invalid.");
		
		this.solo = solo;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void playGuitar()
	{
		System.out.println(this.getName() + " is playing with the " + getGuitar().theGuitar() + " guitar.");
	}
	
	public void playSolo()
	{
		System.out.println(this.getName() + " plays '" + getSolo().theSolo() + "' solo.");
	}
}
