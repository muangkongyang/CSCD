import java.util.Scanner; 

public class CSCD210Lab1 
{
    
   public static void main(String [] args)   
   {     
     int shoeSize, bYear;       
     Scanner kb = new Scanner(System.in);              
     System.out.print("Please enter your shoe size (no half sizes) ");       
     shoeSize = kb.nextInt();             
     System.out.print("Please enter your birth year (yyyy) ");       
     bYear = kb.nextInt();              
     System.out.println("The last two numbers are your age and the" 
                        + " first number(s) are your shoe size " 
                        + ( (shoeSize * 5 + 50) * 20 + 1017 -  bYear));            
   }// end main 
}// end class