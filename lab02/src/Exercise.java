package tuto2exercise;

/**
 * Main method, which receives the command line parameter(ID of a person) 
 * and outputs the basics info of the person
 * @author wcheng
 *
 */
public class Exercise {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.initial("S1","Michael","M","CE");
		
		Student s2 = new Student();
		s2.initial("S2","Wei","M","EE");
		
		Student s3 = new Student();
		s3.initial("S3","Henry","F","elec");
		
		Teacher t1 = new Teacher ();
		t1.initial("T1","Emily","F","CS");
		
		Teacher t2 = new Teacher ();
		t2.initial("T2","Michael","M","CE");
		
		Teacher t3 = new Teacher ();
		t3.initial("T3","Michelle","F","Econ");
		
		if(args.length==1){ 
			
			switch(args[0]){
				case "S1": 
					s1.printInfo();
					break;
				case "S2": 
					s2.printInfo();
					break;
				case "S3": 
					s3.printInfo();
					break;
				case "T1": 
					t1.printInfo();
					break;
				case "T2":
					t2.printInfo();
					break;
				case "T3":
					t3.printInfo();
					break;
				default: System.out.println(args[0]+" not found");
			}
		}
		else System.out.println("please input ID");
	}

}
