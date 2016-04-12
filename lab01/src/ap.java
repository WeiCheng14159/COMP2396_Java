import java.util.Scanner;

public class ap {

	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		
		System.out.print("n: ");
		int n = input.nextInt();
		
		System.out.print("arithmetic series: ");
		System.out.println((1+n)*n/2);
		input.close();
	}

}