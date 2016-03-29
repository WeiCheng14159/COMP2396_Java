
public class Person {
	/**
	 * string variable that stores a Person's name
	 */
	String name;
	
	/**
	 * string variable that stores a Person's gender
	 */
	String gender;
	
	/**
	 * string variable that stores a Person's id
	 */
	String id;
	
	/**
	 * Get the id of the person 
	 * @return id of this person
	 */
	String getId(){
		return id;
	}
	
	/**
	 * print out the information of student/teacher
	 * override by subclasses Student and Teacher
	 */
	void printInfo(){
		
	}
}
