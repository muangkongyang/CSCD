/*******************************
 * @Muangkong Yang		      *
 * CSCD437 - Assignment 5    *
 * Regular Expressions	          *
 *******************************/

import java.util.Hashtable;
import java.util.regex.*;

// Some from Regex Cheat Sheet Website on Penguin
/** Anchors
 * ^  Start of string, or start of line in multi-line pattern
 * \A Start of string
 * $  End of string, or end of line in multi-line pattern
 * \Z End of string
 * \b Word boundary
 * \B Not word boundary
 * \< Start of word
 * \> End of word
 * 
 ** Character Classes
 * \c Control character
 * \s White space
 * \S Non white space
 * \d Digit
 * \D Non digit
 * \w Word
 * \W Not word
 * \x Hexadecimal digit
 * \O Octal digit
 */

public class RegexExpressions 
{
	private void menu()
	{
		System.out.println("Regular Expressions Menu");
		System.out.println("a. Social Security Number");
		System.out.println("b. US Phone number");
		System.out.println("c. E-mail address");
		System.out.println("d. Name on a class roster, assuming one or more middle initials - Last name, First name, MI");
		System.out.println("e. Date in MM-DD-YYYY or MM/DD/YYYY format");
		System.out.println("f. House address - Street number, street name, abbreviation for road, street, boulevard or avenue");
		System.out.println("g. City followed by state followed by zip as it should appear on a letter");
		System.out.println("h. Military time, including seconds");
		System.out.println("i. US Currency down to the penny (ex: $123,456,789.23)");
		System.out.println("j. URL, including http:// (upper and lower case should be accepted)");
		System.out.println("k. A password that contains at least 10 characters and includes at least one upper case character, lower case character, digit, punctuation mark, and does not have more than 3 consecutive lower case characters");
		System.out.println("l. All words containing an odd number of alphabetic characters, ending in \"ion\"");
		System.out.println("q. quit");
	}
	
	public void startRegex()
	{
		String choice = "";
		menu();
		do
		{
			System.out.print("C");
			choice = Utils.readString();
			choice = choice.toLowerCase();
			regexCase(choice);
		} while(!choice.equals("q"));
	}
	
	private void regexCase(String choice)
	{
		if(choice.equals("q"))
			System.out.println("Exiting...");
		else if(choice.matches("[^a-l]{1}"))
		{
			System.out.println("Invalid input: " + choice);
		}
		else
		{
			String regExp = "";
			System.out.print("E");
			regExp = Utils.readString();
			
			if(choice.equals("a"))
				SSN(regExp);
			else if(choice.equals("b"))
				PhoneNumber(regExp);
			else if(choice.equals("c"))
				Email(regExp);
			else if(choice.equals("d"))
				Name(regExp);
			else if(choice.equals("e"))
				Date(regExp);
			else if(choice.equals("f"))
				HouseAddress(regExp);
			else if(choice.equals("g"))
				CityStateZip(regExp);
			else if(choice.equals("h"))
				MilitaryTime(regExp);
			else if(choice.equals("i"))
				USCurrency(regExp);
			else if(choice.equals("j"))
				URL(regExp);
			else if(choice.equals("k"))
				Password(regExp);
			else if(choice.equals("l"))
				ION(regExp);
		}
	}
	
	/********************************************************
	 * Social Security Number
	 * 
	 * Group 1: 3 numbers
	 * Group 2: 2 numbers
	 * Group 3: 4 numbers
	 * each group separated by either - or whitespace or nothing
	 * 
	 ********************************************************/
	private void SSN(String regExp) 
	{
		String regex = "^(\\d{3}([- ]?)\\d{2}([- ]?)\\d{4})$";
		matchRegex(regExp, regex, "SSN");
	}

	/********************************************************
	 * Phone Number
	 * 
	 * Group 1: May consist of () for the first 3 numbers 
	 * Group 2: then 3
	 * Group 3: then 4
	 * - and 1 whitespace are optional between the 3 groups
	 * 
	 ********************************************************/
	private void PhoneNumber(String regExp) 
	{
		String regex = "^((\\(\\d{3}\\)|\\d{3})([- ]?)\\d{3}([- ]?)\\d{4})$";
		matchRegex(regExp, regex, "Phone#");
	}
	
	/********************************************************
	 * Email
	 * 
	 * Group 1: start with 1 or more letters/numbers with optional -, _- . no spaces
	 * Group 2: must have @ symbol after group 1
	 * Group 3: 1 or more letters/numbers with optional -, _
	 * Group 4: followed by 1 or more 2-3 length word with period '.' in front
	 * 
	 ********************************************************/
	
