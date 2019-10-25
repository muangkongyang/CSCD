package GuitarHero.Solos;
import GuitarHero.SoloBehavior;

public class SmashTheGuitar implements SoloBehavior 
{	
	@Override
	public String theSolo()
	{
		return this.getClass().getSimpleName();
	}
}
