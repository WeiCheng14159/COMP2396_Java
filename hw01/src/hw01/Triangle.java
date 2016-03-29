package hw01;

/**
 * Triangle object inherits from Shape
 * @author chengwei
 *
 */
public class Triangle extends Shape {
	
	/**
	 * Set the vertices for Triangle object before any rotation is applied.
	 * The d argument is the circumscribed circle radius of a equilateral triangle.
	 * 
	 * @param d The radius of a circumscribed circle.
	 */
	void setVertices(double d){
		double sixty = Math.PI/3;
		
		this.x=new double[3];
		this.y=new double[3];
		
		this.x[0]=xc+d;
		this.y[0]=yc;
		this.x[1]=xc-d*Math.cos(sixty);
		this.y[1]=yc-d*Math.sin(sixty);
		this.x[2]=xc-d*Math.cos(sixty);
		this.y[2]=yc+d*Math.sin(sixty);
	}
}
