package lab06;
import java.util.ArrayList;

/**
 * Define a student
 * @author chengwei
 *
 */
public class Student extends Person {
	
	/**
	 * The courses a student study
	 */
	public ArrayList<String> study;
	
	/**
	 * public constructor
	 */
	public Student(){
		
	};
	
	/**
	 * Constructor for the Student class
	 * @param id student ID
	 * @param name student name
	 * @param gender student gender
	 */
	public Student(String id, String name, String gender)
	{
		this.setId(id);
		this.setName(name);
		this.setGender(gender);
		study=new ArrayList<String>();
	}
	
	/**
	 * add a course named addC
	 * @param addC the course to be added
	 */
	public void addCourse(String addC){
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
	public void dropCourse(String dropC){
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
	public Boolean isSeleted(String c){
		if(study.indexOf(c) == -1){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * print the selected courses
	 * 
	 */
	public void printCourses(){
		for (String print : study){
			System.out.println(print);
		}
	}
	
	/**
	 * print relevant information for the students
	 */
	public void printInfo(){
		System.out.println("This is a student");
		System.out.println("Name: "+this.getName());
		System.out.println("Gender: "+this.getGender());
	}
}
