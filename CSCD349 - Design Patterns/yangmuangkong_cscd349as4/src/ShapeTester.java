import shapes.*;
import java.util.*;

public class ShapeTester 
{
	public static void main(String[] args) 
	{
		ShapeFactory A = new ShapeFactory();
		ArrayList<Shape> myList = new ArrayList<Shape>();
		
		Shape circle = A.createCircle(9);
		Shape triangle = A.createTriangle(3, 5);
		Shape square = A.createSquare(3);
		Shape rectangle = A.createRectangle(8, 2);
		Shape triangle1 = A.createTriangle(1, 13);
		Shape circle1 = A.createCircle(3);
		Shape square1 = A.createSquare(6);
		Shape rectangle1 = A.createRectangle(5, 3);
		
		myList.add(circle);
		myList.add(triangle);
		myList.add(square);
		myList.add(rectangle);
		myList.add(circle1);
		myList.add(triangle1);
		myList.add(rectangle1);
		myList.add(square1);
		
		System.out.println("List before sort");
		for(Shape s: myList)
			s.printArea();
		
		System.out.println();
		
		System.out.println("List after sort");
		Collections.sort(myList);
		for(Shape s: myList)
			s.printArea();
	}

}
