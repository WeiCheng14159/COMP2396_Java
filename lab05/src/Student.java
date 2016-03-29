import java.util.ArrayList;

/**
 * Define a student
 * @author sqluo
 *
 */
public class Student extends Person {
	/**
	 * The courses the student study
	 */
	ArrayList<String> study;
	
	/**
	 * Consructor for the Student class
	 * @param id student ID
	 * @param name student name
	 * @param gender student gener
	 */
	Student(String id, String name, String gender)
	{
		this.id=id;
		this.name=name;
		this.gender=gender;
		study=new ArrayList<String>();
	}
	
	/**
	 * add a course named addC
	 * @param addC the course to be added
	 */
	void addCourse(String addC){
		if(study.contains(addC)){
			System.out.println("You have already selected "+addC);
		}else{
			study.add(addC);
		}
	}
	
	/**
	 * drop a course named dropC
	 * @param dropC the course to be dropped
	 */
	void dropCourse(String dropC){
		if(!study.contains(dropC)){
			System.out.println("You have not selected "+dropC);
		}else{
			study.remove(dropC);
		}
	}
	
	/**
	 * test whether a course is selected
	 * @param c the tested course
	 * @return true if course c is selected, otherwise false
	 */
	Boolean isSeleted(String c){
		if(study.indexOf(c) == -1){
			return false;
		}else{
			return true;
		}
		//return study.contains(c);
	}
	
	/**
	 * print the selected courses
	 * 
	 */
	void printCourses(){
		for (String print : study){
			System.out.println(print);
		}
	}
	
	/**
	 * print relevant information for the students
	 */
	void printInfo(){
		System.out.println("This is a student");
		System.out.println("Name: "+name);
		System.out.println("Gender: "+gender);
	}
}
