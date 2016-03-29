package lab06;

import java.util.*;

/**
 * Define a Postgraduate student class
 * @author chengwei
 *
 */
public class Postgraduate extends Student {
	
	private ArrayList<String> research;
	
	/**
	 * public constructor for a undergraduate student class 
	 */
	public Postgraduate(){
		
	};
	
	/**
	 * public constructor for a Postgraduate student class
	 * @param id id of a Postgraduate student
	 * @param name name of a Postgraduate student
	 * @param gender gender of a Postgraduate student
	 */
	public Postgraduate(String id, String name, String gender){
		this.setId(id);
		this.setName(name);
		this.setGender(gender);
		research = new ArrayList<String>();
		study = new ArrayList<String>();
	}
	
	/**
	 * public function allows a postgraduate student to add a research area
	 * @param addR the area to be added
	 */
	public void addResearch(String addR){
		if( ! this.research.contains(addR)){
			this.research.add(addR);
		}else{
			System.out.println("err");
		}
	}
	
	/**
	 * public function allows a postgraduate student to drop a research area
	 * @param dropR the area to be dropped
	 */
	public void dropResearch(String dropR){
		if(this.research.contains(dropR)){
			this.research.remove(dropR);
		}else{
			System.out.println("err");
		}
	}
	
	/**
	 * print the info of a postgraduate student
	 */
	public void printInfo(){
		System.out.println("This is a postgraduate student");
		System.out.println("Name: "+this.getName());
		System.out.println("Gender: "+this.getGender());
		System.out.print("Study: ");
		for( int i = 0 ; i < study.size() ; i++){
			System.out.print(study.get(i)+" ");
		}
		System.out.println();
		System.out.print("Research: ");
		for( int i = 0 ; i < research.size() ; i++){
			System.out.print(research.get(i)+" ");
		}
		System.out.println();
	}
	
}
