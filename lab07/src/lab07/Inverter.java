package lab07;

public class Inverter extends SimpleProtector {
	
	@Override
	public String Encrypt(String input) {
		// TODO Auto-generated method stub
		String out="";
		for( int i = input.length()-1 ; i >= 0 ; i--){
			out += input.charAt(i);
		}
		return out;
	}

	@Override
	public String Decrypt(String input) {
		// TODO Auto-generated method stub
		String out="";
		for( int i = input.length()-1 ; i >= 0 ; i--){
			out += input.charAt(i);
		}
		return out;
	}
}
