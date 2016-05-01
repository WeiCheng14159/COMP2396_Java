public class Student extends Person{
	public Student()
    {	
		System.out.println("Student class no-args constructor called");
        
    }
    public Student(String name)
    {
    	super(name);
    	System.out.println("Student class Parameterized constructor called by " + name);
    }
}
