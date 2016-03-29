package hw02;

/**
 * a tester class for testing Shape class and its subclass RegularPolygon class
 * @author chengwei
 *
 */
public class Tester {

	public static void main(String[] args) {
		
		double probe_x = 0.5;
		double probe_y = 0.5;
		RegularPolygon a = new RegularPolygon(3,1.0);
		a.buildPolygon();
		a.setCenter(0.0, 0.0);
		a.setTheta(Math.PI/2);
		a.setColor(1000, 255, 255);
		a.setFilled(false);
		a.translate(0, 0);
		a.rotate(0);
		
		System.out.println("Number of sides: "+a.getNumOfSides());
		System.out.println("Radius: "+a.getRadius());
		System.out.println("Apothem: "+a.getApothem());
		System.out.println("Side: "+a.getSide());
		System.out.println("Area: "+a.getArea());
		System.out.println("Permimeter: "+a.getPerimeter());
		System.out.println("Theta: "+a.getTheta());
		System.out.println("Xc: "+a.getXc()+"  Yc: "+a.getYc());
		System.out.println("Red: "+a.getColor().getBlue());
		System.out.println("Green: "+a.getColor().getGreen());
		System.out.println("Blue: "+a.getColor().getBlue());
		System.out.println("filled? : "+a.getFilled());
		
		System.out.println("\nvertices world coordiante");
		for(int i = 0 ; i < a.getNumOfSides(); i++){
			System.out.println("Vertix num "+i+" : ( "+a.xLocal[i]+" , "+a.yLocal[i]+" ) ");
		}
		
		int[] worldX = a.getX();
		int[] worldY = a.getY();
		
		System.out.println("\nvertices world coordiante round to integer value");
		for(int i = 0 ; i < a.getNumOfSides(); i++){
			System.out.println("Vertix num "+i+" : ( "+worldX[i]+" , "+worldY[i]+" ) ");
		}
		System.out.println("\nPoint inside this point: ( "+probe_x+" , "+probe_y+" ) ?"+a.contains( probe_x , probe_y ));
	}

}
