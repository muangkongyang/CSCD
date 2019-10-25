package GuitarHero.Guitars;
import GuitarHero.GuitarBehavior;

public class GibsonSG implements GuitarBehavior
{	
	@Override
	public String theGuitar() 
	{
		return this.getClass().getSimpleName();
	}
	
}
