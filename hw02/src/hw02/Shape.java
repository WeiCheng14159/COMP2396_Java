package hw02;
import java.awt.Color;

/**
 * Super class Shape 
 * @author chengwei
 */

public class Shape {
	private//private instance variables and methods
	
		/**
		 * A color object specifying the color of the shape
		 */
		Color color;
		
		/**
		 * a boolean value specifying whether the object is filled with color
		 */
		boolean filled; 
		
		/**
		 * a double value specifying the orientation of the shape in radian 
		 */
		double theta;
		
		/**
		 * a double value specifying the x-coordinate of the center of the shape in the world coordinate system
		 */
		double xc;
		
		/**
		 * a double value specifying the y-coordinate of the center of the shape in the world coordinate system
		 */
		double yc;
		
		/**
		 * an array of the double value specifying the x-coordinate of the vertices (in counter-clockwise order) of the shape in its local system 
		 */
		double[] xLocal;
		
		/**
		 * an array of the double value specifying the y-coordinate of the vertices (in counter-clockwise order) of the shape in its local system 
		 */
		double[] yLocal;
		
	public//public instance variables and methods
		
		/**
		 * a method object for retrieving the color of the shape
		 * @return color object 
		 */
		Color getColor(){
			return this.color;
		}
		
		/**
		 * a method for retrieving the fill-type of the shape
		 * @return a boolean value, true for filled false for not filled
		 */
		boolean getFilled(){
			return this.filled;
		}
		
		/**
		 * a method for retrieving the orientation of the shape
		 * @return a double value of showing the orientation of the shape
		 */
		double getTheta(){
			return this.theta;
		}
		
		/**
		 * a method for retrieving the x-coordinate of the center of the shape 
		 * @return x-coordinate of the center of the shape in double value
		 */
		double getXc(){
			return this.xc;
		}
		
		/**
		 * a method for retrieving the y-coordinate of the center of the shape 
		 * @return y-coordinate of the center of the shape in double value
		 */
		double getYc(){
			return this.yc;
		}
		
		/**
		 * a method for retrieving the x-coordinate of the vertices in the world coordinate system 
		 * @return an array of x-coordinate in double value
		 */
		double[] getXLocal(){
			return this.xLocal;
		}
		
		/**
		 * a method for retrieving the y-coordinate of the vertices in the world coordinate system 
		 * @return an array of y-coordinate in double value
		 */
		double[] getYLocal(){
			return this.yLocal;
		}
		
		/**
		 * a method for setting the color of the shape 
		 * @param color a color object pass as argument 
		 */
		void setColor(Color color){
			this.color = color;
		}
		
		/**
		 * a method for setting the color of the shape 
		 * @param r	Color red value ranging from 0-255
		 * @param g Color green value ranging from 0-255
		 * @param b Color blue value ranging from 0-255
		 */
		void setColor(int r, int g ,int b){
			Color temp = new Color (r,g,b);
			this.color = temp;
		}
		
		/**
		 * a method for setting the filled-type of the shape
		 * @param filled a boolean value specifying whether the shape is filled
		 */
		void setFilled(boolean filled){
			this.filled = filled;
		}
		
		/**
		 * a method for setting the orientation of the shape
		 * @param theta orientation in double value
		 */
		void setTheta(double theta){
			this.theta = theta;
		}
		
		/**
		 * a method for setting the x-coordinate of the center of the shape in the world coordinate system
		 * @param x x-coordinate in double value
		 */
		void setXc(double x){
			this.xc = x;
		}
		
		/**
		 * a method for setting the y-coordinate of the center of the shape in the world coordinate system
		 * @param y y-coordinate in double value
		 */
		void setYc(double y){
			this.yc = y;
		}
		
		/**
		 *  a method for setting the coordinates of the center of the shape in the world (screen) coordinate system
		 * @param x x-coordinate in double value
		 * @param y y-coordinate in double value
		 */
		void setCenter(double x, double y){
			this.xc = x ; this.yc = y ;
		}
		
		/**
		 * a method for setting the x-coordinates of the vertices of the shape in its local coordinate system
		 * @param x x-coordinate in double type array
		 */
		void setXLocal(double[] x){
			this.xLocal = x ;
		}
		
		/**
		 * a method for setting the y-coordinates of the vertices of the shape in its local coordinate system
		 * @param y y-coordinate in double type array
		 */
		void setYLocal(double[] y){
			this.yLocal = y;
		}
		
		/**
		 *  a method for setting the coordinates of the vertices of the shape in its local coordinate system
		 * @param x x-coordinate in double type array
		 * @param y y-coordinate in double type array
		 */
		void setXYLocal(double[] x, double[] y){
			this.xLocal = x; 
			this.yLocal = y;
		}
		
		/**
		 * a method for translating the center of the shape by dx and dy, respectively, along the x and y directions of the world (screen) coordinate system
		 * @param dx shift x-coordinate by dx in x direction 
		 * @param dy shift y-coordinate by dy in x direction
		 */
		void translate(double dx, double dy){
			this.xc += dx;
			this.yc += dy;
		}
		
		/**
		 * a method for rotating the shape about its center by an angle of theta (in radians)
		 * @param theta rotate by theta angle 
		 */
		void rotate(double theta){
			this.theta += theta;
		}
		
		/**
		 * Return an array of x-coordinates of actual vertices (in counter-clockwise order) based on its center and orientation.
		 * 
		 * @return an integer array of x-coordinates.
		 */
		int[] getX(){
			int[] tempX = new int[xLocal.length];
			for(int i = 0 ; i < xLocal.length ; i++){
				tempX[i] = (int) Math.round( (xLocal[i])*Math.cos(theta)-(yLocal[i])*Math.sin(theta)+xc );
			}
			return tempX;
		}
		
		/**
		 * Return an array of y-coordinates of actual vertices (in counter-clockwise order) based on its center and orientation.
		 * 
		 * @return an integer array of y-coordinates.
		 */
		int[] getY(){
			int[] tempY = new int[this.yLocal.length];
			for(int i = 0 ; i < this.yLocal.length ; i++){
				tempY[i] = (int) Math.round( (xLocal[i])*Math.sin(theta)+(yLocal[i])*Math.cos(theta)+yc );
			}
			return tempY;
		}	
}
