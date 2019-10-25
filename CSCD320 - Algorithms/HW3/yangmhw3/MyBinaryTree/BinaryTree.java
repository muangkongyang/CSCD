package yangmhw3.MyBinaryTree;

import java.util.*;
import java.io.*;

// Will contain the BST class for homework 3
// The methods will build a binary tree
// according to a list of values passed in.
public class BinaryTree
{
   private class Node
   {
      private Node left;
      private Node right;
      private Object data;
   
      public Node(Object data)
      {
         this.left = null;
         this.right = null;
         this.data = data;
      }
   }
   
   private Node root;
   
   public BinaryTree()
   {
      this.root = null;
   }
   
   public Node getRoot()
   {
      return this.root;
   }
   
   // Binary Tree Builder
   public static BinaryTree buildTree(Object inOrderSequence[], Object postOrderSequence[])
   {  
      // Base Case
      if(inOrderSequence.length == 0 && postOrderSequence.length == 0)
         return null;
      
      if(inOrderSequence.length == 1 && postOrderSequence.length == 1)
      {
         Object rootNode = (Object) postOrderSequence[postOrderSequence.length - 1];
         BinaryTree theRoot = (BinaryTree) rootNode;
         return theRoot;
      }
      
      // Finds the root of the Post-Order Sequence
      Object rootNode = postOrderSequence[postOrderSequence.length - 1];
      
      // Determines the size of left and right Object array
      int leftTreeElements = leftNumElem(inOrderSequence, rootNode);
      int rightTreeElements = rightNumElem(inOrderSequence, postOrderSequence, rootNode);
      
      // Determines the four total parts from both in-order and post-order sequences
      Object inOrderLeft[] = leftInOrder(inOrderSequence, leftTreeElements);     
      Object inOrderRight[] = rightInOrder(inOrderSequence, leftTreeElements, rightTreeElements);
      Object postOrderLeft[] = leftPostOrder(postOrderSequence, leftTreeElements);
      Object postOrderRight[] = rightPostOrder(postOrderSequence, leftTreeElements, rightTreeElements);
      
      BinaryTree newRoot = (BinaryTree) rootNode; // Giving me ClassCastException: Integer cannot be cast to BinaryTree
      
      newRoot.getRoot().left = (Node) buildTree(inOrderLeft, postOrderLeft).getRoot();
      newRoot.getRoot().right = (Node) buildTree(postOrderLeft, postOrderRight).getRoot();
      
      return newRoot;
   }
   
   // Helper method to find left subtree of inOrder
   public static Object[] leftInOrder(final Object inOrderSequence[], final int leftNumElem)
   {
      Object newLeftInOrder[] = new Object[leftNumElem];
      
      // To search for the index
      for(int i = 0; i < leftNumElem; i++)
      {
         Object data = inOrderSequence[i];
         newLeftInOrder[i] = data;
      }
      
      return newLeftInOrder;
   }
   
   // Helper method to find right subtree of inOrder
   public static Object[] rightInOrder(final Object inOrderSequence[], final int leftNumElem, final int rightNumElem)
   {
      Object newRightInOrder[] = new Object[rightNumElem];
      int j = 0;
      for(int i = leftNumElem + 1; j < rightNumElem; i++, j++)
      {
         Object data = inOrderSequence[i];
         newRightInOrder[j] = data;
      }
      
      return newRightInOrder;
   }
   // Helper method to find left subtree of postOrder
   public static Object[] leftPostOrder(final Object postOrderSequence[], final int leftNumElem)
   {
      Object newLeftPostOrder[] = new Object[leftNumElem];

      for(int i = 0; i < leftNumElem; i++)
      {
         Object data = postOrderSequence[i];
         newLeftPostOrder[i] = data;
      }
      
      return newLeftPostOrder;
   }
   // Helper method to find right subtree of postOrder
   public static Object[] rightPostOrder(final Object postOrderSequence[], final int leftNumElem, final int rightNumElem)
   {
      Object newRightPostOrder[] = new Object[rightNumElem];
      int j = 0;
      for(int i = leftNumElem; j < rightNumElem; i++, j++)
      {
         Object data = postOrderSequence[i];
         newRightPostOrder[j] = data;
      }
      
      return newRightPostOrder;
   }
   
   // Helper method to find the # of left subtree elements
   public static int leftNumElem(final Object sequence[], final Object root)
   {
      int i = 0;
      while(i < sequence.length && !sequence[i].equals(root))
      {
         i++;
      }
      
      return i;
   }
   
   public static int rightNumElem(final Object inSequence[], final Object postSequence[], final Object root)
   {
      int i = 0, j = 0;
      while(i < inSequence.length && !inSequence[i].equals(root))
      {
         i++;
      }
      
      i = i + 1;
      while(i < inSequence.length)
      {
         i++;
         j++;
      }
      
      return j;
   }
   
   public void inOrderTraversal(final Node root)
   {
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
}