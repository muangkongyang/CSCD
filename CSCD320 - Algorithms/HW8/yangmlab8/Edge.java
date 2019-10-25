// My Edge class
// Contains the distance of the edges
// and the shortest path to it
// from the source

import java.util.*;
import java.io.*;

public class Edge
{
   public int v, w;
   private final double weight;
   
   public Edge(int v, int w, double weight)
   {
      this.v = v;
      this.w = w;
      this.weight = weight;
   }
   
   public double weight()
   {
      return this.weight;
   }
   
   public int either()
   {
      return this.v;
   }
   
   public int other(int vertex)
   {
      if(vertex == this.v)
         return this.w;
      else
         return this.v;
   }
   
}