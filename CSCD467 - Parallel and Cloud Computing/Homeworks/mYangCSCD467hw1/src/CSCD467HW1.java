/****************************************
 * Muangkong Yang						*
 * CSCD467 Parallel and Cloud Computing *
 * HW1									*
 ****************************************/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class CSCD467HW1 extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	private static Thread t1;
	private static JTextArea output;
	private static String message;
	
	public CSCD467HW1(String name) 
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
		
		message = ""; // Sets message to empty string
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		if(e.getKeyCode() != KeyEvent.VK_ENTER)
			setMessage(message += e.getKeyChar());
	}	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{		
		if(t1 != null && t1.isAlive())
		{
			t1.interrupt();
			message = "";
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{	
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
			threadStart();
	}
	
	public static String getMessage()
	{
		return message;
	}
	
	private void setMessage(String newMessage)
	{
		if(newMessage == null)
			message = "";
		
		message.equals(newMessage);
	}
	
	private static void threadStart()
	{
		checkExit();

		t1 = new Thread(new DisplayMode(output, message));
		t1.start();
	}
	
	private static void checkExit()
	{
		if(message.equalsIgnoreCase("exit\n"))
			System.exit(0);
	}
	
	public static void main(String[] args)
	{
		CSCD467HW1 hw1 = new CSCD467HW1("CSCD 467 Assignment1");
		
		hw1.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		
		threadStart();
	}
}
