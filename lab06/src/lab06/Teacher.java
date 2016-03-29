package lab06;

import java.util.ArrayList;
/**
 * Define a teacher
 * @author chengwei
 *
 */
public class Teacher extends Person {
	
	private ArrayList<String> teach;
	private ArrayList<Student> student;
	
	/**
	 * public constructor for Teacher class
	 * @param id id of teacher
	 * @param name name of teacher
	 * @param gender gender of teacher
	 */
	public Teacher(String id, String name, String gender)
	{
		this.setId(id);
		this.setName(name);;
		this.setGender(gender);;
	 	teach = new ArrayList<String>();
	 	student = new ArrayList<Student>();
	}
	
	/**
	 * set the courses a teacher teaches
	 * @param c course list
	 */
	public void setCourses(ArrayList<String> c){
		teach=new ArrayList<String>();
		teach=c;
	}
	
	/**
	 * allow a teacher to drop a student
	 * @param toBeDrop a student to be drop
	 */
	public void dropStudent(Student toBeDrop){
		if(student.contains(toBeDrop)){
			student.remove(toBeDrop);
		}else{
			System.out.println("You haven't selected this student yet.");
		}
	}
	
	/**
	 * allow a teacher to add a student
	 * @param toBeAdd a student to add
	 */
	public void addStudent(Student toBeAdd){
		if( !student.contains(toBeAdd)){
			student.add(toBeAdd);
		}else{
			System.out.println("You added this student before.");
		}
	}
	
	/**
	 * print out the info of a student
	 */
	public void printInfo(){
		System.out.println("Here is the detail information of students.");
		for ( int i = 0 ; i < student.size();i++){
			student.get(i).printInfo();
		}
	}
}
