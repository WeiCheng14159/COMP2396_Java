
/**
 * Student class, inherited from Person
 * @author cfchen
 *
 */
public class Student extends Person {

	/**
	 * course of the student
	 */
	String[] study;
	/**
	 * course number of the student
	 */
	int courseNum;
	/**
	 * grades and credits of each course
	 */
	float[][] grades;
	/**
	 * gpa of the student
	 */
	float gpa;
	
	/**
	 * constructor of student, initialize information
	 * @param n	name
	 * @param g	gender
	 * @param i	id number
	 */
	Student(String n, String g, String i){
		name = n;
		gender = g;
		id  = i;
	}
	
	/**
	 * set the courses of student
	 * @param c	courses
	 */
	void setCourses(String[] c){
		study = c;
		courseNum=c.length;
	}
	
	/**
	 * set grades of student
	 * @param g grades and credits
	 */
	void setGrades(float[][] g){
		grades = g;
	}
	
	/**
	 * calculate gpa of student
	 */
	void calculateGpa(){
		float totalCre=0;
		float totalGra=0;
		for(int i=0;i<courseNum;i++){
			totalGra += grades[i][0]*grades[i][1];
			totalCre += grades[i][0];
		}
		gpa = totalGra/totalCre;
	}
	/**
	 * print out the information of student
	 */
	void printInfo(){
		System.out.println("This is a student");
		System.out.println("Name: "+name);
		System.out.println("Gender: "+gender);
		System.out.println("Course\tCredits\tGrades");
		for(int i=0;i<courseNum;i++){
			System.out.println(study[i]+"\t"+grades[i][0]+"\t"+grades[i][1]);
		}
		System.out.println("Total Courses: "+courseNum);
		System.out.println("The GPA is: "+gpa);
	}
}

