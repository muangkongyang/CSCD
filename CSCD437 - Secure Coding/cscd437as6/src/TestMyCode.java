/* @Muangkong Yang
 * Team JIM
 * CSCD437
 * Defend your Code
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMyCode 
{
	public static void main(String[] args) throws IOException
	{
		File f = null, errf = null; 
		FileOutputStream fos = null, feos = null;
		InputMethods toTest = new InputMethods();
		
		/*
		 * creating output file
		 */
		f = new File("src\\output.txt");
		if(!f.exists())
			f.createNewFile();	
		fos = new FileOutputStream(f, false);
		
		/*
		 * creating error file
		 */
		errf = new File("src\\errorfile.txt");
		if(!errf.exists())
			errf.createNewFile();
		
		feos = new FileOutputStream(errf, false);
		
		/*
		 * test starts here
		 */
		try
		{
			Utils.writeStringToFile(fos, toTest.userName());
		}
		catch(IOException e)
		{
			Utils.writeStringToFile(feos, e.getMessage());
		}
		catch(IllegalArgumentException e)
		{
			Utils.writeStringToFile(feos, e.getMessage());	
		}
		finally
		{
			fos.close();
			feos.close();
		}
	}
}

