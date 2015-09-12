package obj;

import util.Listable;

public class Owner implements Listable{

	String name;

	public Owner(String _name){
		name = _name;
	}
	@Override
	public String getName() {
		return name;
	}
	
}
