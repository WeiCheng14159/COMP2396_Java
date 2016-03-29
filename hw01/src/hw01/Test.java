package hw01;

/**
 * A tester class for testing the correctness of code.
 * @author chengwei
 *
 */
public class Test {
	
	/**
	 * A main method that prints the x,y coordinates of each vertices.
	 * A Square and Triangle are tested.
	 * Nothing is assumed to be passed to the arguments.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		Square s = new Square();
		int size = 3;
		s.r=120;
		s.g=120;
		s.b=120;
		s.isFilled=true;
		s.theta=Math.PI/7;
		s.xc=0;
		s.yc=0;
		s.setVertices(size);
		
		System.out.println("***A Square :\n>>center of shape is ( "+s.xc+" , "+s.yc+" )"
				+ "\n>>size: "+size);
		System.out.println(">>The vertices for a Square \n( x , y )");
		for(int i=0;i<4;i++){
			System.out.println("( "+s.x[i]+" , "+s.y[i]+" )");
		}
		
		Triangle t = new Triangle();
		t.r=100;
		t.g=100;
		t.b=100;
		t.isFilled=false;
		t.theta=Math.PI/6;
		t.xc=10;
		t.yc=5;
		t.setVertices(size);
		
		System.out.println("\n\nA Triangle :\n>>center of shape is ( "+t.xc+" , "+t.yc+" )"
				+ "\n>>size: "+size);
		System.out.println(">>The vertices for a Triangle \n( x , y )");
		for(int i=0;i<3;i++){
			System.out.println("( "+t.x[i]+" , "+t.y[i]+" )");
		}
	}
}
