import course.*;
import java.util.*;

public class CourseIteratorTester 
{
	@SuppressWarnings("rawtypes")
	public static void main(String [] args)
	{	
		Course cscd = new Course();
		Student one = new Student("Muangkong", "Yang", 4391, 3.5);
		Student two = new Student("Steve", "Harvy", 3231, 3.9);
		Student three = new Student("Mike", "Ackerman", 5967, 4.0);
	
		cscd.addStudent(one);
		cscd.addStudent(two);
		cscd.addStudent(three);
		
		System.out.println("\tTesting Foreach Loop");
		for(Student s: cscd.getStudentList())
			System.out.println(s);

		System.out.println("\tTesting Regular For Loop");
		for(int i = 0; i < cscd.getStudentList().size(); i++)
			System.out.println(cscd.getStudentList().get(i));
		
		System.out.println("\tTesting Iterator Methods");
		Iterator it = cscd.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
