/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab2									*
 ****************************************/

public class Lab2 
{
	public static void main(String[] args) throws InterruptedException
	{
		Counter count = new Counter(1);
		
		Thread waiterThread = new Thread(new Waiter(), "Waiter Thread");
		Thread printerThread = new Thread(new Printer(count, waiterThread), "Printer Thread");
		
		printerThread.start();
		waiterThread.start();
		
		printerThread.join();
		waiterThread.join();
		
		System.out.println("Both Waiter and Printer have finished their work!");
	}
}
