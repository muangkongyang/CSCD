package yangmhw2_1.BinarySearchTree;

import java.util.*;
import java.io.*;

// This is my Binary Search Tree class
// Will contain all the methods needed for homework2 part 1
public class BST
{  
   private class Node
   {
      private Node left;
      private Node right;
      private Comparable data;
      
      // Node Constructor
      public Node(final Comparable data)
      {
         this.left = null;
         this.right = null;
         this.data = data;
      }
   }
   
   // Root of BST
   private Node root;
   
   // BST Constructor
   public BST()
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
   
   public void inOrderTraversal(final Node root)
   {
      // Base Case: if root is null, do nothing
      if(root != null)
      {  
         inOrderTraversal(root.left);
         System.out.print(root.data + " ");
         inOrderTraversal(root.right);
      }
   }
   
   public void postOrderTraversal(final Node root)
   {
      if(root != null)
      { 
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.print(root.data + " ");
      }
   }
   
   // Deletes 1 Node in BST (Recursively)
   // Will only call the recursive method
   public boolean delete(final Comparable toRemove) throws Exception
   {
      // Preconditions (Empty BST)
      if(this.root == null)
      {
         System.out.println("The BST is empty! Nothing to delete.");
         return false;
      }
      
      Node toDelete = this.root;
      
      try
      {
         toDelete = deleteNode(toDelete, toRemove);
      }
      catch(Exception e)
      {
         System.out.println("Object to remove not found in BST!");
         return false;
      }   
      
      return true;
   }
   
   // This method will help traverse the BST
   // finding the correct Node to delete
   // the data being passed in.
   private Node deleteNode(Node root, final Comparable toRemove) throws Exception
   {
      // Base Case: if root is null, do nothing
      if(root != null)
      {
         Node rootData = root;
         
         if(rootData.left == null && rootData.right == null && toRemove.compareTo(rootData.data) != 0)
            throw new Exception();
         else if(toRemove.compareTo(rootData.data) == 0)
            rootData = deleteFromRoot(rootData, toRemove);
         else if(toRemove.compareTo(rootData.data) < 0)
            rootData.left = deleteNode(rootData.left, toRemove);
         else //if (toRemove.compareTo(rootData.data) > 0)
            rootData.right = deleteNode(rootData.right, toRemove);

      }
      
      return root;
   }
   
   // Case 1: if root node has both left and right children
   // Case 2: if root node only has left child
   // Case 3: if root node only has right child
   // Case 4: if root has no children
   // Helper method for delete
   // Will help re-wire the BST when deleting
   // Will use more helper methods for completion
   private Node deleteFromRoot(Node root, final Comparable toRemove)
   {
      // Case 1
      // Remove from left subtree
      if(this.root.left != null && this.root.right != null && toRemove.compareTo(this.root.data) <= 0)
      {  
         // find largest node in left subtree of the root
         Node largest = root.left;
         largest = findLargest(largest);
         // copy largest object of left subtree to root node
         root.data = largest.data;
         // remove the node of the largest object in left subtree
         removeLargest(root.left);
         
         return root;
      }
      // Remove from right subtree
      else if(this.root.left != null && this.root.right != null && toRemove.compareTo(this.root.data) > 0)
      {         
         // find smallest node in right subtree of the root
         Node smallest = root.right;
         smallest = findSmallest(smallest);
         // copy smallest object of right subtree to root node
         root.data = smallest.data;
         // remove the node of the smallest object in right subtree
         removeSmallest(root.right);
         
         return root;
      }
      
      // Case 2
      else if(root.left == null && root.right != null)
      {
         root = root.right;
         return root;
      }
      
      // Case 3
      else if(root.right == null && root.left != null)
      {
         root = root.left;
         return root;
      }
      
      // Case 4
      else
      {
         root = null;
         return root;
      }
   }
   
   // Helper method for deleteFromRoot for Case 1
   // Will FIND the largest node/object from left subtree of root
   private Node findLargest(final Node root)
   {
      Node largest = root;
      if(root.right != null)
         largest = findLargest(root.right);
      
      return largest;
   }
   
   // Helper method for deleteFromRoot
   // Will REMOVE the largest node/object from left subtree of root
   private Node removeLargest(final Node root)
   {
      Node largest = root;
      if(largest.right != null)
         largest.right = removeLargest(largest.right);
      else 
         largest = largest.left;
         
      return largest;
   }
   
   // Helper method for deleteFromRoot
   // Will FIND the smallest node/object from right subtree of root
   private Node findSmallest(final Node root)
   {
      Node smallest = root;
      if(root.left != null)
         smallest = findSmallest(root.left);
      
      return smallest;
   }
   
   // Helper method for deleteFromRoot
   // Will Remove the smallest node/object from right subtree of root
   private Node removeSmallest(final Node root)
   {
      Node smallest = root;
      if(smallest.left != null)
         smallest.left = removeSmallest(smallest.left);
      else
         smallest = smallest.right;
      
      return smallest;
   }
}