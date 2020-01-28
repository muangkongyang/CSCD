/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * HW2									*
 ****************************************/

public class Counter {
	private int c = 0;

    public synchronized void increment( int n) {
    	// write me here
    	this.c += n;
    }

    public synchronized int total() {
        // write me here
    	return this.c;
    }
}
