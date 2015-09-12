package obj;

import util.Listable;

public class Property implements Listable{
	
	private String name;
	private Owner owner;
	private int id;
	
	public Property(String _name) {
		name = _name;
		owner = null;
	}

	@Override
	public String getName() {
		return name;
	}
	
	
}
