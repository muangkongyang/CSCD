import java.util.*;
import java.io.*;

public class UnionFind
{
   Set<Integer> components[];
   
   public UnionFind(int vertices)
   {
      components = (Set<Integer>[]) new Set[vertices];
      for(int v = 0; v < vertices; v++)
         components[v] = new HashSet<Integer>();
   }
   
   // Checks to see if a component contains both v and w
   // returns true if both vertices are in one component (a cycle)
   public boolean find(int v, int w)
   {
      if(components[v].contains(w) || components[w].contains(v))
        return true;
      
      return false;
   }
   
   public void unite(int v, int w)
   {
      components[v].addAll(components[w]);
      components[w].clear(); // remove the 2nd component
   }
}