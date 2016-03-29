package lab06;
import java.util.ArrayList;
/**
 * Test class
 * 
 * @author cfchen
 *
 */
public class Exercise6 {

	/**
	 * main method
	 * @param args commandline argu
	 */
	public static void main(String[] args) {
		// initial database
		Undergraduate s1 = new Undergraduate("S1", "Jack", "male");
		s1.addCourse("JAVA");
		s1.addCourse("C++");
		s1.printInfo();
		
		System.out.println("=============================================");
		
		Postgraduate s2 = new Postgraduate("S2", "Tom", "male");
		s2.addCourse("JAVA");
		s2.addCourse("Python");
		s2.addResearch("computer vision");
		s2.addResearch("database");
		s2.printInfo();
		
		System.out.println("=============================================");
		
		ArrayList<String> teach = new ArrayList<String>();
		teach.add("Python");
		teach.add("JAVA");
		Teacher t1 = new Teacher("T1", "Rose", "female");
		t1.setCourses(teach);
		t1.dropStudent(s1);
		t1.addStudent(s1);
		t1.addStudent(s2);
		t1.addStudent(s2);
		System.out.println("*********************************************");
		t1.printInfo();
	}
}
