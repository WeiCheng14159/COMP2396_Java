
/**
 * create a Student object that inherits a Person object
 * String study is a string that indicates what major a student study
 * @author wcheng
 *
 */
public class Student extends Person {
	
	String study;
	
	void initial(String id, String name, String gender, String study){
		this.id = id;
		this.Gender = gender;
		this.name = name;
		this.study = study;	
	}
	
	void printInfo(){
		System.out.println("This is a Student");
		System.out.println("Name: "+this.name);
		System.out.println("Gender: "+this.Gender);
		System.out.println("Study: "+this.study);
	}
}
