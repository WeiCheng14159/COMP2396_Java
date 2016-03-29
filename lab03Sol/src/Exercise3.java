
/**
 * Test class
 * @author cfchen
 *
 */
public class Exercise3 {

	/**
	 * main method
	 * @param args not used in this program
	 */
	public static void main(String[] args) {
		// initial database
		int pnb=2;							//number of person
		Person[] plist= new Person[pnb];
		Student s1 = new Student("Jack", "male", "S1");			
		String[] study={"Java","C++"};
		s1.setCourses(study);
		float[][] grades = {{2.0f, 91.0f}, {3.0f, 89.0f}};
		s1.setGrades(grades);
		s1.calculateGpa();
		plist[0] = s1;
		
		Teacher t1 = new Teacher("Rose", "female", "T1");
		String[] teach={"medical", "math"};
		t1.setCourses(teach);
		plist[1] = t1;
		
		// query the person with the input argument-id
		String inID="S1";
		int i;
		for(i=0; i<pnb; i++){
			String ID=plist[i].getId();
			if(ID.equals(inID)){
				plist[i].printInfo();
				break;				// jump out of the loop if get the person
			}
		}
		// if can't find the input id 
		if(i>=pnb) System.out.println(inID+" not found");
	}
}
