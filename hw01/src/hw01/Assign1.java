package hw01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class provides a simple GUI for visualizing Square objects and Triangle objects. 
 * Users can draw squares and triangles by simply clicking and dragging the mouse in 
 * the drawing canvas.
 * <p>
 * Usage:
 * <ul>
 * <li>Clicking the left mouse button and dragging the mouse will draw a filled square with a random color;</li>
 * <li>Clicking the left mouse button while holding the [ALT] key down, and dragging the mouse will draw an unfilled square with a random color;</li>
 * <li>Clicking the right mouse button and dragging the mouse will draw a filled triangle with a random color;</li>
 * <li>Clicking the right mouse button while holding the [ALT] key down, and dragging the mouse will draw an unfilled triangle with a random color;</li>
 * <li>By holding the [SHIFT] key while dragging the mouse, the orientation of the shape will then be restricted to 0, 90, 180 or 270 degrees.</li>
 * </ul>
 * @author Kenneth Wong
 *
 */
public class Assign1 {
	private ArrayList<Shape> list = new ArrayList<Shape>();
	private JFrame frame;
	private boolean resizing = false;
	private int xm, ym;
	
	/**
	 * Creates an instance of the Assign1 class and calls its go() method to starting the ball rolling.
	 * @param args not being used in this application.
	 */
	public static void main(String[] args) {
		Assign1 a1 = new Assign1();
		a1.start();
	}
	
	/**
	 * Constructor of the Assign1 class.
	 */
	public Assign1() { }
	
	/**
	 * Builds the GUI and allows users to start drawing squares and triangles. 
	 */
	public void start() {
		frame = new JFrame();
		frame.setTitle("COMP2396 Assignment 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyAnimPanel animPanel = new MyAnimPanel();
		animPanel.addMouseListener(new MyMouseListener());
		animPanel.addMouseMotionListener(new MyMouseMotionListenser());

		frame.getContentPane().add(animPanel);
		frame.setSize(600, 400);
		frame.setVisible(true);
	} // close go() method

	class MyMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {
			resizing = true;
			Shape shape;
			if (e.getButton() == MouseEvent.BUTTON1) {
				shape = new Square();
			} else {
				shape = new Triangle();
			}
			
			shape.r = (int) (Math.random()*256);
			shape.g = (int) (Math.random()*256);
			shape.b = (int) (Math.random()*256);
			shape.isFilled = (!e.isAltDown());
			shape.theta = 0;
			shape.xc = xm = e.getX();
			shape.yc = ym = e.getY();
			shape.setVertices(0);
			list.add(shape);		
		}
	
		public void mouseReleased(MouseEvent e) {
			resizing = false;
			frame.repaint();
		}
	} // close inner class
	
	class MyMouseMotionListenser implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			if (list.size() > 0) {
				xm = e.getX();
				ym = e.getY();
				Shape shape = list.get(list.size() - 1);
				double dx = xm - shape.xc;
				double dy = ym - shape.yc;
				if (e.isShiftDown()) {
					if (Math.abs(dx) > Math.abs(dy)) {
						dy = 0.0;
					} else {
						dx = 0.0;
					}
				}
				shape.setVertices(Math.hypot(dx, dy));
				if (dx >= 0){
					shape.theta = Math.atan(dy / dx);
				} else {
					shape.theta = Math.atan(dy / dx) + Math.PI;
				}
			}
			frame.repaint();
		}
		public void mouseMoved(MouseEvent e) {}
	}
	
	class MyAnimPanel extends JPanel {
		private static final long serialVersionUID = 3434052834963106098L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
		    g.fillRect(0, 0, this.getWidth(), this.getHeight());

			for (Shape shape : list) {
				g.setColor(new Color(shape.r, shape.g, shape.b));
				if (shape.isFilled) {
					g.fillPolygon(shape.getX(), shape.getY(), shape.getX().length);
				} else {
					g.drawPolygon(shape.getX(), shape.getY(), shape.getX().length);
				}
			}
			
			if (list.size() > 0 && resizing) {
				Shape shape = list.get(list.size() - 1);
				g.setColor(Color.BLACK);
				g.drawLine((int) Math.round(shape.xc), (int) Math.round(shape.yc), xm, ym);
			}	
		}
	} // close inner class
}