import java.util.*;
import java.io.*;

// Implementation of Kruskal's algorithm for a MST
// Uses UnionFind for a more efficient time complexity
public class Kruskal
{
   private Set<Edge> mst = new HashSet<Edge>();
   
   public Kruskal(WeightedGraph G)
   {
      Edge [] edges = G.edges();
      Arrays.sort(edges, Edge.BY_WEIGHT);
      UnionFind uf = new UnionFind(G.V());
      
      for(Edge e: edges)
      {
         int v = e.either();
         int w = e.other(v);
         
         if(!uf.find(v, w))
         {
            uf.unite(v, w);
            mst.add(e);
            //System.out.println(v + " -> " + w);
         }
      }
   }
   
   public Iterable<Edge> edges()
   {
      return mst;
   }
}