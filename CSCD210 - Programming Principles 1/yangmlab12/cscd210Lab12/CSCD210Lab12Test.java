package cscd210Lab12;

import cscd210Classes.CheckingAccount;

public class CSCD210Lab12Test
{
   private int acctNum;
   private double bal;
   
   public CSCD210Lab12Test()
   {
      this.acctNum = 0;
      this.bal = 99.0;
   }
   
   public static void main(String [] args)
   {
      // main made for testing out preconditions
      CheckingAccount one = new CheckingAccount(1532002000);
      CheckingAccount two = new CheckingAccount(0, 200);
      CheckingAccount three = one;

      // this one tests out precondition of having a bal <= 0
      System.out.println("Infomation on this checking accounts:\n");
      System.out.println("Account #: " + one.getAcctNumber());
      System.out.printf("Account bal: %.2f\n", one.getBalance());
      System.out.println(); 
      
      // this one tests out precondition of having an acctNum < 0
      System.out.println("Infomation on this checking accounts:\n");
      System.out.println("Account #: " + two.getAcctNumber());
      System.out.printf("Account bal: %.2f\n", two.getBalance());
      System.out.println();
   }
}