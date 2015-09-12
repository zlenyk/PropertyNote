package util;

public class NameValidator {

	public static boolean validateOwnerName(String name){
		for(int i=0;i<name.length();i++){
			if(name.charAt(i) < 'A' || name.charAt(i) > 'z')
				return false;
		}
		return true;
	}
}