	private void Email(String regExp) 
	{
		String regex = "^[A-Za-z0-9\\-_\\.]+@[A-Za-z0-9\\-_]+(\\.[A-Za-z]{2,3})+$";
		matchRegex(regExp, regex, "Email");
	}

	/********************************************************
	 * Roster Name
	 * 
	 * Group 1: last name with first letter capitalized followed by 1 or more lowercase letters and ending with ','
	 * Group 2: Repeat group 1 with first name
	 * Group 3: 1 or more middle names followed of 1 or 2 capital letters followed by period '.' and space between them
	 * 
	 ********************************************************/
	private void Name(String regExp) 
	{
		String regex = "^((([A-Z]{1}[a-z]+, ){2}([A-Z]{1,2}\\. )*([A-Z]{1,2}\\.))|([A-Z]{1}[a-z]+, )([A-Z]{1}[a-z]+))$";
		matchRegex(regExp, regex, "Name");
	}

	/********************************************************
	 * Date
	 * 
	 * Group 1: Any 1 or 2 numbers for month (e.g. 1, 01, 2, 02...)
	 * Group 2: Any 1 or 2 numbers for day   (e.g. 1, 01, 20, 30...)
	 * Group 3: Must be 4 numbers for year that is less than 3000
	 * groups must be separated by only 1 of / or - (e.g. mm/dd/yyyy or mm-dd-yyyy)
	 * Date must be real and not fictionous.
	 * 
	 ********************************************************/
	private void Date(String regExp) 
	{
		String regex = "^\\d{1,2}([/-])\\d{1,2}([/-])\\d{4}$";
		if(determineIfValid(regExp, "Date"))
			matchRegex(regExp, regex, "Date");
		else
			System.out.println("Date is INVALID with expression: " + regExp);
		
	}
	
	/********************************************************
	 * House Address
	 * 
	 * Group 1: Must start with 1 or more numbers
	 * Group 2: Optional direction N, NW, NE, W...
	 * Group 3: Starts with either a captial letter or number
	 * Group 4: follows up with letters or space
	 * Group 5: some street suffixes
	 * 
	 ********************************************************/
	private void HouseAddress(String regExp) 
	{
		String regex = "^\\d+ ([NEWS][ ])?([A-Z]{1}|[0-9]+)[A-Za-z ]+ (Rd|Road|St|Street|Blvd|Boulevard|Ave|Avenue)$";
		matchRegex(regExp, regex, "HouseAddress");
	}

	/********************************************************
	 * City, State Zip
	 * 
	 * Group 1: 1 capital letter following with 1 or more lowercase letters and ending with comma and space
	 * Group 2: 2 capital letters for state
	 * Group 3: 5 numbers for zip or 5 numbers for zip and 4 numbers for extra with - between
	 * state must be valid
	 * 
	 ********************************************************/
	
	private void CityStateZip(String regExp) 
	{
		String regex = "^([A-Z]{1}[a-z]+, )[A-Z]{2} (([0-9]{5})|([0-9]{5}-[0-9]{4}))$";
		if(determineIfValid(regExp, "CityStateZip"))
			matchRegex(regExp, regex, "CityStateZip");
		else
			System.out.println("CityStateZip is INVALID with expression: " + regExp);
	}

	/********************************************************
	 * Military Time
	 * 
	 * Group 1: 2 numbers representing hour
	 * Group 2: ':' in between
	 * Group 3: 2 numbers representing seconds
	 * check if hour is valid - 2 digits and between 0 - 23
	 * check if minutes is valid - 2 digits and between 0 - 59
	 * 
	 ********************************************************/
	
	private void MilitaryTime(String regExp) 
	{
		String regex = "^\\d{2}:\\d{2}$";
		if(determineIfValid(regExp, "Time"))
			matchRegex(regExp, regex, "MilitaryTime");
		else
			System.out.println("MilitaryTime is INVALID with expression: " + regExp);
	}

	/********************************************************
	 * US Currency
	 * 
	 * Group 1: '$' at beginning
	 * Group 2: number must not have any leading zeroes (e.g. cannot be $021.00)
	 * Group 3: optional 3 digit number with comma in front indicating next thousand's place
	 * Group 4: if not group 2 or 3, assuming below 1 dollar, 1 or 2 0s must be present
	 * Group 5: '.'
	 * Group 6: 2 numbers representing cents
	 * 
	 ********************************************************/
	
	private void USCurrency(String regExp) 
	{
		String regex = "^(\\$(([1-9]{1}\\d{0,2})(,\\d{3})*|([0]{1,2}))).\\d{2}$";
		matchRegex(regExp, regex, "USCurrency");
	}

