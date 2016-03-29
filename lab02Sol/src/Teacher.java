
/**
 * Teacher class inherited from Person
 * @author cfchen
 *
 */
public class Teacher extends Person {
	/**
	 * class the teacher teach
	 */
	private String teach;
	/**
	 * initialize the information of teacher
	 * @param tid id
	 * @param n name
	 * @param g gender
	 * @param t teach
	 */
	void initial(String tid, String n, String g, String t){
		name=n;
		gender=g;
		id=tid;
		teach=t;
	}
	/**
	 * print out the information of teacher
	 */
	void printInfo(){
		System.out.println("This is a teacher");
		System.out.println("Name: "+name);
		System.out.println("Gender: "+gender);
		System.out.println("Teach: "+teach);
	}
}
