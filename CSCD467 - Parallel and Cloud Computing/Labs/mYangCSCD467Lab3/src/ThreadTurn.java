/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab3									*
 ****************************************/

public class ThreadTurn
{
	private static boolean IsThread1Turn = true;
	
	public static synchronized void setThread1Turn(boolean value)
	{
		IsThread1Turn = value;
	}
	
	public static synchronized boolean getThread1Turn()
	{
		return IsThread1Turn;
	}
}


