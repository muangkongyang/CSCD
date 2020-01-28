/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab3									*
 ****************************************/

public class Alternation {
	Thread t1;
	Thread t2;
	
	public Alternation() {
		
		t1 = new Thread(new Runnable() {
	        @Override
	        public void run() {
                for (int i = 1; i <= 50; ) 
                {
                	if(ThreadTurn.getThread1Turn())
                	{
	                    System.out.println("Message " + i + " from Thread T1.");
	                    ThreadTurn.setThread1Turn(false);
	                    i += 2;
	                    try{Thread.sleep(10);}
	                    catch(InterruptedException e){}
                	}
                }//end of for
	        }
	    });
	    t2 = new Thread(new Runnable() {

	        @Override
	        public void run() {
                for (int i = 2; i <= 50; ) 
                {
                	if(!ThreadTurn.getThread1Turn())
                	{
                		System.out.println("Message " + i + " from Thread T2.");
	                    ThreadTurn.setThread1Turn(true);
	                    i += 2;
	                    try{Thread.sleep(10);}
	                    catch(InterruptedException e){}
                	}
                }
	        }
	    });
	    t1.start();
	    t2.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Alternation();
	}
}


