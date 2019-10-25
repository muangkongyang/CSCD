import java.util.*;
import java.io.*;

// Tester for homework 6 on an Undirected Graph Traversal
// 8 Vertices, 14 Edges
public class Tester
{
   public static void main(String [] args)
   {
      Graph G = new Graph(8);
      
      G.setEdge(0, 1, 4);
      G.setEdge(0, 2, 6);
      G.setEdge(0, 3, 16);
      G.setEdge(1, 7, 24);
      G.setEdge(2, 3, 8);
      G.setEdge(2, 5, 5);
      G.setEdge(2, 7, 23);
      G.setEdge(3, 4, 21);
      G.setEdge(3, 5, 10);
      G.setEdge(4, 5, 14);
      G.setEdge(4, 6, 7);
      G.setEdge(5, 6, 11);
      G.setEdge(5, 7, 18);
      G.setEdge(6, 7, 9);
      
      /* Displays all the edges connecting the vertices in the graph
      for(int v = 0; v < G.n(); v++)
      {
         Edge f = G.first(v);
         for( ; f != null; f = G.next(f))
            System.out.println(f.v1() + " -> " + f.v2());
      }//*/
      
      System.out.println("The result of the BFS traversal starting from vertex 0 is:");
      G.BFS(G, 0);
   }
}