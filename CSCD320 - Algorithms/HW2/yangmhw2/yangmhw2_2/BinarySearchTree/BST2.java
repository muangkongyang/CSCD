package yangmhw2_2.BinarySearchTree;

import java.util.*;
import java.io.*;

// This is my Binary Search Tree class
// Will contain all the methods needed for homework2 part 2
public class BST2
{  
   private class Node
   {
      private Node left;
      private Node right;
      private Comparable data;
      private boolean leftVisited;
      private boolean rightVisited;
      
      // Node Constructor
      public Node(final Comparable data)
      {
         this.left = null;
         this.right = null;
         this.data = data;
         this.leftVisited = false;
         this.rightVisited = false;
      }
   }
   
   // Root of BST
   private Node root;
   
   // BST Constructor
   public BST2()
   {
      this.root = null;
   }
   
   // Get Root method
   public Node getRoot()
   {
      return this.root;
   }
   
   // Insert Node with given data into BST (Recursively)
   // Will only call the recursive method
   public void insert(final Comparable data)
   {
      this.root = insertRoot(this.root, data);
   }
   
   // This method will help traverse the BST
   // finding the correct position to insert
   // the data being passed in.
   private Node insertRoot(Node root, final Comparable data)
   {
      // Insert when root is null
      if(root == null)
      {
         Node newNode = new Node(data);
         root = newNode;
      }
      else if(data.compareTo(root.data) < 0)
         root.left = insertRoot(root.left, data);
      else
         root.right = insertRoot(root.right, data);
       
      return root;
   }
   
   // This method will print all of the paths
   // starting from root to each leaf node
   public void printAllPath(final Node root, ArrayList path)
   {
      // Base Case: if node is null, do nothing
      if(root != null)
      {
         path.add(root.data);
         if(root.left == null && root.right == null)
         {
            System.out.println(path);
            return;
         }
         else
         {
            printAllPath(root.left, new ArrayList(path));
            printAllPath(root.right, new ArrayList(path));
         }
      }
      
   }
   
   // This method will print all of the paths
   // starting from root to each leaf node
   // but using Stacks.
   //                My Logic
   // We push the data from root to left leaf
   // nodes first. Then we pop out all the data
   // and print it out using a string.
   // The leaf nodes will then have their
   // leftVisited and rightVisited members true
   // once they are reached. 
   // Each node, mainly parent nodes, will check its left 
   // and right node. If the left or right node has both members
   // set to true, then the parent node will set
   // that respective side to true. If a parent node
   // has both its conditions true, we reposition back to
   // the top, clear the stack, and push back the root in. 
   // This way, that path will not be taken again.
   // We only go on the path where the left or right
   // node has false visited conditions.
   // After the left subtree is done, we start on
   // the right subtree. Once that is done, the root
   // node will have both its conditions set to true, and we
   // pop whatever is left in the stack to get out
   // of the while loop.
   
   public void printAllPath2(Node root)
   {
      if(root != null)
      {
         String path = "";
         int i = 0;
         
         Stack s = new Stack();
         s.push(root);
         Node top = root, temp = null;
         while(!(s.isEmpty()))
         {
            if(root.left == null && root.right == null)
            {
               while(!(s.isEmpty()))
               {
                  temp = (Node) s.pop();
                  path += temp.data + " <- ";
               }
               
               root.leftVisited = true;
               root.rightVisited = true;
               if(root.leftVisited == true && root.rightVisited == true)
               {
                  /* I tried reversing the string, but 2 digit numbers will print out wierd. */
                  //StringBuilder reverseString = new StringBuilder(path);
                  //System.out.println(reverseString.reverse());
                  System.out.println(path);
                  path = "";
                  root = top;
                  s.push(root); 
               }
            }
            else if(root.leftVisited == false && root.rightVisited == false)
            {  
               if(root.left == null)
                  root.leftVisited = true;
               if(root.right == null)
                  root.rightVisited = true;   
                  
               if(root.left != null)
               {
                  if(root.left.leftVisited == true && root.left.rightVisited == true)
                     root.leftVisited = true;
               }
               if(root.right != null)
               {
                  if(root.right.leftVisited == true && root.right.rightVisited == true)
                     root.rightVisited = true;
               }
               if(root.leftVisited == true && root.rightVisited == true)
               {
                  root = top;
                  while(!(s.isEmpty()))
                  {
                     s.pop();
                  }
                  s.push(root);
               }   
               else if(root.left != null && root.leftVisited == false)
               {
                  root = root.left;   
                  s.push(root);
               }
               else if(root.right != null && root.rightVisited == false)
               {
                  root = root.right;
                  s.push(root);
               }   
            }
            else if(root.leftVisited == true && root.rightVisited == false)
            {
               if(root.right != null)
               {
                  if(root.right.leftVisited == true && root.right.rightVisited == true)
                     root.rightVisited = true;
               }
               
               if(root.leftVisited == true && root.rightVisited == true)
               {
                  root = top;
                  while(!(s.isEmpty()))
                  {
                     s.pop();
                  }
                  s.push(root);
               }    
               else if(root.right != null)
               {
                  root = root.right;
                  s.push(root);
               }  
            }
            else
            {
               s.pop();
            }
         }
      }
   }
}