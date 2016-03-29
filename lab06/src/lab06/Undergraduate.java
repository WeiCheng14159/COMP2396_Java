package lab06;

import java.util.ArrayList;

/**
 * Define a Undergraduate student class
 * @author chengwei
 *
 */
public class Undergraduate extends Student {
	
	/**
	 * public constructor for a undergraduate student class
	 * @param id id of a undergraduate student
	 * @param name name of a undergraduate student
	 * @param gender gender of a undergraduate student
	 */
	public Undergraduate(String id, String name, String gender){
		this.setGender(gender);
		this.setId(id);
		this.setName(name);
		study=new ArrayList<String>();
	}
	
	/**
	 * public constructor for a undergraduate student class 
	 */
	public Undergraduate(){
		
	}
	
	/**
	 * print the info of a undergraduate student
	 */
	public void printInfo(){
		System.out.println("This is a undergraduate student");
		System.out.println("Name: "+this.getName());
		System.out.println("Gender: "+this.getGender());
		System.out.print("Study: ");
		for( int i = 0 ; i < study.size() ; i++){
			System.out.print(study.get(i)+" ");
		}
		System.out.println();
	}
}
