package lab08;
/**
 * @author Yuqiu
 *
 */
public class Tester {
	public static void main(String[] args) {
		PolyLine l = new PolyLine();
		System.out.println(l.getClass());
		System.out.println(l);
		
		l.appendPoint(new Point(1, 1));
		System.out.println(l);
		
		l.appendPoint(2, 2);
		System.out.println(l);
		
		l.appendPoint(2, 2);
		System.out.println(l);
		
		l.appendPoint(3, 3);
		System.out.println(l);
		
		l.deletePoint(2, 2);
		System.out.println(l);
		
		l.deletePoint(new Point(2, 1));
		System.out.println(l);
	}

}
