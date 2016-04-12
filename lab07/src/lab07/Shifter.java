package lab07;

public class Shifter extends SimpleProtector {
	private int shift = 4;
	
	@Override
	public String Encrypt(String input) {
		int length = input.length();
		String out="";
		shift = shift % length;
		out += input.substring(length-shift-1, length);
		out += input.substring(0, length-shift-1);
		return out;
	}

	@Override
	public String Decrypt(String input) {
		int length = input.length();
		String out="";
		shift = shift % length;
		out += input.substring(length-shift-1, length);
		out += input.substring(0, length-shift-1);
		return out;
	}

}
