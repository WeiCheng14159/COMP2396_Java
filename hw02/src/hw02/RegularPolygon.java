package hw02;

/**
 * RegularPolygon is a subclass of shape
 * @author chengwei
 *
 */
public class RegularPolygon extends Shape {
	private//private instance variables and methods
	
		/**
		 * an integer value specifying the number of sides of the regular polygon
		 */
		int numOfSides;
	
		/**
		 * a double value specifying the radius of the regular polygon
		 */
		double radius;
		
		/**
		 * a double value specifying (the length of) the apothem of the regular polygon
		 */
		double apothem;
		
		/**
		 * a double value specifying (the length of) the side of the regular polygon
		 */
		double side;
		
		/**
		 * a double value specifying the area of the regular polygon
		 */
		double area;
		
		/**
		 *  a double value specifying the perimeter of the regular polygon
		 */
		double perimeter;
		
		/**
		 *  a method for initializing the local coordinates of the vertices of the regular polygon
		 */
		void setVertices(){
			this.xLocal = new double[this.numOfSides];
			this.yLocal = new double[this.numOfSides];
			if( this.numOfSides % 2 == 1){// odd number of vertices
				for( int i = 0 ; i < this.numOfSides ; i++){
					double deg = 2 * Math.PI / this.numOfSides * i; 
					this.xLocal[i] = this.radius * Math.cos( deg );
					this.yLocal[i] = this.radius * Math.sin( deg );
				}
			}else{
				for(int i = 0 ; i < this.numOfSides ; i++){
					double deg = 2 * Math.PI / this.numOfSides * i;
					this.xLocal[i] = this.radius * Math.cos( deg + Math.PI / this.numOfSides );
					this.yLocal[i] = this.radius * Math.sin( deg + Math.PI / this.numOfSides );
				}
			}
		}
		
		/**
		 * a method for initializing (the length of) the apothem of the regular polygon
		 */
		void setApothem(){
			this.apothem = this.radius * Math.cos( Math.PI / this.numOfSides );
		}
		
		/**
		 * a method for initializing (the length of) the side of the regular polygon
		 */
		void setSide(){
			this.side = this.radius * Math.sin( Math.PI / this.numOfSides );
		}
		
		/**
		 * a method for initializing the area of the regular polygon
		 */
		void setArea(){
			double r = this.radius; 
			int n = this.numOfSides; 
			this.area = 0.5 * r * r * Math.sin( 2.0 * Math.PI / n ) * n; 
		}
		
		/**
		 * a method for initializing the perimeter of the regular polygon
		 */
		void setPerimeter(){
			double r = this.radius; 
			int n = this.numOfSides;
			this.perimeter = 2 * r * Math.sin( Math.PI/n );
		}
		
		/**
		 *a method for setting the number of sides of the regular polygon
		 * @param n number of sides in integer value
		 */
		void setNumOfSide(int n ){
			if( n < 3)
				n = 3;
			this.numOfSides = n;
			this.buildPolygon();
		}
		
	public//public instance variables and methods
	
		/**
		 * a constructor for building a regular n-sided polygon with a radius of r
		 * @param n An integer value specifying the number of sides
		 * @param r An double value specifying the radius of the polygon
		 */
		RegularPolygon(int n , double r){
			if( n < 3 )
				n = 3;
			if( r < 0 )
				this.radius = 0;
			this.numOfSides = n;
			this.radius = r;
		}
		
		/**
		 *  a constructor for building a regular n-sided polygon with a radius of 1.0
		 * @param n An integer value specifying the number of sides
		 */
		RegularPolygon(int n ){
			this.radius = 1.0;
			if( n < 3)
				n = 3;
			this.numOfSides = n;
		}
		
		/**
		 * a constructor for building a regular 3-sided polygon with a radius of 1.0
		 */
		RegularPolygon(){
			this.radius = 1.0;
			this.numOfSides = 3;
		}
		
		/**
		 * an integer value specifying the number of sides of the regular polygon
		 * @return an integer value showing the number of sides of the polygon
		 */
		int getNumOfSides(){
			return this.numOfSides;
		}
		
		/**
		 * a double value specifying the radius of the regular polygon
		 * @return a double value showing the radius of the polygon
		 */
		double getRadius(){
			return this.radius;
		}
		
		/**
		 * a double value specifying the length of the apothem of the regular polygon.
		 * @return the length of the apothem in double type
		 */
		double getApothem(){
			return this.apothem;
		}
		
		/**
		 * a double value specifying the length of the side of the regular polygon
		 * @return the length of the sides in double value
		 */
		double getSide(){
			return this.side;
		}
		
		/**
		 * a double value specifying the area of the regular polygon
		 * @return the area of the polygon in double value
		 */
		double getArea(){
			return this.area;
		}
		
		/**
		 *  a double value specifying the perimeter of the regular polygon
		 * @return the perimeter of the polygon in double type
		 */
		double getPerimeter(){
			return this.perimeter;
		}
		
		/**
		 * a method for setting the radius of the regular polygon
		 * @param r radius in double value
		 */
		void setRadius(double r){
			this.radius = r;
			this.buildPolygon();
		}
		
		/**
		 * a method for initializing the local coordinate of the vertices, the apothem, side, area and perimeter of the regular polygon
		 */
		void buildPolygon(){
			setSide();
			this.setApothem();
			this.setPerimeter();
			this.setVertices();
			this.setArea();
		}
		
		/**
		 * a method for determining if a point (x, y) in world (screen) coordinate system is contained by the regular polygon
		 * @param x the x-coordinate of the point
		 * @param y the y-coordinate of the point
		 * @return a boolean value, true if the point is inside the polygon, and false if not
		 */
		boolean contains(double x, double y){

			double leftMostLimit = - apothem;
			
			//System.out.println("leftMostLimit : "+ leftMostLimit);
			
			for( int i = 0 ; i < this.numOfSides ; i++){
				double deg = 2 * Math.PI / this.numOfSides * i - theta; 
				if( leftMostLimit > ( (x-xc)*Math.cos(deg)-(y-yc)*Math.sin(deg) ) ){
					return false;
				}
			}
			return true;
		}
		
}
