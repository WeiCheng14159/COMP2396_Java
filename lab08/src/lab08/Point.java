package lab08;

/**
 * @author Yuqiu
 *
 */
public class Point {
	private int x;
	private int y;
	 
	/**
	 * @param x: x-axis
	 * @param y: y-axis
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @param p: a point instance
	 */
	public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
	
	/**
	 * return (x,y)
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * return hashCode 
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	/**
	 * compare the object parameter with the current object
	 * return true if they are the same 
	 */
	public boolean equals(Object o){
		if( o instanceof Point){
			if( ((Point) o).x == this.x && ((Point) o).y == this.y ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	  }

}

