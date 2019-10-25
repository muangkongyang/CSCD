package cscd210Classes;

import java.util.*;
import java.io.*;

public class Rational implements Comparable<Rational>
{
   private int num;
   private int den;
   
   public Rational()
   {
      this.num = 1;
      this.den = 1;
   } // end DVC
   
   public Rational(final int num, final int den)
   {
      // Preconditions
      if(den == 0)
         throw new IllegalArgumentException("bad Rational den");
         
      this.num = num;
      this.den = den;
      
      // den value passed in is good so call in sign() and reduce()
      sign();
      reduce();
      
   } // end EVC
   
   public Rational add(final Rational another)
   {
      // Preconditions
      if(another == null)
         throw new IllegalArgumentException("bad add param");
      
      // build new Rational object for third fraction being the sum of this and another 
      Rational sum = new Rational(num, den);
      sum.num = (this.num * another.den) + (another.num * this.den);
      sum.den = this.den * another.den;
      
      sum.reduce();
      sum.sign();
      
      return sum; 
   }
   
   public int compareTo(final Rational another)
   {
      // Preconditions
      if(another == null)
         throw new IllegalArgumentException("bad compareTo param");
         
      int res = Double.valueOf(this.num / this.den).compareTo(Double.valueOf(another.num / another.den));
      if(res < 0 || res > 0 || res == 0)
      {   
         return res;
      }
               
      return res;   
   }
   
   @Override
   public boolean equals(final Object obj)
   {
      if(obj == null)
         return false;
      if(this == obj)
         return true;
      if(!(obj instanceof Rational))
         return false;
      
      Rational another = (Rational) obj;
      boolean res = (this.den == another.den) && (this.num == another.num);
      
      return res;
   }
   
   @Override
   public int hashCode()
   {
      int hash = Integer.valueOf(this.num).hashCode() + Integer.valueOf(this.den).hashCode();
      
      return hash;
   }
   
   public Rational reciprocal()
   {
      Rational rNum = new Rational(num, den); // creates new Rational object with num and den DVC
      rNum.num = this.den;                   // puts den on numerator
      rNum.den = this.num;                   // puts num on denominator
      
      rNum.reduce();
      rNum.sign();
      
      return rNum;
   }
   
   private void reduce()
   {
      //find larger numerator and denominator
      int n = this.num, d = this.den, largest;
      
      if(this.num < 0)
         n = -this.num;
      if(n > d)
         largest = n;
      else
         largest = d;
         
      //find largest number that divide numerator and denominator evenly (GCD)
      int GCD = 0;
      
      for(int i = largest; i >= 2; i--)
      {
         if(this.num % i == 0 && this.den % i == 0)
         {   
            GCD = i;
            i = 1; // break out of this for loop
         }
      }
      
      //divide GCD from numerator and denominator
      if(GCD != 0)
      {
         this.num /= GCD;
         this.den /= GCD;
      }
   }
   
   private void sign()
   {
      if(this.den < 0 && this.num > 0 || this.den < 0 && this.num < 0)
      {
         this.num *= -1;
         this.den *= -1;
      }
   }
   
   @Override
   public String toString()
   {
      String str = this.num + "/" + this.den;
      return str;
   }
}