package cscd210Classes;

public class CheckingAccount
{
   private int acctNum;
   private double bal;
   
   public CheckingAccount(final int acctNum)
   {
      this(acctNum, 100.0);    
   }
   
   public CheckingAccount(final int acctNum, final double bal)
   {
      //Pre-conditions
      if(acctNum <= 0 || bal < 100)
         throw new IllegalArgumentException("bad CheckingAccount params");
         
      this.acctNum = acctNum;
      this.bal = bal;
   }
   
   public int getAcctNumber()
   {
      return this.acctNum;
   }
   
   public double getBalance()
   {
      return this.bal;
   }
   
   public void setAccountNumber(final int acctNum)
   {
      if(acctNum <= 0)
         throw new IllegalArgumentException("bad acctNum");
      
      this.acctNum = acctNum;
   }
   
   private void setBalance(final double bal)
   {
      if(bal < 0)
         throw new IllegalArgumentException("bad balance");
         
      this.bal = bal;   
   }
   
   public void deposit(final double amt)
   {
      if(amt <= 0)
         throw new IllegalArgumentException("bad amt");
         
      this.setBalance(this.bal + amt);
   }
   
   public void withdrawal(final double amt)
   {
      if(amt <= 0)
         throw new IllegalArgumentException("bad amt");
         
      if(amt <= this.bal)
         this.setBalance(this.bal - amt);
   }
   
   @Override
   public String toString()
   {
      String str = "Account Number: " + this.acctNum + "\nAccountNumber: $" + this.bal + "\n";
      return str;
   }
   
   @Override
   public boolean equals(final Object o)
   {
      if(o == Double.valueOf(0))
         return true;
      if(o == null)
         return false;
      if(!(o instanceof CheckingAccount))
         return false;
      
      CheckingAccount another = (CheckingAccount) o;
      boolean res = this.acctNum == (another.acctNum) && this.bal == Double.valueOf(another.bal);
      
      return res;
   }
   
   @Override
   public int hashCode()
   {
      String str = this.acctNum + "";
      return str.hashCode();
   }  
}// end class