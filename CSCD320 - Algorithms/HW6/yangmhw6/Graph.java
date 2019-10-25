import java.util.*;
import java.io.*;

// Undirected Graph with Weight associated with each Edge that connects the vertices
// Will be using an adjacency matrix
public class Graph
{
   private int [][] matrix;
   private int numEdge;
   public int Mark[]; // Will be using int since vertex has integers
   final int VISITED = 1; // To note visited vertices
   
   // Graph Construtor
   public Graph(int n)
   {
      this.Mark = new int[n]; // VISITED flag for each vertex
      this.matrix = new int[n][n];
      this.numEdge = 0;
   }
   
   public int n() // number of vertices
   {
      return Mark.length;
   }
   
   public int e() // number of edges
   {
      return numEdge;
   }
   
   public Edge first(int v) // get first edge connecting v
   {
      for(int i = 0; i < n(); i++)
      {
         if(matrix[v][i] != 0)
            return new Edge(v, i);
      }
      
      return null;
   }
   
   public Edge next(Edge w) // gets the next edge
   {
      if(w != null)
      {
         for(int i = w.v2() + 1; i < n(); i++)
         {
            if(matrix[w.v1()][i] != 0)
               return new Edge(w.v1(), i);
         }
      }
      
      return null;
   }
   
   // Checks to see if the edge exists
   public boolean isEdge(Edge w)
   {
      if(w != null)
      {
         int v1 = w.v1();
         int v2 = w.v2();
      
         if(matrix[v1][v2] != 0 && matrix[v2][v1] != 0)
            return true;
      }
      
      return false;
   }
   
   // Checks to see if the edge exists from coordinates
   public boolean isEdge(int i, int j)
   {
      if(i > 0 && i < n() && j > 0 && j < n())
      {
         if(matrix[i][j] != 0 && matrix[j][i] != 0)
            return true;
      }
      
      return false;
   }
   
   public int v1(Edge w)
   {
      return w.v1();
   }
   
   public int v2(Edge w)
   {
      return w.v2();
   }
   
   // Modify Undirected Graph w/ weight & coordinates
   public void setEdge(int i, int j, int wt)
   {
      if(matrix[i][j] == 0 && matrix [j][i] == 0)
         numEdge++;
         
      matrix[i][j] = wt;
      matrix[j][i] = wt;
   }
   
   // Modify Undirected Graph w/ weight & edge
   public void setEdge(Edge w, int wt)
   {
      if(matrix[v1(w)][v2(w)] == 0 && matrix[v2(w)][v1(w)] == 0)
         numEdge++;
      
      matrix[v1(w)][v2(w)] = wt;
      matrix[v2(w)][v1(w)] = wt;
   }
   
   public int weight(int i, int j)
   {
      return matrix[i][j];
   }
   
   public int weight(Edge w)
   {
      return matrix[v1(w)][v2(w)];
   }
   // Set Mark of vertex v
   public void setMark(int v, int visited)
   {
      Mark[v] = VISITED;
   }
   
   // Get Mark of vertex v
   public int getMark(int v)
   {
      return Mark[v];
   }
   
   // Breadth-First Search Traversal (BFS)
   public void BFS(Graph G, int start)
   {
      Queue<Integer> q = new LinkedList<Integer>();
      
      q.add(start); // add to end of list
      G.setMark(start, VISITED); // Mark the start vertex as visited
      
      while(!q.isEmpty())
      {
         int v = q.remove();
         System.out.print(v + " ");
         for(Edge w = G.first(v); G.isEdge(w); w = G.next(w))
         {
            if(G.getMark(w.other(v)) != VISITED)
            {
               q.add(G.v2(w));
               G.setMark(G.v2(w), VISITED);
            }
         }
      }
   }
}