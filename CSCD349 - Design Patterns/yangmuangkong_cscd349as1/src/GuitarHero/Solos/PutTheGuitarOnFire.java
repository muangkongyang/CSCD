package GuitarHero.Solos;
import GuitarHero.SoloBehavior;

public class PutTheGuitarOnFire implements SoloBehavior 
{
	@Override
	public String theSolo()
	{
		return this.getClass().getSimpleName();
	}
}
