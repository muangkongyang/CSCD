package GuitarHero.Guitars;
import GuitarHero.GuitarBehavior;

public class GibsonFlyingV implements GuitarBehavior
{
	@Override
	public String theGuitar() 
	{
		return this.getClass().getSimpleName();
	}
}
