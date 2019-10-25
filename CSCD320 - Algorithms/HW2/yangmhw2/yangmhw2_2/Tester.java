package yangmhw2_2;
import yangmhw2_2.BinarySearchTree.BST2;

import java.util.*;
import java.io.*;

// This is a tester for my Binary Search Tree class
public class Tester
{
   public static void main(String [] args) throws Exception
   {
      BST2 myBST = new BST2();
      myBST.insert(8);
      myBST.insert(3);
      myBST.insert(1);
      myBST.insert(6);
      myBST.insert(4);
      myBST.insert(7);
      myBST.insert(10);
      myBST.insert(14);
      myBST.insert(13);
      
      ArrayList newList = new ArrayList();
      
      System.out.println("For Recursive printAllPath()");
      myBST.printAllPath(myBST.getRoot(), newList);
      System.out.println();
      
      System.out.println("For Iterative printAllPath() using stacks.");
      System.out.println("NOTE: Read from right to left.");
      myBST.printAllPath2(myBST.getRoot());
   }
}