package lab06;

/**
 * define a Person class
 * @author chengwei
 *
 */
public class Person {
	private String name;
	private String gender;
	private String id;

	/**
	 * public getter function for Person class
	 * @return id of a person in string
	 */
	public String getId() {
		return id;
	}

	/**
	 * public getter function for Person class
	 * @return name of a person in string
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * public getter function for Person class
	 * @return gender of a person in string
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * public constructor for Person class
	 * @param Id id of a person 
	 * @param Name name of a person 
	 * @param Gender gender of a person 
	 */
	public Person (String Id, String Name, String Gender){
		id=Id;
		name = Name;
		gender = Gender;
	}
	
	/**
	 * public constructor 
	 */
	public Person(){
		id="S1";
		gender="male";
		name="Michael";
	}
	
	/**
	 * public setter function for person class
	 * @param Id id of a person 
	 */
	public void setId(String Id){
		this.id=Id;
	}
	
	/**
	 * public setter function for person class
	 * @param Name name of a person 
	 */
	public void setName(String Name){
		this.name=Name;
	}
	
	/**
	 * public setter function for person class
	 * @param Gender gender of a person 
	 */
	public void setGender(String Gender){
		this.gender=Gender;
	}
}

