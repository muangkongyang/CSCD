// This is Homework 8 for CSCD320 - Algorithms
// Graph is a Directed Graph
// Finds the shortest path from a starting source to
// every vertex in the graph. Note there may be unreachable
// vertices from specific starting sources.

import java.util.*;
import java.io.*;

public class Tester
{
   public static void main(String [] args)
   {
      WeightedGraph G = new WeightedGraph(8);
      
      G.addEdge(new Edge(1, 2, 9));
      G.addEdge(new Edge(1, 6, 14));
      G.addEdge(new Edge(1, 7, 15));
      G.addEdge(new Edge(2, 3, 24));
      G.addEdge(new Edge(3, 5, 2));
      G.addEdge(new Edge(3, 8, 19));
      G.addEdge(new Edge(4, 3, 6));
      G.addEdge(new Edge(4, 8, 6));
      G.addEdge(new Edge(5, 4, 11));
      G.addEdge(new Edge(5, 8, 16));
      G.addEdge(new Edge(6, 3, 18));
      G.addEdge(new Edge(6, 5, 30));
      G.addEdge(new Edge(6, 7, 5));
      G.addEdge(new Edge(7, 5, 20));
      G.addEdge(new Edge(7, 8, 44));
      
      Dijkstra shortestPath = new Dijkstra(G);
      
      int source = 1;
      
      // Test other sources for this Graph
      //source = 2;
      //source = 3;
      //source = 4;
      //source = 5;
      //source = 6;
      //source = 7;
      //source = 8;
      
      shortestPath.findShortestPath(G, source);
      shortestPath.path(source);
      
      //G.printGraph(); // Prints the Graph
      
      
   }
}