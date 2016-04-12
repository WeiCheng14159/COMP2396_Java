package lab07;

public class CMap implements ISecurity {
	
	private String in_map = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()`~-_=+[{]}\\|;:'\",<.>/?";
	private String out_map = "84/oO,G^9ha{D&JC`?*1 FdbwL~cIgW!K:Sj0rpV7+XM<]AQZq-ynNmtzY$|HTUl\\6ei=_v(xRsE\"P'.@3;)}B%u2[fk#5>";
	
	public String Encrypt(String input){

		String outMsg="";
		
		for (int j = 0 ; j < input.length() ; j++){
			for(int i = 0 ; i < in_map.length();i++){
				if(in_map.charAt(i) == input.charAt(j)){
					outMsg += out_map.charAt(i);
					break;
				}
			}
		}
		
		return outMsg;
	}
	
	public String Decrypt(String input){

		String outMsg="";
		
		for (int j = 0 ; j < input.length() ; j++){
			for(int i = 0 ; i < out_map.length();i++){
				if(out_map.charAt(i) == input.charAt(j)){
					outMsg += in_map.charAt(i);
					break;
				}
			}
		}
		
		return outMsg;
	}
	
}
