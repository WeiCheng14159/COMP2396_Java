public class Undergraduate extends Student{
	public Undergraduate(){
		super("Default U	ndergraduate");
		System.out.println("Undergraduate class no-args constructor called");
	}
	
	public Undergraduate(String name)
    {
		super(name);
		System.out.println("Undergraduate class Parameterized constructor called by " + name);
    }
}
