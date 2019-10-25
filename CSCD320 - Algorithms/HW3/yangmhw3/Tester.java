package yangmhw3;

import java.util.*;
import java.io.*;
import yangmhw3.MyBinaryTree.BinaryTree;

// This tester will be used to try and build
// a binary tree with an inOrderSequence and
// a postOrderSequence.
public class Tester
{
   public static void main(String [] args)
   {
      Object in[] = {9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
      Object post[] = {9, 1, 2, 12, 7, 5, 3, 11, 4, 8};
   
      BinaryTree myTree = BinaryTree.buildTree(in, post);
          
      myTree.inOrderTraversal(myTree.getRoot());
      myTree.postOrderTraversal(myTree.getRoot());
   }
}