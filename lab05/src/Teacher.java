import java.util.ArrayList;
public class Teacher extends Person {
	ArrayList<String> teach;
	
	Teacher(String id, String name, String gender)
	{
		this.id=id;
		this.name=name;
		this.gender=gender;
	}
	
	void setCourses(ArrayList<String> c){
		teach=c;
	}
	
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
