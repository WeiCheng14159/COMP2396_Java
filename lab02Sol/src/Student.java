
/**
 * Student class, inherited from Person
 * @author cfchen
 *
 */
public class Student extends Person {

	/**
	 * course of this student
	 */
	String study;

	/**
	 * initialize the information of student
	 * @param sid id
	 * @param n name
	 * @param g gender
	 * @param st study
	 */
	void initial(String sid, String n, String g, String st){
		name=n;
		gender=g;
		id=sid;
		study=st;
	}
	/**
	 * print out the information of student
	 */
	void printInfo(){
		System.out.println("This is a student");
		System.out.println("Name: "+name);
		System.out.println("Gender: "+gender);
		System.out.println("Study: "+study);
	}
}
