import java.util.*;
import java.io.*;

public class Edge
{
   private int vert1, vert2;
   private int weight;
   
   // Constructor for Edge w/o weight
   public Edge(int v1, int v2)
   {
      this.vert1 = v1;
      this.vert2 = v2;
   }
   
   // Constructor for Edge w/ weight
   public Edge(int v1, int v2, int vertWeight)
   {
      this.vert1 = v1;
      this.vert2 = v2;
      this.weight = vertWeight;
   }
   
   public int v1()
   {
      return this.vert1;
   }
   
   public int v2()
   {
      return this.vert2;
   }
   
   public int getWeight()
   {
      return this.weight;
   }
   
   public int either()
   {
      return this.vert1;
   }
   
   // Returns the other vertex
   public int other(int v)
   {
      if(v == this.vert1)
         return vert2;
      else
         return vert1;
   }
}