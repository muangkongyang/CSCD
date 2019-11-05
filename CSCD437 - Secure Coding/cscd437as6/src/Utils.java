import java.io.FileOutputStream;
import java.io.IOException;

/* @Muangkong Yang
 * CSCD437
 * Defend Code
 */

public class Utils 
{	
	static void writeStringToFile(final FileOutputStream fos, final String toWrite) throws IOException
	{
		if(fos == null)
			throw new IllegalArgumentException("FileOutputStream is null in write string to file.");
		if(toWrite == null)
			throw new IllegalArgumentException("String is null in write string to file.");
		
		byte[] array = toWrite.getBytes();
		fos.write(array);
		fos.flush();
	}
	
	static void writeIntegerToFile(final FileOutputStream fos, final int toWrite) throws IOException
	{
		if(fos == null)
			throw new IllegalArgumentException("FileOutputStream is null in write string to file.");

		fos.write(toWrite);
		fos.flush();
	}
}
