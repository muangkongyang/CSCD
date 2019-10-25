package GuitarHero.Solos;
import GuitarHero.SoloBehavior;

public class JumpOffTheStage implements SoloBehavior 
{
	@Override
	public String theSolo()
	{
		return this.getClass().getSimpleName();
	}
}
