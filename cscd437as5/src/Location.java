import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

// Helper class to store all states in the US to a hashtable from a file
// and uses Regex to check from it to see if state is valid

public class Location
{	
	private Hashtable<Integer, String> myTable;
	
	public Location()
	{
		this.myTable = new Hashtable<Integer, String>();
	}
	
	public Hashtable<Integer, String> readStateDictionary(String filename, Hashtable<Integer, String> thisTable) throws IOException
	{
		if(filename == null)
			throw new IllegalArgumentException("State file is null");
		if(filename.isEmpty())
			throw new IllegalArgumentException("Filename is empty");
		
		File inf = new File(filename);
		Scanner kb = null;
		Hashtable<Integer, String> myHashTable = thisTable;
		
		try
		{
			kb = new Scanner(inf);
			
			while(kb.hasNextLine())
			{
				String toSplit = kb.nextLine();
				String [] splitWord = toSplit.split(" - ");
				String getState = splitWord[1];
				int key = myHashTable.hashCode();
				myHashTable.put(key, getState);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println(myHashTable.toString());
		return myHashTable;
	}

	public Hashtable<Integer, String> getMyTable() 
	{
		return myTable;
	}
}
