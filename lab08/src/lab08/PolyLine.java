package lab08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuqiu
 *
 */
public class PolyLine {

	private List<Point> points = new ArrayList<Point>();
	// Allocate an ArrayList of Points and upcast to List

	/**
	 * Default Constructor
	 */
	public PolyLine() {
	
	}
	
	/**
	 * @param points: a list of point
	 */
	public PolyLine(List<Point> points) {
		this.points = points;
	}

	// 
	/**
	 * Append a point (x,y) to the end of this polyline
	 * @param x: x-axis
	 * @param y: y-axis
	 */
	public void appendPoint(int x, int y) {
		Point newPoint = new Point(x, y);
		this.appendPoint(newPoint);
	}

	/**
	 * Append a point instance to the end of this polyline
	 * @param point: a new point
	 */
	public void appendPoint(Point point) {
		if( points.contains(point)){
			System.out.println("This point "+point.toString() +" already exists!!");
		}else{
			points.add(point);
		}
	}
	
	/**
	 * Delete a point (x,y) from this polyline
	 * @param x: x-axis
	 * @param y: y-axis
	 */
	public void deletePoint(int x, int y) {
		Point newPoint = new Point(x, y);
		this.deletePoint(newPoint);
	}
	
	
	/**
	 * Delete a point instance from this polyline
	 * @param point: a new point
	 */
	public void deletePoint(Point point) {
		if( points.contains(point) ){
			points.remove(point);
		}else{
			System.out.println("No such point "+point.toString()+"!!");
		}
	}

	
	/**
	 * return (x1,y1)(x2,y2)(x3,y3)....
	 * If empty, return "Empty PolyLine"
	 */
	public String toString() {
		String temp="";
		if( !points.isEmpty()){
			System.out.print("Polyline: ");
			for( int i = 0 ; i < points.size();i++){
				temp += points.get(i).toString();
			}
			return temp;
		}else{
			return "Empty Polyline";
		}
	}
}
