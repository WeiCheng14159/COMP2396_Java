package hw01;

/**
 * Square object inherit from Shape
 * @author chengwei
 *
 */
public class Square extends Shape {
	
	/**
	 * Set the vertices for Square object before any rotation is applied.
	 * The d argument is the distance for half of the length of a square.
	 * 
	 * @param d One half of the side length.
	 */
	void setVertices(double d){
		this.x=new double[4];
		this.y=new double[4];
		
		this.x[0]=xc+d;
		this.y[0]=yc+d;
		this.x[1]=xc+d;
		this.y[1]=yc-d;
		this.x[2]=xc-d;
		this.y[2]=yc-d;
		this.x[3]=xc-d;
		this.y[3]=yc+d;
	}
}
