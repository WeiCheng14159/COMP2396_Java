package lab07;

public abstract class SimpleProtector implements ISecurity{
	
	public abstract String Encrypt(String input);
	
	public abstract String Decrypt(String input);
	
	public static String GetRandomString(int length){
		String numbers = "0123456789";
		String character = "abcdefghijklmnopqrstuvwxyz";
		String randString = numbers + character;
		String out="";
		for( int i = 0 ; i < length ; i++){
			int randIndex = (int)(Math.random()*35.0);
			out += randString.charAt(randIndex);
		}
		return out;
	}
}