public class Tester {
	 public static void main(String args[])
	    {
		 	System.out.println("1. Create new Undergraduate Student");
		 	System.out.println("*******************************");
	        Undergraduate c1 = new Undergraduate();
	        c1.printInfo();
	        System.out.println("\n");
	        
	        System.out.println("2. Create new Undergraduate Student");
		 	System.out.println("*******************************");
	        c1 = new Undergraduate("Jason");
	        c1.printInfo();
	        System.out.println("\n");
	        
	        System.out.println("3. Create new Postgraduate Student");
	        System.out.println("*******************************");
	        Postgraduate c2 = new Postgraduate();
	        c2.printInfo();
	        System.out.println("\n");
	        
	        System.out.println("4. Create new Postgraduate Student");
	        System.out.println("*******************************");
	        c2 = new Postgraduate("Alex");
	        c2.printInfo();
	    }
}
