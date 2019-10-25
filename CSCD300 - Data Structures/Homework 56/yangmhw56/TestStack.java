package yangmhw56;

import java.util.*;
import java.io.*;
import yangmhw56.Stack.LinkedStack;
import yangmhw56.Evaluate.ExpressionEvaluator;

public class TestStack
{
   public static void main(String [] args) throws Exception
   {
      // Objects
      Scanner kb = new Scanner(System.in);
      PrintStream p = new PrintStream(System.out);
      ExpressionEvaluator eval = new ExpressionEvaluator();
      
      // Variables
      String infixExpression = "";
      String postFixExpression = "";
      int result;
      
      // Main Program
      p.println("NOTE: This program only deals with one-digit operands and produces results");
      p.println("      based only on the usage of these binary operators. (e.g. /,*,+,-,%,^).\n");
      
      do
      {
         p.print("Please enter the infix expression to process: ");
         infixExpression = kb.nextLine();
         infixExpression = infixExpression.replaceAll("\\s",""); // to deal with whitespace
      } while(!(infixExpression.matches(".*[(,),/,*,+,-,^,%].*") && infixExpression.matches(".*[0-9].*")));
      
      // Infix to Postfix
      try
      {
         postFixExpression = eval.infixToPostFix(infixExpression);
         p.println("The postfix expression for the input infix is: " + postFixExpression);
         
         // Postfix Evaluation
         try
         {
            result = eval.postFixResult(postFixExpression);
            p.println("The final result after evaluating the postfix is: " + result);
         }
         catch(ArithmeticException e)
         {
            p.println("ERROR: Division with denominator of 0 exists!");
         }  
      }
      catch(EmptyStackException e) 
      {
         p.println("Infix expression contains error(s)");
      }
   }
   
}