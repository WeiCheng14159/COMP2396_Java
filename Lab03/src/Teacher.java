public class Teacher extends Person {
	/**
	 * A string array recording the courses a teacher teaches
	 */
	String [] teach;
	
	/**
	 * A constructor for teacher
	 * @param s1 Teacher's name
	 * @param s2 Teacher's gender
	 * @param s3 Teacher's id
	 */
	Teacher (String s1, String s2, String s3){
		this.name = s1;
		this.gender = s2;
		this.id = s3;
	}
	
	/**
	 * setter function recording teacher's teaching courses
	 * @param c A string array storing what does a teacher teach
	 */
	void setCourses(String[] c){
		this.teach = c;
	}
	
	/** 
	 * print out the information of a teacher
	 */
	void printInfo(){
		System.out.println("This is a teacher");
		System.out.print("Name: "+this.name+"\nGender: "+this.gender+"\nTeach: ");
		for(int i = 0 ; i < this.teach.length ; i++){
			System.out.print(this.teach[i]+" ");
		}
	}
}
