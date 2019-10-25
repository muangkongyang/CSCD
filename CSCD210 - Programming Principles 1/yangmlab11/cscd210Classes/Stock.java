package cscd210Classes;

public class Stock
{
   private String companyName;
   private String ticker;
   private double purchasePrice;
   private double currentPrice;
   
   public Stock()
   {
      this.companyName = "DOW Jones Industrial Average";
      this.ticker = "DOW";
      this.currentPrice = 12.0;
   }//end DVC
   
   public Stock(final String companyName, final double currentPrice, final String ticker)
   {
      this(ticker, companyName, currentPrice);
      this.purchasePrice = 5.0;
   }//end EVC
   
   public Stock(final String ticker, final String companyName, final double currentPrice)
   {
      if(ticker == null || companyName == null || ticker.isEmpty() || companyName.isEmpty() ||
         currentPrice <= 0)
         throw new IllegalArgumentException("bad Stock parameters");
   
      this.companyName = companyName;
      this.currentPrice = currentPrice;
      this.ticker = ticker;
      this.purchasePrice = 10.0;
   }//end EVC
   
   @Override
   public String toString()
   {
      String str = this.companyName + " - " + this.ticker;
      str += "\nPurchase Price: " + purchasePrice;
      str += "\nCurrent Price: " + currentPrice;
      
      return str;
   }//end toString
}//end class