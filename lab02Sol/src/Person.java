
/**
 * super class of Student and Teacher
 * @author cfchen
 *
 */
public class Person {
	/**
	 * name of the person
	 */
	String name;
	/**
	 * gender of the person
	 */
	String gender;
	/**
	 * person id
	 */
	String id;
	
	/**
	 * Get the id of the person
	 * @return id of this person
	 */
	String getID(){
		return id;
	}
	

	/**
	 * initialize the information of teacher/student
	 * @param s1 id
	 * @param s2 name
	 * @param s3 gender
	 * @param s4 teach/study
	 */
	void initial(String s1, String s2, String s3, String s4 ){
		
	}
	
	/**
	 * print out the information of student/teacher
	 */
	void printInfo(){
		
	}
}
