package course;

public class Student 
{
	private String first;
	private String last;
	private int sid;
	private double gpa;
	
	public Student(String first, String last, int sid, double gpa)
	{
		this.first = first;
		this.last = last;
		this.sid = sid;
		this.gpa = gpa;
	}
	
	public String getFirst() 
	{
		return this.first;
	}
	
	public void setFirst(String first) 
	{
		if(first == null)
			throw new IllegalArgumentException("First name is null.");
		if(first.isEmpty())
			throw new IllegalArgumentException("First name is empty.");
		
		this.first = first;
	}

	public String getLast() 
	{
		return this.last;
	}

	public void setLast(String last) 
	{
		if(last == null)
			throw new IllegalArgumentException("Last name is null.");
		if(last.isEmpty())
			throw new IllegalArgumentException("Last name is empty.");
		
		this.last = last;
	}

	public int getSid() 
	{
		return this.sid;
	}

	public void setSid(int sid) 
	{
		this.sid = sid;
	}

	public double getGpa() 
	{
		return this.gpa;
	}

	public void setGpa(double gpa) 
	{
		if(gpa < 0.0 || gpa > 4.0)
			throw new IllegalArgumentException("Invalid gpa.");
		
		this.gpa = gpa;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + getFirst() + " " + getLast() + "\n" +
			   "SID: " + getSid() + "\n" +
			   "GPA: " + getGpa() + "\n";
	}
}
