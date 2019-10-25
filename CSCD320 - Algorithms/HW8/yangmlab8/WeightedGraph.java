// My Weighted Graph class to build the Directed graph

import java.util.*;
import java.io.*;

public class WeightedGraph
{
   private int V;
   private Set<Edge>[] adj;
   
   public WeightedGraph(int vertices)
   {
      this.V = vertices;
      adj = (Set<Edge>[]) new Set[V + 1];
      for(int v = 0; v < V + 1; v++)
         adj[v] = new HashSet<Edge>();
   }
   
   public int V()
   {
      return this.V;
   }
   
   public double weight(int v, int w)
   {
      if(v < 1 || v > V() + 1 || w < 1 || w > V() + 1)
         throw new IllegalArgumentException("Vertex not in bounds when finding weight.");
      
      for(Edge e: adj(v))
      {
         if(e.v == v && e.w == w)
            return e.weight(); 
      }
      
      return 0.0;
   }
   
   public void addEdge(Edge e)
   {	
		int v = e.v,  w = e.w;
		adj[v].add(e);
	}
	
	public Iterable<Edge> adj(int v)
	{     
      return adj[v];  
   }
   
   public void printGraph()
   {
      for (int v = 0; v < V(); v++)
      {  
	      for (Edge e : adj(v))     
	      {   	
	   		int w = e.other(v);              
            System.out.println(e.v + " -> " + w);
	      }
	   }
   }
}