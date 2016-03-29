package hw02;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class provides a simple GUI for visualizing RegularPolygon objects.
 * Users can draw random regular polygon by simply clicking and dragging the
 * mouse in the drawing canvas.
 * <p>
 * Usage:
 * <ul>
 * <li>Clicking the left mouse button and dragging the mouse will draw a random
 * regular n-sided polygon filled with a random color;</li>
 * <li>By holding the [SHIFT] key while drawing the polygon by dragging the
 * mouse, the orientation of the polygon will be restricted to 0, 90, 180 or 270
 * degrees.</li>
 * <li>Clicking the right mouse button on a polygon will select this polygon and
 * bring it to the top, and dragging the mouse while keeping the right mouse
 * button down will move this polygon;</li>
 * <li> Clicking the right mouse button on a polygon with the [CONTROL] key down
 * will destroy this polygon.</li>
 * </ul>
 * 
 * @author Kenneth Wong
 *
 */
public class Assign2 {
	private ArrayList<RegularPolygon> list = new ArrayList<RegularPolygon>();
	private JFrame frame;
	private boolean resizing = false, moving = false;
	private boolean button1 = false, button2 = false;
	private int xm, ym;
	private RegularPolygon newPolygon = null, selectedPolygon = null;

	/**
	 * Creates an instance of the Assign2 class and calls its start() method to
	 * starting the ball rolling.
	 * 
	 * @param args
	 *            not being used in this application.
	 */
	public static void main(String[] args) {
		Assign2 a2 = new Assign2();
		a2.start();
	}

	/**
	 * Constructor of the Assign2 class.
	 */
	public Assign2() {
	}

	/**
	 * Builds the GUI and allows users to start drawing squares and triangles.
	 */
	public void start() {
		frame = new JFrame();
		frame.setTitle("COMP2396 Assignment 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyAnimPanel animPanel = new MyAnimPanel();
		animPanel.addMouseListener(new MyMouseListener());
		animPanel.addMouseMotionListener(new MyMouseMotionListenser());

		frame.getContentPane().add(animPanel);
		frame.setSize(600, 400);
		frame.setVisible(true);
	} // close start() method

	class MyMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				button1 = true;
				xm = e.getX();
				ym = e.getY();
				int n = (int) (Math.random() * 10) + 3;
				System.out.println(n + "-sided polygon created...");
				// create a n-sided polygon and initialize its parameters
				newPolygon = new RegularPolygon(n, 0);
				Color color = new Color((int) (Math.random() * 256),
						(int) (Math.random() * 256),
						(int) (Math.random() * 256));
				newPolygon.setColor(color);
				newPolygon.setFilled(true);
				newPolygon.setTheta(0);
				newPolygon.setCenter(xm, ym);
			} else if (e.getButton() == MouseEvent.BUTTON2 || e.getButton() == MouseEvent.BUTTON3) {
				button2 = true;
				xm = e.getX();
				ym = e.getY();
				// search for the top-most polygon that contains (xm, ym)
				for (int i = list.size() - 1; i >= 0; i--) {
					RegularPolygon polygon = list.get(i);
					if (polygon.contains(xm, ym)) {
						System.out.println("polygon selected...");
						polygon.setFilled(false);
						selectedPolygon = polygon;
						// put the selected polygon on top
						list.remove(selectedPolygon);
						list.add(selectedPolygon);
						break;
					}
				}
				frame.repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				button1 = false;
				resizing = false;
				if (newPolygon != null) {
					xm = e.getX();
					ym = e.getY();
					// remove newly created polygon if its scale is zero
					if (newPolygon.getRadius() == 0) {
						System.out.println("zero-sized polygon removed...");
					} else {
						list.add(newPolygon);
						System.out.println("polygon finalized...");
					}
					newPolygon = null; 
					frame.repaint();
				}
			} else if (e.getButton() == MouseEvent.BUTTON2 || e.getButton() == MouseEvent.BUTTON3) {
				button2 = false;
				moving = false;
				if (selectedPolygon != null) {
					if (e.isControlDown()) {
						list.remove(selectedPolygon);
						System.out.println("polygon removed...");
					} else {
						selectedPolygon.setFilled(true);
						System.out.println("polygon deselected...");
					}
					selectedPolygon = null;
					frame.repaint();
				}
			}
		}
	} // close inner class

	class MyMouseMotionListenser implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			if (button1) {
				if (newPolygon != null) {
					if (resizing == false) {
						resizing = true;
						System.out.println("resizing...");
					}
					xm = e.getX();
					ym = e.getY();
					// update the size and orientation of the newly created
					// polygon
					double dx = xm - newPolygon.getXc();
					double dy = ym - newPolygon.getYc();
					if (e.isShiftDown()) {
						// restrict the orientation to 0, 90, 180, 270 degrees
						if (Math.abs(dx) > Math.abs(dy)) {
							dy = 0.0;
						} else {
							dx = 0.0;
						}
					}
					double alpha = 0;
					int n = newPolygon.getNumOfSides();
					if (n % 2 == 0) {
						alpha = Math.PI / n;
					}
					newPolygon.setRadius(Math.hypot(dx, dy) / Math.cos(alpha));
					if (dx >= 0) {
						newPolygon.setTheta(Math.atan(dy / dx));
					} else {
						newPolygon.setTheta(Math.atan(dy / dx) + Math.PI);
					}
					frame.repaint();
				}
			} else if (button2) {
				if (selectedPolygon != null) {
					if (moving == false) {
						moving = true;
						System.out.println("moving...");
					}
					// translate the selected polygon
					selectedPolygon.translate(e.getX() - xm, e.getY() - ym);
					xm = e.getX();
					ym = e.getY();
					frame.repaint();
				}
			}
		}

		public void mouseMoved(MouseEvent e) {
		}
	} // close inner class

	class MyAnimPanel extends JPanel {
		private static final long serialVersionUID = 3434052834963106098L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			// rendering the list of polygons
			for (RegularPolygon polygon : list) {
				g.setColor(polygon.getColor());
				if (polygon.getFilled()) {
					g.fillPolygon(polygon.getX(), polygon.getY(),
							polygon.getNumOfSides());
				} else {
					g.drawPolygon(polygon.getX(), polygon.getY(),
							polygon.getNumOfSides());
				}
			}

			// rendering the new polygon with the drawing line
			if (newPolygon != null) {
				g.setColor(newPolygon.getColor());
				if (newPolygon.getFilled()) {
					g.fillPolygon(newPolygon.getX(), newPolygon.getY(),
							newPolygon.getNumOfSides());
				} else {
					g.drawPolygon(newPolygon.getX(), newPolygon.getY(),
							newPolygon.getNumOfSides());
				}
				g.setColor(Color.BLACK);
				g.drawLine((int) Math.round(newPolygon.getXc()),
						(int) Math.round(newPolygon.getYc()), xm, ym);
			}
		}
	} // close inner class
}