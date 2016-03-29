public class Student extends Person {
	/**
	 * A string array recording the courses a student take
	 */
	String [] study;
	
	/**
	 * An integer recording how many courses a student takes 
	 */
	int courseNum;
	
	/**
	 * two-dimensional array that stores the credits and grades of a Student
	 * credits is stored in the first column, and grades stored in the second column
	 */
	float[][] grades;
	
	/**
	 * gpa equals to credit times grade divided by total credits
	 */
	float gpa ;
	
	/**
	 * constructor function for Students
	 * @param s1 Student's name
	 * @param s2 Student's gender
	 * @param s3 Student's id
	 */
	Student(String s1, String s2, String s3){
		this.name = s1;
		this.gender = s2;
		this.id = s3;
	}
	
	/**
	 * setter function storing Student's study
	 * @param c A string array storing what courses does a Student takes 
	 */
	void setCourses(String[] c){
		this.study = c;
		this.courseNum=c.length;
	}
	
	/**
	 * setter function storing Student's grades 
	 * @param g
	 */
	void setGrades(float [][] g){
		this.grades = g;
	}
	
	/**
	 * calculate GPA
	 */
	void calculateGpa(){
		float totalCredits = 0 ;
		for( int i = 0 ; i < this.grades.length ; i++){
			totalCredits = totalCredits + this.grades[i][0];
		}
		
		float totalGrade = 0;
		for( int i = 0 ; i < this.grades.length ; i++){
			totalGrade = totalGrade + this.grades[i][0]*this.grades[i][1];
		}
		this.gpa=totalGrade/totalCredits;
	}
	
	/**
	 * print out the information of student
	 */
	void printInfo(){
		System.out.println("This is a student");
		System.out.print("Name: "+this.name+"\nGender: "+this.gender+"\nCourses\tCredits\tGrades\n");
		for(int i = 0 ; i < this.study.length ; i++){
			System.out.print(this.study[i]+"\t"+this.grades[i][0]+"\t"+this.grades[i][1]+"\n");
		}
		System.out.println("Total Courses: "+this.courseNum);
		this.calculateGpa();
		System.out.println("The GPA is: "+gpa);
	}
}
