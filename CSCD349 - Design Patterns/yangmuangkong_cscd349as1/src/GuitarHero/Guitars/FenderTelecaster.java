package GuitarHero.Guitars;
import GuitarHero.GuitarBehavior;

public class FenderTelecaster implements GuitarBehavior
{
	@Override
	public String theGuitar() 
	{
		return this.getClass().getSimpleName();
	}
}
