import holiday_decorations.*;
import holiday_decorations.Trees.*;
import holiday_decorations.TreeDecorations.*;

// Only one tree decorated at a time
// Star instance will reset after the
// tree is finished with decorations.
public class TreeTester 
{
	public static void main(String[] args) 
	{
		HolidayTree myTree = new FraserFir();
		myTree = myTree.checkStar(myTree);
		myTree = new Ruffles(myTree);
		myTree = myTree.checkStar(myTree);
		myTree = new RedBalls(myTree);
		myTree = new BlueBalls(myTree);
		myTree = new SilverBalls(myTree);
		myTree = new Ribbons(myTree);
		myTree = new Lights(myTree);
		myTree = new LEDs(myTree);
		myTree.print();
		
		HolidayTree myTree2 = new DouglasFir();
		myTree2 = new Ruffles(myTree2);
		myTree2 = new RedBalls(myTree2);
		myTree2 = new BlueBalls(myTree2);
		myTree2 = new SilverBalls(myTree2);
		myTree2 = new Ribbons(myTree2);
		myTree2 = new Lights(myTree2);
		myTree2 = new LEDs(myTree2);
		myTree2 = myTree2.checkStar(myTree2);
		myTree2.print();
		
		HolidayTree myTree3 = new BalsamFir();
		myTree3 = myTree3.checkStar(myTree3);
		myTree3 = new Ruffles(myTree3);
		myTree3 = new Lights(myTree3);
		myTree3 = new RedBalls(myTree3);
		myTree3 = myTree3.checkStar(myTree3);
		myTree3 = new LEDs(myTree3);
		myTree3 = new BlueBalls(myTree3);
		myTree3 = new Ribbons(myTree3);
		myTree3 = new Lights(myTree3);
		myTree3 = new LEDs(myTree3);
		myTree3.print();
		
		HolidayTree myTree4 = new ColoradoBlueSpruce();
		myTree4 = new Ruffles(myTree4);
		myTree4 = new Lights(myTree4);
		myTree4 = new RedBalls(myTree4);
		myTree4 = new LEDs(myTree4);
		myTree4 = new Ribbons(myTree4);
		myTree4 = myTree4.checkStar(myTree4);
		myTree4 = new BlueBalls(myTree4);
		myTree4 = new Lights(myTree4);
		myTree4 = new Ribbons(myTree4);
		myTree4 = new Lights(myTree4);
		myTree4 = new LEDs(myTree4);
		myTree4 = new Ruffles(myTree4);
		myTree4 = new Lights(myTree4);
		myTree4 = new Ruffles(myTree4);
		myTree4 = new Lights(myTree4);
		myTree4 = new Ribbons(myTree4);
		myTree4.print();
	}
}
