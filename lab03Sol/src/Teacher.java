
/**
 * Teacher class inherited from Person
 * @author cfchen
 *
 */
public class Teacher extends Person {
	/**
	 * class the teacher teach
	 */
	String[] teach;
	
	/**
	 * constructor of teacher
	 * @param n name
	 * @param g gender
	 * @param i id number
	 */
	Teacher(String n, String g, String i){
		name = n;
		gender = g;
		id  = i;
	}
	
	/**
	 * set the courses the teacher teach
	 * @param c courses
	 */
	void setCourses(String[] c){
		teach = c;
	}
	/**
	 * print out the information of teacher
	 */
	void printInfo(){
		System.out.println("This is a teacher");
		System.out.println("Name: "+name);
		System.out.println("Gender: "+gender);
		
		String tmp = "Teach:";
		for(String s:teach){
			tmp = tmp + " "+s;
		}
		System.out.println(tmp);
	}
}