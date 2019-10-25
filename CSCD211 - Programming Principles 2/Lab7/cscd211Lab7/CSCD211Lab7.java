package cscd211Lab7;

import java.util.*;
import cscd211Inheritance.*;

public class CSCD211Lab7
{   
   public static void main(String [] args)
   {
      ArrayList<Employee>myList = new ArrayList<Employee>();
      myList.add(new Programmer("Mr. Ima Nerd", 40000, 20000, true));
      myList.add(new Programmer("Mrs. Ima Nerd", 45000, 20000, false));
      myList.add(new Accountant("Mr. Bean Counter", 100000, 0, 50.00));
      myList.add(new Accountant("Mrs. Bean Counter", 75000, 0, 150.00));
      myList.add(new Lawyer("Mr. Lawyer", 150000, 30000, 25));
      myList.add(new Lawyer("Mrs. Lawyer", 170000, 20000, 125));

      System.out.println("Employee List");
      for(Employee e : myList)
         System.out.println(e);

      System.out.println();
               
      System.out.println("Employee Salaries");         
      for(Employee e : myList)
         System.out.println(e.getName() + " - " + e.getSalary());

      System.out.println();
      
      
      System.out.println("Employee Report");         
      for(Employee e : myList)
         e.report();
      
      System.out.println();
      
      Collections.sort(myList);
      
      System.out.println("Employee List");
      for(Employee e : myList)
         System.out.println(e.getType() + " - " + e.getName() + " - " + e.getSalary());

      System.out.println();
    
   }//end main
   
}// end class