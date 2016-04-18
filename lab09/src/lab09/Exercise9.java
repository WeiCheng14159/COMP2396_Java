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
	private int mouseX = 0;
	private int mouseY = 0;
	
	/**
	 * main method for testing
	 * @param args arguments passed into main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise9 e9 = new Exercise9();
		e9.go();
	}
	
	/**
	 * reset the instance variable mouseX and mouseY in this object
	 */
	public void resetMouse(){
		this.mouseX = 0 ;
		this.mouseY=0;
	}
	
	/**
	 * start the program
	 */
	void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		drawPanel.addMouseListener(this);
		frame.add(drawPanel);
		frame.setSize(600, 500);
		frame.setVisible(true);
		
		int left = (centerIdx-1+imageNum)%imageNum;
		int right = (centerIdx+1)%imageNum;	
		
    	while(true){
        	//int speed = 10;
        	
			if( images.get(left).getSelected(mouseX, mouseY)[0] == -1 && images.get(left).getSelected(mouseX, mouseY)[1] == 1){
				centerIdx = centerIdx + imageNum - 1; resetMouse();
				//System.out.println("left images clicked");
			}else if( images.get(right).getSelected(mouseX, mouseY)[0] == 1 && images.get(right).getSelected(mouseX, mouseY)[1] == 1){
				centerIdx = centerIdx + imageNum + 1; resetMouse();
				//System.out.println("right image clicked");
			}else{
				//centerIdx = centerIdx + imageNum - 1;
				//System.out.println("nothing clicked");
			}
			
        	// change current center index and calculate the indexes of left and right images
        	centerIdx %= imageNum;
        	left = (centerIdx-1+imageNum)%imageNum;
			right = (centerIdx+1)%imageNum;		
			
			images.get(left).setPos(-1);	//left images doesn't need to move, so directly set its position
			//set the final position of left and right image
			images.get(centerIdx).setPos(0);
			images.get(right).setPos(1);
			frame.repaint();
			
			//introduce delay to the infinite loop 
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
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

	/**
	 * mouse event listener implementation 
	 * @param e Mosue event
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked coordinate (x,y) = (" +e.getX()+","+e.getY()+")");
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
