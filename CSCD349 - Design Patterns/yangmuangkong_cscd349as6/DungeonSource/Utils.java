import java.util.*;

// Refactor 5
public class Utils 
{
	static Scanner kb = new Scanner(System.in);
	
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
		} while(num < 1 || num > 10);
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
			
}
