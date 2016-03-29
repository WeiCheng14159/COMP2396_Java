import java.util.Random;
/**
 * @author Tutor
 * @version 2.0
 *
 * Arithmetic Progression calculator (Sum)
 * Use Random class
 */

public class ap {

	/**
	 * @param args Command line arguments
	 * 
	 * The main function to start program execution
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		Random random = new Random();
		int sum = 0;
		
		n = random.nextInt(100) + 1;
		
		sum = ((1 + n) * n / 2);
		
		System.out.println("n: " + n);
		System.out.println("arithmetic series: " + sum);
	}

}

/*
 
public class ap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		int sum = 0;
		
		n = ((int) (Math.random() * 100 + 1));
		
		sum = ((1 + n) * n / 2);
		
		System.out.println("n: " + n);
		System.out.println("arithmetic series: " + sum);
	}

}

*/