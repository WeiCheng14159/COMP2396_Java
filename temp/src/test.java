import javax.swing.*;
import java.awt.event.*;

public class test implements ActionListener{

	JButton button;
	
	public static void main(String[] args) {
		test gui = new test();
		gui.go();
	}
	
	public void go(){
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton ("click me ");
		button.addActionListener(this);
		
		frame.add(button);
		frame.setSize(300, 600);
		frame.setVisible(true);
		
		//new frame
		JFrame frame1 = new JFrame ();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MydrawPanel crappy_drawing = new MydrawPanel();
		frame1.add(crappy_drawing);
		
		frame1.setSize(300, 600);
		frame1.setVisible(true);
	}
	
	public void actionPerformed ( ActionEvent event){
		button.setText(" i am clicked !!!");
		System.out.println(event.getWhen());
	}
}
