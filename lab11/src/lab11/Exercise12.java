package lab11;
import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * This is for java tutorial 12
 * @author cfchen
 * 
 */
public class Exercise12 {
	
	private JRadioButton mathButton;
	private JRadioButton nullButton;
	private JRadioButton arrayButton;
	private JRadioButton fileButton;
	private JRadioButton numberButton;
	private JRadioButton myexButton;

	/**
	 * main method
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		Exercise12 e = new Exercise12();
		e.go();
	}
	
	private JRadioButton addRadioButton(String s, ButtonGroup g, MyPanel p){
		JRadioButton button = new JRadioButton(s, false);
		button.addActionListener(p);
		g.add(button);
		p.add(button);
		return button;
	}
	
	/* this is used to show a message string s in a dialog */
	private void showMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	/**
	 * launch the window
	 */
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel p = new MyPanel();
		p.setLayout(new GridLayout(6, 1));
		
		ButtonGroup g = new ButtonGroup();
		mathButton = addRadioButton("Arithmetic Exception", g, p);
		nullButton = addRadioButton("NullPointer Exception", g, p);
		arrayButton = addRadioButton("ArrayIndexOutOfBounds Exception", g, p);
		fileButton = addRadioButton("FileNotFound Exception", g, p);
		numberButton = addRadioButton("NumberFormat Exception", g, p);
		myexButton = addRadioButton("MyException", g, p);
		
		frame.add(p);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	/**
	 * custom panel which implement the action listener
	 */
	public class MyPanel extends JPanel implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO do your exercise here
			try{
				Object source = e.getSource();
				if(source == mathButton) {
					System.out.println("math button is selected");
					int a = 0 ; int b = 1;
					int c = b/a;
				}else if( source == nullButton){
					System.out.println("null exception button is selected");
					String d = null;
					d.concat("aple");
				}
				else if( source == arrayButton){
					System.out.println("array exception button is selected");
					int [] f = new int [3];
					System.out.println(f[5]);
				}
				else if( source == fileButton){
					System.out.println("file exception button is selected");
					File file = new File("file.txt");
					BufferedReader reader = new BufferedReader(new FileReader(file));
					
				}
				else if( source == numberButton){
					System.out.println("number exception button is selected");
					String g = "apple";
					int h = Integer.parseInt(g);
				}
				else if( source == myexButton){
					System.out.println("my exception button is selected");
					throw new myexception("my exception");
				}else{
					System.out.println("nothing is selected");
				}
			}
			
			catch(ArrayIndexOutOfBoundsException arrex){
				showMessage(arrex.getMessage());
			}
			catch(NumberFormatException numex){
				showMessage(numex.getMessage());
			}
			catch(NullPointerException nullex){
				showMessage(nullex.getMessage());
			}
			catch(ArithmeticException ex){
				showMessage(ex.getMessage());
			}
			catch(FileNotFoundException fex){
				showMessage(fex.getMessage());
			}
			catch(myexception mex){
				showMessage(mex.getMessage());
			}
			finally{
				System.out.println("exception handling done");
			}
			
		}
		
		/**
		 * inner class : my exception 
		 * @author chengwei
		 *
		 */
		private class myexception extends Exception{
			public myexception(String msg){
				super(msg);
			}
		}
	}
}
