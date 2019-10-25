package cscd210Classes;

public class Fish implements Comparable<Fish>
{
   private String type;
   private double weight;
   
   public Fish(final String type, final double weight)
   {
      if(type == null || type.isEmpty() || weight <= 0)
         throw new IllegalArgumentException("bad Fish params");
         
      this.type = type;
      this.weight = weight;
   }
   
   public double getWeight()
   {
      return this.weight;
   }
   
   public String getType()
   {
      return this.type;
   }
   
   public void setWeight(final double weight)
   {
      //Preconditions
      if(weight <= 0)
         throw new IllegalArgumentException("bad setWeight param");
         
      this.weight = weight;
   }  
   
   public void setType(final String type)
   {
      //Preconditions
      if(type == null || type.isEmpty())
         throw new IllegalArgumentException("bad setType param");
      
      this.type = type;
   }
   
   @Override
   public boolean equals(final Object obj)
   {
      if(obj == this)
         return true;
      if(obj == null)
         return false;
      if(!(obj instanceof Fish))
         return false;
         
      Fish another = (Fish) obj;
      
      /* Option 1
      double d1 = this.weight, d2 = another.weight;
      double res1 = d1 - d2;
      boolean res2 = Boolean.FALSE;
      
      if(res1 == 0.0)
         res2 = Boolean.TRUE;
         
      boolean res = this.type.equals(another.type) && res2;
      */
      
      // Option 2
      boolean res1 = false;
      
      int resWeight = Double.compare(this.weight, another.weight);
      
      if(resWeight == 0)
         res1 = true;
      
      boolean res = this.type.equals(another.type) && res1;
      
      return res;
   }
   
   @Override
   public int hashCode()
   {
      int hashType = type.hashCode();
      
      long hashWeight = Double.doubleToLongBits(this.weight);
      
      int hash = hashType + (int) (hashWeight^(hashWeight >>> 32));
      
      return hash; 
   }
   
   @Override
   public int compareTo(final Fish another)
   {
      //Preconditions
      if(another == null)
         throw new IllegalArgumentException("bad compareTo param");
         
      int types = this.type.compareTo(another.type);
      
      if(types != 0)
         return types;
      else
         return Double.compare(this.weight, another.weight);
         
      //I don't get how to incorporate <Fish> to this method...keeps on giving me compiling errors     
   }
   
   @Override
   public String toString()
   {
      String str = this.type + " - " + this.weight;
      
      return str;
   }
}