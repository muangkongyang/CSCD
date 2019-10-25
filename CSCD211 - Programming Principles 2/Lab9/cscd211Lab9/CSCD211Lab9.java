package cscd211Lab9;

import java.io.*;
import java.util.*;
import cscd211Utils.*;
import cscd211Package.type.*;
import cscd211Package.vehicle.*;

public class CSCD211Lab9
{
	public static void main(String [] args) throws Exception
	{
      int maxPackages = 0;
      String driverName = "";

      File inf = FileUtil.openInputFile("manifest.txt");
      Scanner fin = new Scanner(inf);

      PrintStream fout = new PrintStream(new FileOutputStream("log.txt"), true);

      driverName = fin.nextLine();
      maxPackages = Integer.parseInt(fin.nextLine());

		Truck theTruck = new Truck(driverName, maxPackages);
		theTruck.load(fin, fout);
      theTruck.drive(fout);
		theTruck.unload(fout);
      fin.close();
      fout.close();

   }//end main

}//end class