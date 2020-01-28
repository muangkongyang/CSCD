/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * Lab1									*
 ****************************************/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class CSCD467Lab1 extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	private static Thread t1, t2;
	private static JTextArea output;
	
	public CSCD467Lab1(String name) 
	{
		super(name);
		//JTextArea output = new JTextArea(20,30) // Can this statement replace the next one?
		
		output = new JTextArea(20,30);                      //create JTextArea in which all messages are shown.
		DefaultCaret caret = (DefaultCaret)output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);  // JTextArea always set focus on the last message appended.
		
		
		add(new JScrollPane(output)); // add a Scroll bar to JFrame, scrolling associated with JTextArea object
		setSize(500, 500);            // when lines of messages exceeds the line capacity of JFrame, scroll bar scroll down.
		setVisible(true);
		output.addKeyListener(this);  // Adds the specified key listener to receive key events from this component.
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(t1.isAlive())
			t1.interrupt();
		else if(!t1.isAlive() && !t2.isAlive())
			output.append("All threads terminated.\n");
		else
			t2.interrupt();
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();  //study KeyEvent class API
		if (keyCode == KeyEvent.VK_ENTER)
			output.append("Key Released, you just pressed an Enter Key!\n");
		else
			output.append("Key Released, you just pressed the character \'" + e.getKeyChar() + "\'\n" );
	}
	
	public static void main(String[] args)
	{
		CSCD467Lab1 lab1 = new CSCD467Lab1("CSCD467Lab1");
		
		lab1.addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent e)
				{
					System.exit(0);
				}
			});
		
		t1 = new Thread(new Displayer(output), "Thread-1");
		t2 = new Thread(new Displayer(output), "Thread-2");
		
		t1.start();
		t2.start();
	}
}
