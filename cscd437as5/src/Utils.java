import java.util.Scanner;

public class Utils 
{
	static Scanner kb = new Scanner(System.in);
	
	public static char readChar()
	{
		String word = "";
		word = kb.nextLine();
		return word.charAt(0);
	}
	
	public static String readString()
	{
		String word = "";
		System.out.print("> ");
		word = kb.nextLine();
		return word;
	}
}
