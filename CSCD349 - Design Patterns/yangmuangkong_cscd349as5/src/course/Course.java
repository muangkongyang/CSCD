package course;
import java.util.*;

public class Course implements Iterable<Student>
{
	private ArrayList<Student> list;
	
	// Nested iterator class
	private class CourseIterator implements Iterator<Student> 
	{
		private ArrayList<Student> listRef;
		private int index = 0;
		
		private CourseIterator(ArrayList<Student> listRef)
		{
			this.listRef = listRef;
		}
		
		@Override
		public boolean hasNext() 
		{
			return index < listRef.size();
		}

		@Override
		public Student next() 
		{
			if(hasNext())
			{
				Student temp = this.listRef.get(index);
				this.index++;
				return temp;
			}
			else
				throw new IllegalStateException("Out of array length.");
		}
	}
	
	// Constructor
	public Course()
	{
		this.list = new ArrayList<Student>();
	}
	
	public ArrayList<Student> getStudentList()
	{
		return this.list;
	}
	
	public void addStudent(Student theStudent)
	{
		this.list.add(theStudent);
	}
	
	public void removeStudent(Student theStudent)
	{
		this.list.remove(theStudent);
	}
	
	@Override
	public Iterator<Student> iterator() 
	{
		return new CourseIterator(this.list);
	}
	
}
