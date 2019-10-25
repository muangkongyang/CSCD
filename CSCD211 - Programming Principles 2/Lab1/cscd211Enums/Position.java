package cscd211Enums;

public enum Position
{
   DF("defensive midfielder"), 
   FW("forward"), 
   GK("goal keeper"), 
   MF("midfielder");
   
   private String name;
   
   private Position(final String name)
   {
      this.name = name;
   }
   
   @Override
   public String toString()
   {
      String [] str = this.name().split(" ");
      
      if(this.name().contains(" ") == true)
      {
         str[0].substring(0,1).toUpperCase();
         str[1].substring(0,1).toUpperCase();
      }
      else
      {
         return this.name().substring(0,1).toUpperCase();
      }
      
      return str[0] + " " + str[1];  
   }
}