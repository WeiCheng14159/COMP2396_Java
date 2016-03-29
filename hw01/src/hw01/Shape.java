package hw01;

/**
 * Super class Shape 
 * @author chengwei
 */
public class Shape {
	
	/**
	* an integer between 0 and 255 specifying the red color channel.
	*/
	int r;
	
	/**
	* an integer between 0 and 255 specifying the green color channel.
	*/
	int g;
	
	/**
	* an integer between 0 and 255 specifying the blue color channel.
	*/
	int b;
	
	/**
	* a boolean value specifying whether the shape is filled or not filled.
	*/
	boolean isFilled;
	
	/**
	 * a double value specifying the orientation (in radians) of the shape.
	 */
	double theta;
	
	/**
	 * a double value specifying the x-coordinate of the center of the shape.
	 */
	double xc;
	
	/**
	 *  a double value specifying the y-coordinate of the center of the shape.
	 */
	double yc;
	
	/**
	 * an array of double values specifying the x-coordinates of the standard vertices (in counter clock-wise order) of the shape.
	 */
	double[] x; 
	
	/**
	 * an array of double values specifying the y-coordinates of the standard vertices (in counter clock-wise order) of the shape.
	 */
	double[] y;
	
	/**
	 * Set the vertices for this shape object before any rotation is applied to it.
	 * The d argument is defined differently in different Shape object.
	 * This method is to be overridden in subclasses.
	 * 
	 * @param d explain in detail in subclasses.
	 */
	void setVertices(double d){};
	
	/**
	 * Return an array of x-coordinates of actual vertices (in counter-clockwise order) based on its center and orientation.
	 * 
	 * @return an integer array of x-coordinates.
	 */
	int[] getX(){
		int[] tempX = new int[x.length];
		for(int i = 0 ; i < x.length ; i++){
			tempX[i] = (int) Math.round( (x[i]-xc)*Math.cos(theta)-(y[i]-yc)*Math.sin(theta)+xc );
		}
		return tempX;
	}
	
	/**
	 * Return an array of y-coordinates of actual vertices (in counter-clockwise order) based on its center and orientation.
	 * 
	 * @return an integer array of y-coordinates.
	 */
	int[] getY(){
		int[] tempY = new int[this.y.length];
		for(int i = 0 ; i < this.y.length ; i++){
			tempY[i] = (int) Math.round( (x[i]-xc)*Math.sin(theta)+(y[i]-yc)*Math.cos(theta)+yc );
		}
		return tempY;
	}
}
