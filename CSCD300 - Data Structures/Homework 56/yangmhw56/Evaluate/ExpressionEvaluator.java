package yangmhw56.Evaluate;

import java.util.*;
import java.io.*;
import yangmhw56.Stack.LinkedStack;

public class ExpressionEvaluator
{
   public String infixToPostFix(final String infix)
   {
      if(infix == null)
         throw new IllegalArgumentException("Infix expression is null");
      if(infix.length() == 0)
         throw new IllegalArgumentException("Infix expression is empty");
   
      // Create empty stack 
      // Stack contains String elements
      LinkedStack<String> stack = new LinkedStack<String>();

      // Initialize String for output
      String output = "";
      int i = 0;
      int stackPrec = 0;
      int curPrec = 0;
      
      // Evaluation
      while(i < infix.length()) //infix.substring(i) != null)
      {
         String tmp = infix.substring(i,i+1);
         
         // if current item is operand
         if(tmp.matches(".*[0-9].*"))
            output += tmp;
         // if current item is '('
         else if(tmp.equals("("))
            stack.push(tmp);
         // if current item is ')'   
         else if(tmp.equals(")"))
         {
            while(!(stack.isEmpty()) &&!(((String)stack.peek()).equals("(")))
            {
               output += stack.pop();
            }
            
            // pop the '('
            if(!(stack.isEmpty()))
               stack.pop();
            else
               throw new EmptyStackException();
         }
         // else current item is operator
         else
         {
            curPrec = getCurrentPrecendence(tmp);
            
            while(!(stack.isEmpty()) && (getStackPrecedence((String) stack.peek()) > curPrec))
            {
               output += stack.pop();
            }
            
            stack.push(tmp);
         }
         
         i++;
      }
      
      while(!(stack.isEmpty()))
      {
         output += stack.pop();
      }
      
      return output;
   }
   
   public int postFixResult(final String postfix)
   {
      if(postfix == null)
         throw new IllegalArgumentException("Postfix expression is null");
         
      if(postfix.length() == 0)
         throw new IllegalArgumentException("Postfix expression is empty");
      
      // Initialize empty stack
      // Stack contains Integer elements
      LinkedStack<Integer> stack = new LinkedStack<Integer>();

      int i = 0;
      
      int right, left, tempOutput;
      int result = 0;
      
      // Postfix Evaluation
      while(i < postfix.length())
      {
         String tmp = postfix.substring(i, i+1);
         
         // if current item is an operand
         if(tmp.matches(".*[0-9].*"))
            stack.push(Integer.parseInt(tmp));
         // else is operator
         else
         {
            right = (int) stack.pop();
            left = (int) stack.pop();
            tempOutput = operatorEvaluation(left, tmp, right);
            stack.push(tempOutput);
         }
         
         i++;
      }
      
      if(stack.size() == 1)
         result = (int) stack.pop();
      else
      {
         System.out.println("Postfix expression has an error.");
      }
      
      return result;
   }  
   
  /***************************************
   * Following the table in lecture notes*
   ***************************************/
   
   // Stack precedence helper method
   public int getStackPrecedence(final String s)
   {
      if(s == null || s.length() == 0)
         throw new IllegalArgumentException("Stack string passed in is null or empty");
      
      int prec;
      
      if(s.equals("^"))
         prec = 5;
      else if(s.equals("*") || s.equals("/") || s.equals("%"))
         prec = 4;
      else if(s.equals("+") || s.equals("-"))
         prec = 2;
      else
         prec = 0;
            
      return prec;   
   }
   
   // Current item precedence helper method
   public int getCurrentPrecendence(final String s)
   {
      if(s == null || s.equals(""))
         throw new IllegalArgumentException("Current string passed in is null or empty");
         
      int prec;
      
      if(s.equals("("))
         prec = 100;
      else if(s.equals("^"))
         prec = 6;
      else if(s.equals("*") || s.equals("/") || s.equals("%"))
         prec = 3;
      else if(s.equals("+") || s.equals("-"))
         prec = 1;
      else
         prec = 0;
            
      return prec; 
   }
   
  /**************************************************
   * This method will evaluate an expression        *
   * using a binary operator passed in as a String  *
   * and left and right integers.                   *
   **************************************************/
   // Operation helper method
   public int operatorEvaluation(final int left, final String operator, final int right) throws ArithmeticException
   {
      if(operator == null)
         throw new IllegalArgumentException("Evaluation has null operator!");
         
      //int leftOperand = Integer.parseInt(left);
      //int rightOperand = Integer.parseInt(right);
      
      // Handles case of Denominator being 0 when dividing
      if(operator.equals("/") && right == 0)
         throw new ArithmeticException();
      
      int eval = 0;
      
      if(operator.equals("^"))
         eval = (int) Math.pow(left, right);
      else if(operator.equals("*"))
         eval = left * right;
      else if(operator.equals("/"))
         eval = left / right;
      else if(operator.equals("%"))
         eval = left % right;
      else if(operator.equals("+"))
         eval = left + right;
      else if(operator.equals("-"))
         eval = left - right;
      else
         System.out.println("Incompatable operator for this method");
      
      return eval;
   }
}