import java.util.*;
import java.io.*;

public class WeightedGraph
{
   private int V;
	private Set<Edge>[] adj; //adj[i] stores all edges connecting to vertex i
	
   public WeightedGraph(int V)
	{
		this.V = V;
		adj = (Set<Edge>[]) new Set[V];
		for (int v = 0; v < V; v++)      
			adj[v] = new HashSet<Edge>();
	}
	
   public int V()
   {
      return this.V;
   }
   
	public void addEdge(Edge e)
   {	
		int v = e.v,  w = e.w;
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<Edge> adj(int v)
	{  
      return adj[v];  
   }
   
   // This method is the problem -_-
   public Edge[] edges()
   {
      Edge[] edges = new Edge[adj.length];
      // To process all the edges
      
      for (int v = 0; v < adj.length; v++)
      {  
	      for (Edge e : adj(v))     
	      {   	
	   		int w = e.other(v);              
	   		// process edge v-w
            //System.out.println(v + " - " + e.getWeight() + " -> " + w);
            edges[v] = e; 
	      }
	   }
      
      return edges;
   }
}