	/********************************************************
	 * URL
	 * 
	 * Group 1: indicate case insensitivity
	 * Group 2: optional "http(s)://"
	 * Group 3: optional "www"
	 * Group 4: website name with 1 or more letters or numbers, _ or -
	 * Group 5: '.' and then 1 or more 2-3 letter word (e.g. .com)
	 * Group 6: 2 numbers representing cents
	 * 
	 ********************************************************/
	
	private void URL(String regExp) 
	{
		String regex = "^(?i)(http[s]?://)?([w]{3}.)?[a-zA-Z0-9_\\-]+(\\.[a-zA-Z]{2,3})+$";
		matchRegex(regExp, regex, "URL");
	}

	/********************************************************
	 * Password
	 * 
	 * Group 1: positive lookahead a digits
	 * Group 2: negative lookahead for no more than 3 consecutive lowercase letters !(n > 3) (n<=3)
	 * 			(e.g. abcd)
	 * Group 3: postive lookahead for a lowercase letter
	 * Group 4: positive lookahead for an uppercase letter
	 * Group 5: positive lookahead for a special character
	 * Group 6: must be at least 10 length
	 * 
	 ********************************************************/
	
	private void Password(String regExp) 
	{
		String regex = "^(?=.*\\d)(?!.*[a-z]{4})(?=.*[a-z])(?=.*[A-Z])(?=.*[\\!-\\/\\:-\\@\\[-\\`\\{-\\~]).{10,}$";
		matchRegex(regExp, regex, "Password");
	}

	/********************************************************
	 * ION
	 * 
	 * Group 1: can have 0 or more (2 or more uppercase or lower case letters)
	 * 		 	this makes the count always 2 characters + 3 characters(from ion) odd
	 * Group 2: case insensitive ion
	 * 
	 ********************************************************/
	
	private void ION(String regExp) 
	{
		String regex = "^([A-Za-z][A-Za-z])*(?i)ion$";
		matchRegex(regExp, regex, "ION");
	}
	
	private boolean determineIfValid(String regExp, String type)
	{
		try
		{
			if(type.equals("Date"))
			{
				// Needs to have only on type of - or /
				
				if(regExp.contains("-"))
				{
					String[] test = regExp.split("-");
					for(String s: test)
					{
						if(s.contains("/"))
							return false;
					}
				}
				else if(regExp.contains("/"))
				{
					String[] test = regExp.split("/");
					for(String s: test)
					{
						if(s.contains("-"))
							return false;
					}
				}
				
				String[] str = regExp.split("[/-]");
				//for(String s: str)
					//System.out.println(s);
				int month = Integer.parseInt(str[0]);
				int day = Integer.parseInt(str[1]);
				int year = Integer.parseInt(str[2]);
				//System.out.println("Month: " + month + " Day: " + day + " Year: " + year);
				
				// Not a month
				if(month < 1 || month > 12)
					return false;
				else if(day < 1)
					return false;
				else if(year > 2999)
					return false;
				// February
				else if(month == 2)
				{
					// Leap year
					if(year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0)
						return day <= 29;
					// Non-leap year
					else
						return day <= 28;
				}
				
				int month30days[] = {4, 6, 9, 11};
				// April, June, September, November
				for(int i: month30days)
				{
					if(month == i)
						return day <= 30;
				}
				// else
				// 31 days months
				// January, March, May, July, August, October, December
				return day <= 31;
			}
			else if(type.equals("CityStateZip"))
			{
				String[] splitExp = regExp.split(", | ");
				//for(String s: splitExp)
					//System.out.println(s);
				String state = splitExp[1];
				
				Location checkState = new Location();
				Hashtable<Integer, String> table = checkState.getMyTable();
				checkState.readStateDictionary("states.txt", table);
				if(!table.contains(state))
					return false;
			}
			else if(type.equals("Time"))
			{
				String[] toSplit = regExp.split(":");
				//for(String s: toSplit)
					//System.out.println(s);
				String hr = toSplit[0];
				String min = toSplit[1];
				
				if(hr.length() != 2 || min.length() != 2)
					return false;
				
				int hour = Integer.parseInt(hr);
				int minutes = Integer.parseInt(min);
				
				if(hour < 0 || hour > 23 || minutes < 0 || minutes > 59)
					return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private void matchRegex(String regExp, String regex, String type)
	{
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(regExp);
		
		if(m.matches())
			System.out.println(type + " is VALID with expression: " + regExp);
		else
			System.out.println(type + " is INVALID with expression: " + regExp);
	}
}
