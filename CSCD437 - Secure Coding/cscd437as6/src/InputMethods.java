import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputMethods 
{
	final private static Scanner kb = new Scanner(System.in);
	
	public String userName()
	{
		if(kb == null)
			throw new IllegalArgumentException();
		
		String regex = "^[A-Za-z]{1,50}$";
		String firstName = "", lastName = "";
		
		do
		{
			System.out.print("Please enter first name: ");
			firstName = kb.nextLine();
		} while(!compileRegex(firstName, regex));
		
		do
		{
			System.out.print("Please enter last name: ");
			lastName = kb.nextLine();
		} while(!compileRegex(lastName, regex));
		
		String fullName = "First Name: " + firstName + "\n" +
				   		  "Last Name: " + lastName + "\n";
		
		return fullName;
	}
	
	/*
	 *  Checks input using regex
	*/
	private boolean compileRegex(String input, String regex)
	{
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		
		return m.matches();
	}
}
