package tuto2exercise;

/**
 *  create a Teacher object that inherits a Person object
 *  String teach is a string that indicates what subject a teacher teach
 * @author wcheng
 *
 */
public class Teacher extends Person {
	String teach;
	
	void initial(String id, String name, String gender, String teach){
		this.id = id;
		this.Gender =gender;
		this.name = name;
		this.teach= teach;	
	}
	
	void printInfo(){
		System.out.println("This is a Teacher");
		System.out.println("Name: "+this.name);
		System.out.println("Gender: "+this.Gender);
		System.out.println("Teach: "+this.teach);
	}
}
