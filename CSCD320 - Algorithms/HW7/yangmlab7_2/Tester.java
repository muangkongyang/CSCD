/* Homework 7 Part 2
 * Will be a program consisting of a weighted graph
 * and implementation of the Union-Find data structure */
 
 import java.util.*;
 import java.io.*;
 
 public class Tester
 {
   public static void main(String [] args)
   {
      WeightedGraph G = new WeightedGraph(8);
      G.addEdge(new Edge(0, 1, 4));
      G.addEdge(new Edge(0, 2, 6));
      G.addEdge(new Edge(0, 3, 16));
      G.addEdge(new Edge(1, 7, 24));
      G.addEdge(new Edge(2, 3, 8));
      G.addEdge(new Edge(2, 5, 5));
      G.addEdge(new Edge(2, 7, 23));
      G.addEdge(new Edge(3, 4, 21));
      G.addEdge(new Edge(3, 5, 10));
      G.addEdge(new Edge(4, 5, 14));
      G.addEdge(new Edge(4, 6, 7));
      G.addEdge(new Edge(5, 6, 11));
      G.addEdge(new Edge(5, 7, 18));
      G.addEdge(new Edge(6, 7, 9));
      
      System.out.println("The MST contains the following edges: ");
      Kruskal mst = new Kruskal(G);
      
      for(Edge e : mst.edges())
      {
         System.out.println(e.v + " -> " + e.w);
      }
   }
 }