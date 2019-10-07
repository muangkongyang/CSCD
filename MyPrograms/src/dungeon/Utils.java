/* ****************************
 * @author Muangkong Yang     *
 * CSCD349 - Design Patterns  *
 * Final Project              *
 ******************************/

package dungeon;

import java.util.*;

public class Utils 
{
	static Scanner kb = new Scanner(System.in);
	static Random rand = new Random(System.currentTimeMillis());
	
	public static int readInt()
	{
		int num = 0;
		do 
		{
			try
			{
				num = Integer.parseInt(kb.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.print("Not a number.\nChoose an option: ");
			}
		} while(num < 1 || num > 100);
		return num;
	}
	
	public static double readDouble()
	{
		double num = 0.0;
		
		do 
		{
			try
			{
				num = Double.parseDouble(kb.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.print("Not a double.\nChoose a option: ");
			}
		} while(num < 1.0 || num > 10.0);
		
		return num;
	}
	
	public static String readString()
	{
		String word = "";
		word = kb.nextLine();
		return word;
	}
	
	public static int randInt()
	{
		return rand.nextInt();
	}
	
	public static int randInt(int range)
	{
		return rand.nextInt(range);
	}
	
	public static double randDouble()
	{
		return rand.nextDouble();
	}
}
