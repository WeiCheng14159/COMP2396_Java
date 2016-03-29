
/**
 * Test class
 * @author cfchen
 *
 */
public class Exercise {

	/**
	 * main method
	 * @param args accept only one argument: person's id
	 */
	public static void main(String[] args) {
		// initial database
		int pnb=2;							//number of person
		Person[] plist= new Person[pnb];
		plist[0] = new Student();			//super class instance can reference a subclass instance
		(plist[0]).initial("S1", "Jack", "male", "computer science");
		plist[1] = new Teacher();
		(plist[1]).initial("T1", "Rose", "female", "medical");
		
		// query the person with the input argument-id
		// if the length of the command line argument is bigger than 2, release prompt message
		if(args.length==1){
			String inID=args[0];
			int i;
			for(i=0; i<pnb; i++){
				String ID=plist[i].getID();
				if(ID.equals(inID)){
					plist[i].printInfo();
					break;				// jump out of the loop if get the person
				}
			}
			// if can't find the input id 
			if(i>=pnb) System.out.println(inID+" not found");
		}
		else System.out.println("Please input just one argument...");
	}
}
