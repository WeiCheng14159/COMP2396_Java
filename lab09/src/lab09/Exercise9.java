package lab09;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.*;

/**
 * Tutorial 9 example and exercise
 * @author cfchen
 *
 */
public class Exercise9 implements MouseListener{
	
	ArrayList<MyImage> images = new ArrayList<MyImage>();
	MyImage background;
	int imageNum=6;
	int centerIdx = 0;
	JFrame frame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise9 e9 = new Exercise9();
		e9.go();
	}
	
	void go(){
		// make a window 
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a new image
		background = new MyImage();
		background.readImage("images/background.jpg");
		
		//read album images
		for(int i=0;i<imageNum;i++){
			MyImage t=new MyImage("images/album"+i+".jpg");
			images.add(t);
		}
		
		//initialize the position of three images to be drawn 
		images.get((centerIdx-1+imageNum)%imageNum).setPos(-1);
		images.get((centerIdx+1)%imageNum).setPos(1);
		
		//make your own panel
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.add(drawPanel);
		frame.addMouseEvent(this);
		frame.setSize(600, 500);
		frame.setVisible(true);
		
		
    	while(true){
        	int speed = 50;
        	
        	// change current center index and calculate the indexes of left and right images
			centerIdx = centerIdx + imageNum - 1;
			centerIdx %= imageNum;
			int left = (centerIdx-1+imageNum)%imageNum;
			int right = (centerIdx+1)%imageNum;		
			images.get(left).setPos(-1);	//left images doesn't need to move, so directly set its position
			//images.get(left).addMouseListener(this);
			
			//move center and right image
			for(int i=0;i<speed-1;i++){
				images.get(centerIdx).moveRight(speed);
				images.get(right).moveRight(speed);
				frame.repaint();
				try {
					Thread.sleep(8);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//set the final position of left and right image
			images.get(centerIdx).setPos(0);
			images.get(right).setPos(1);
			frame.repaint();
			
			//introduce delay to the infinite loop 
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				//sleep fail ?
				e1.printStackTrace();
			}
    	}	
	}
	
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			//calculate three image indexes, and show background and three images.
			int lb = (centerIdx-1+imageNum)%imageNum;
			int rb = (centerIdx+1)%imageNum;
			g.drawImage(background.getContent(), 0, 0, this);
			g.drawImage(images.get(lb).getContent(), images.get(lb).getPos()[0], images.get(lb).getPos()[1], this);
			g.drawImage(images.get(rb).getContent(), images.get(rb).getPos()[0], images.get(rb).getPos()[1], this);
			g.drawImage(images.get(centerIdx).getContent(), images.get(centerIdx).getPos()[0], images.get(centerIdx).getPos()[1], this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse clicked the area");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse press the area");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse release");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse enter the area");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouse exit the area");
	}
}
