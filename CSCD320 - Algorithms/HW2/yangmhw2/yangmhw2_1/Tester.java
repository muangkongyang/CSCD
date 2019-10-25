package yangmhw2_1;
import yangmhw2_1.BinarySearchTree.BST;

import java.util.*;
import java.io.*;

// This is a tester for my Binary Search Tree class
public class Tester
{
   public static void main(String [] args) throws Exception
   {
      BST myBST = new BST();
      myBST.insert(8);
      myBST.insert(3);
      myBST.insert(1);
      myBST.insert(6);
      myBST.insert(4);
      myBST.insert(7);
      myBST.insert(10);
      myBST.insert(14);
      myBST.insert(13);
      
      // First insertion
      System.out.println("For 1st insertion");
      System.out.print("InOrderTraversal = { ");
      myBST.inOrderTraversal(myBST.getRoot());
      System.out.println("}");
      
      System.out.print("PostOrderTraversal = { ");
      myBST.postOrderTraversal(myBST.getRoot());
      System.out.println("}\n");
      
      // Deleting object with data of 8
      boolean toDelete = myBST.delete(new Integer(8));
      
      if(toDelete == false)
         System.out.println("No object 8 in BST.");
      else
      {
         System.out.println("Deleting data with object 8");
         System.out.print("InOrderTraversal = { ");
         myBST.inOrderTraversal(myBST.getRoot());
         System.out.println("}");
      
         System.out.print("PostOrderTraversal = { ");
         myBST.postOrderTraversal(myBST.getRoot());
         System.out.println("}\n");
      }
      
      // Deleting object with data of 10
      toDelete = myBST.delete(new Integer(10));
      
      if(toDelete == false)
         System.out.println("No object 10 in BST.");
      else
      {
         System.out.println("Deleting data with object 10");
         System.out.print("InOrderTraversal = { ");
         myBST.inOrderTraversal(myBST.getRoot());
         System.out.println("}");
         
         System.out.print("PostOrderTraversal = { ");
         myBST.postOrderTraversal(myBST.getRoot());
         System.out.println("}\n");
      }
      
      // Testing an object not in BST
      // Deleting object with data of 2
      toDelete = myBST.delete(new Integer(2));
      
      if(toDelete == false)
         System.out.println("No object 2 in BST.");
      else
      {
         System.out.println("Deleting data with object 2");
         System.out.print("InOrderTraversal = { ");
         myBST.inOrderTraversal(myBST.getRoot());
         System.out.println("}");
      
         System.out.print("PostOrderTraversal = { ");
         myBST.postOrderTraversal(myBST.getRoot());
         System.out.println("}\n");
      }
      /******************************************************************************
      *  The binary search tree at step 11 is:
                      
                        7
                       / \
                      3   13
                     / \    \
                    1   6    14
                       /
                      4
                       
         You can get the postorder traversal algorithm from the tree from step 11 
         following my postOrderTraversal() in my BST class. Basically, we print the
         node contents after its left and right subtree has been traversed.
            postOrderTraversal: 
         1) We start from the root node, which is 7. We first move down the left
         subtree to reach leaf nodes, reaching 1 in this case.
            postOrderTraversal: 1
         2) We then return back to its parent node 3, and then move down the tree
         until the left deapest leaf node is found, which is 4.
            postOrderTraversal: 1, 4
         3) We return back to 6, then to 3.
            postOrderTraversal: 1, 4, 6, 3
         4) Before printing the root, we walk down the right subtree now, until
         we reach the furthest right leaf node in right subtree. In this case,
         it is 14.
            postOrderTraversal: 1, 4, 6, 3, 14
         5) We return back to previous nodes, which is only 13, printing them out.
            postOrderTraversal: 1, 4, 6, 3, 14, 13
         6) We now return back to the root node, and we print it.
            postOrderTraversal: 1, 4, 6, 3, 14, 13, 7
      *******************************************************************************/
   }
}