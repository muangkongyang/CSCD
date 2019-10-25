// My Dijkstra's Algorithm Class
// Will be mainly using LinkedList as the structure for my containers

import java.util.*;
import java.io.*;

public class Dijkstra
{
   private int dist[]; // distance
   private LinkedList<Integer> S; // stores the shortest paths
   //private PriorityQueue<Edge> Q; //Container for the vertices
   private LinkedList<Integer> Q;
   private String path[];
   
   public Dijkstra(WeightedGraph G)
   {
      this.dist = new int[G.V() + 1];
      this.S = new LinkedList<Integer>(); // Store the edges with shortest path
      this.Q = new LinkedList();
      this.path = new String[G.V() + 1];
   }
   
   // Passing in the Graph and the source of where we start
   public void findShortestPath(WeightedGraph G, int source)
   {
      this.dist[source] = 0;
      
      for(int v = 1; v < G.V() + 1; v++)
      {
         if(v != source)
            dist[v] = Integer.MAX_VALUE; // sets to infinity or very large value
         
         path[v] = "";
      }      
      
      // Enqueue to Q
      Q.add(source);
      
      while(Q.size() > 0)
      {
         int u = findSmallestDistance(Q, this.dist);
         
         if(!S.contains(u)) // so there are no duplicates
            S.add(u);
         
         // Add in the neighbors, update dist and path
         for(Edge e: G.adj(u))
         {
            int v = e.other(u);

            if(!Q.contains(v) && !S.contains(v)) // no duplicates
               Q.add(v);
            
            if(dist[v] > dist[u] + (int) G.weight(u, v))
            {
               dist[v] = dist[u] + (int) G.weight(u, v);
               path[v] = path[u] + "->" + v;
            }
         }
         
      }
   }
   
   // To find the smallest element in dist[]
   public int findSmallestDistance(LinkedList<Integer> Q, int [] distance)
   {  
      int smallest = Q.getFirst();
      
      // To go through only the neighbors instead of whole list
      for(int q: Q)
      {
         if(distance[q] < distance[smallest])
            smallest = q;
      }
      
      // Dequeue from Q
      this.Q.removeFirstOccurrence(smallest);
      
      return smallest;
   }
   
   // Prints out the set S that contains the shortest path
   public void path(int source)
   {
      System.out.println("Shortest path to each vertices starting from vertex " + source + ".");
      for(int i = 1; i < path.length; i++)
      {
         if(i == 1 && dist[i] == Integer.MAX_VALUE)
            System.out.println("Path " + i +"): vertex" + source + " to vertex" + i + ", " + source + "->1, cannot reach destination");
         else if(i == 1)
            System.out.println("Path " + i +"): vertex" + source + " to vertex" + i + ", " + source + "->1, length " + dist[i]);
         else if(dist[i] == Integer.MAX_VALUE)
            System.out.println("Path " + i +"): vertex" + source + " to vertex" + i + ", " + source + "->" + i + ", cannot reach destination"); 
         else
            System.out.println("Path " + i +"): vertex" + source + " to vertex" + i + ", " + source + path[i] + ", length " + dist[i]);    
      }
   }
}