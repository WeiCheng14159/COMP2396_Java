public class Person {
	private String name;
	
	public Person()
    {
        System.out.println("Person class no-args constructor called");
    }
	
    public Person(String name)
    {	
    	this.name = name;
        System.out.println("Person class Parameterized constructor called by " + name);
    }
    
    public void printInfo(){
    	System.out.println(name);
    }
}
