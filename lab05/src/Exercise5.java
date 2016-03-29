import java.util.ArrayList;

/**
 * Test class
 * 
 * @author sqluo
 *
 */
public class Exercise5 {

	/**
	 * main method
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		// initial database
		// change to ArrayList with respect to type Person
		ArrayList<Student> slist = new ArrayList<Student>(); 
		

		Student s1 = new Student("S1", "Jack", "male");
		s1.addCourse("JAVA");
		s1.addCourse("JAVA");// for testing illegal adding course
		s1.addCourse("C++");
		slist.add(s1);
		
		Student s2 = new Student("S2", "Tom", "male");
		s2.addCourse("JAVA");
		s2.addCourse("Python");
		s2.addCourse("C");
		s2.dropCourse("C");
		s2.dropCourse("C");// for testing illegal dropping course
		System.out.println("===================================");
		System.out.println("The course list of S2:");
		s2.printCourses();
		slist.add(s2);
		System.out.println("===================================");
		
		// query the students who have selected course specified by courseId
		String courseId = "JAVA";
		// please try to understand the following code, 
		// and also test courseId as "Python", "C++", and "C"
		ArrayList<Student> selectedStudents=new ArrayList<Student>();
		for(Student student: slist){
			if(student.isSeleted(courseId)){
				selectedStudents.add(student);
			}
		}
		if(selectedStudents.size()==0)
			System.out.println("No student selects "+courseId);
		else{
			System.out.println("The following students have selected "+courseId+":");
			for(Student student: selectedStudents)
			{
				System.out.println(student.getId()+"\t");
			}
		}
	}

}
