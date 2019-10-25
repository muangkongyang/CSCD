package GuitarHero;
import GuitarHero.GameCharacters.*;
import GuitarHero.Guitars.*;
import GuitarHero.Solos.*;

public class GuitarHero
{
	public static void main(String[] args) 
	{	
		GameCharacter player1 = new GameCharacterHendrix();
		GameCharacter player2 = new GameCharacterSlash();
		GameCharacter player3 = new GameCharacterAngusYoung();
		
		player1.playGuitar();
		player1.playSolo();
		player2.playGuitar();
		player2.playSolo();
		player3.playGuitar();
		player3.playSolo();
		
		player1.setGuitar((GuitarBehavior) new FenderTelecaster());
		player1.setSolo((SoloBehavior) new JumpOffTheStage()); 
		player1.playGuitar();
		player1.playSolo();
		
		player2.setGuitar((GuitarBehavior) new GibsonFlyingV());
		player2.setSolo((SoloBehavior) new SmashTheGuitar()); 
		player2.playGuitar();
		player2.playSolo();
		
		player3.setSolo((SoloBehavior) new JumpOffTheStage());
		player3.playGuitar();
		player3.playSolo();
		
	}

}
