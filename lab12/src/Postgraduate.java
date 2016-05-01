public class Postgraduate extends Student{
	public Postgraduate(){
		super("Default Postgraduate");
		System.out.println("Postgraduate class no-args constructor called");
	}
	
	public Postgraduate(String name)
    {	
		super(name);
    	System.out.println("Postgraduate class Parameterized constructor called by " + name);

    }
}
