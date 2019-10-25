package cscd211Package.vehicle;

import cscd211Package.type.Package;
import cscd211Package.type.*;

import java.text.*;
import java.util.*;
import java.io.*;

public class Truck
{
   private String driver;
   private int load;
   private int maxPackages;
   private cscd211Package.type.Package[] thePackages;
   
   public Truck(final String driver, final int maxPackages)
   {
      // Preconditions
      if(driver == null)
         throw new NullPointerException("null Truck driver");
      if(driver.isEmpty() || maxPackages < 1)
         throw new IllegalArgumentException("bad Truck params");
         
      this.driver = driver;
      this.load = 0;
      this.maxPackages = maxPackages;
      this.thePackages = new Package[maxPackages];
   }
   
   public void drive(final PrintStream fout)
   {
      // Preconditions
      if(fout == null)
         throw new NullPointerException("drive fout null");
         
      Arrays.sort(thePackages);
      
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      
      fout.println("Departure Date: " + dateFormat.format(date));
   }
   
   public String getDriver()
   {
      return this.driver;
   }
   
   public int getLoad()
   {
      return this.load;
   }
   
   public int getMaxPackages()
   {
      return this.maxPackages;
   }
   
   public void load(final Scanner fin, final PrintStream fout)
   {
      // Preconditions
      if(fin == null || fout == null)
         throw new NullPointerException("bad load");
         
      int trackNum, type, weight, height, width, length = 0;
      String contents;
      
      while(fin.hasNext())
      {
         trackNum = Integer.parseInt(fin.nextLine());
         type = trackNum % 10;
         
         if(type == 0) // for TYPE LETTER
         {
            weight = Integer.parseInt(fin.nextLine());
            length = Integer.parseInt(fin.nextLine());
            width = Integer.parseInt(fin.nextLine());
            
            Letter newLetter = new Letter(trackNum, weight, length, width);
            Package newPackage = (Package) newLetter;
            
            if((weight <= newLetter.getMaxWeight()) &&
               (length <= newLetter.getMaxLength()) &&
               (width <= newLetter.getMaxWidth()))
            {
               if(this.load < this.maxPackages)
               {
                  loadPackage(newPackage, this.load);
                  String str = newLetter.toString() + " Status: LOADED";
                  printToLog(fout, str);
               }

               else
               {
                  String str = newLetter.toString() + " Status: NOT LOADED (truck is already full)";
                  printToLog(fout, str);
               }
            }
            else if(weight > newLetter.getMaxWeight())
            {
               String str = newLetter.toString() + " Status: NOT LOADED (letter is too heavy)";
               printToLog(fout, str);
            }
            else
            {
               String str = newLetter.toString() + " Status: NOT LOADED (letter is too big)";
               printToLog(fout, str);
            }   
         }// end type letter
         
         else if(type == 1) // for TYPE BOX
         {
            weight = Integer.parseInt(fin.nextLine());
            length = Integer.parseInt(fin.nextLine());
            width = Integer.parseInt(fin.nextLine());
            height = Integer.parseInt(fin.nextLine());
            
            Box newBox = new Box(trackNum, weight, length, width, height);
            Package newPackage = (Package) newBox;
            
            if((weight <= newBox.getMaxWeight()) &&
               (length <= newBox.getMaxLength()) &&
               (width <= newBox.getMaxWidth()) &&
               (height <= newBox.getMaxHeight()))
            {
               if(this.load < this.maxPackages)
               {
                  loadPackage(newPackage, this.load);
                  String str = newBox.toString() + " Status: LOADED";
                  printToLog(fout, str);
               }

               else
               {
                  String str = newBox.toString() + " Status: NOT LOADED (truck is already full)";
                  printToLog(fout, str);
               } 
            }
            else if(weight > newBox.getMaxWeight())
            {
               String str = newBox.toString() + " Status: NOT LOADED (box is too heavy)";
               printToLog(fout, str);
            }
            else 
            {
               String str = newBox.toString() + " Status: NOT LOADED (box is too big)";
               printToLog(fout, str);
            }
         }
         
         else if(type == 2) // for TYPE METAL CRATE
         {
            weight = Integer.parseInt(fin.nextLine());
            length = Integer.parseInt(fin.nextLine());
            width = Integer.parseInt(fin.nextLine());
            height = Integer.parseInt(fin.nextLine());
            contents = fin.nextLine();
            
            MetalCrate newMetalCrate = new MetalCrate(trackNum, weight, length, width, height, contents);
            Crate newCrate = (Crate) newMetalCrate;
            Package newCratePackage = (Package) newCrate;
            
            if((weight <= newMetalCrate.getMaxWeight()) &&
               (length <= newMetalCrate.getMaxLength()) &&
               (width <= newMetalCrate.getMaxWidth()) &&
               (height <= newMetalCrate.getMaxHeight()))
            {
               if(this.load < this.maxPackages)
               {
                  loadPackage(newCratePackage, this.load);
                  String str = newMetalCrate.toString() + " Status: LOADED";
                  printToLog(fout, str);
               }

               else
               {
                  String str = newMetalCrate.toString() + " Status: NOT LOADED (truck is already full)";
                  printToLog(fout, str);
               } 
            }
            else if(weight > newMetalCrate.getMaxWeight())
            {
               String str = newMetalCrate.toString() + " Status: NOT LOADED (metal crate is too heavy)";
               printToLog(fout, str);
            }
            else
            {
               String str = newMetalCrate.toString() + " Status: NOT LOADED (metal crate is too big)";
               printToLog(fout, str);
            }
         }
         
         else if(type == 3) // for TYPE WOOD CRATE
         {
            weight = Integer.parseInt(fin.nextLine());
            length = Integer.parseInt(fin.nextLine());
            width = Integer.parseInt(fin.nextLine());
            height = Integer.parseInt(fin.nextLine());
            contents = fin.nextLine();
            
            WoodCrate newWoodCrate = new WoodCrate(trackNum, weight, length, width, height, contents);
            Crate newCrate = (Crate) newWoodCrate;
            Package newCratePackage = (Package) newCrate;
            
            if((weight <= newWoodCrate.getMaxWeight()) &&
               (length <= newWoodCrate.getMaxLength()) &&
               (width <= newWoodCrate.getMaxWidth()) &&
               (height <= newWoodCrate.getMaxHeight()))
            {
               if(this.load < this.maxPackages)
               {
                  loadPackage(newCratePackage, this.load);
                  String str = newWoodCrate.toString() + " Status: LOADED";
                  printToLog(fout, str);
               }

               else
               {
                  String str = newWoodCrate.toString() + " Status: NOT LOADED (truck is already full)";
                  printToLog(fout, str);
               }  
            }
            else if(weight > newWoodCrate.getMaxWeight())
            {
               String str = newWoodCrate.toString() + " Status: NOT LOADED (wooden crate is too heavy)";
               printToLog(fout, str);
            }
            
            else
            {
               String str = newWoodCrate.toString() + " Status: NOT LOADED (wooden crate is too big)";
               printToLog(fout, str);
            }
         }
         
         else // for a package not for us to load
         {
            weight = Integer.parseInt(fin.nextLine());
            length = Integer.parseInt(fin.nextLine());
            width = Integer.parseInt(fin.nextLine());
            height = Integer.parseInt(fin.nextLine());
            
            String str = "Package: Not Required - Track#: " + trackNum + " Weight: " + weight + " Length: " + length +
                         " Width: " + width + " Height: " + height;
            
            printToLog(fout, str);
         }
      }
   }
   
   protected void loadPackage(final Package toAdd, final int index)
   {
      if(index < this.maxPackages)
      {
         this.thePackages[index] = toAdd;
         this.load++;
      } 
   }
   
   protected void printToLog(final PrintStream fout, final String str)
   {
      fout.println(str);
   }
   
   public void unload(final PrintStream fout)
   {
      // Preconditions
      if(fout == null)
         throw new NullPointerException("null unload fout");
      
      double totalWeight = 0.0;
      
      fout.println("Unloading Contents");   
      for(int i = 0; this.thePackages[i] != null && i < this.thePackages.length - 1; i++)
      {
         fout.println(this.thePackages[i]);
         
         if(this.thePackages[i] instanceof Letter)
            totalWeight += (double) this.thePackages[i].getWeight() * 0.0625;
         else
            totalWeight += (double) this.thePackages[i].getWeight();
      }
      
      fout.println("Total Number of Packages Transported: " + this.maxPackages);
      fout.println("Total Weight of Packages Transported: " + totalWeight + "lbs");
   }
}