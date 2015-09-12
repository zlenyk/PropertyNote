package obj;

import java.util.List;

import util.DatabaseManager;
import util.NameValidator;

public class OwnerManager {
	
	private int idCounter;
	DatabaseManager dbManager;
	
	//////////Singleton stuff///////////
	private static OwnerManager instance = null;
	private OwnerManager(DatabaseManager _dbManager){
		dbManager = _dbManager;
		idCounter = 0;
	}

	public static OwnerManager getOwnerManager(DatabaseManager dbManager){
		if(instance == null)
			instance = new OwnerManager(dbManager);
		return instance;
	}
	///////////////////////////////////
	
	
	public int getCounter(){
		return idCounter++;
	}
	
	public List<String> getOwnerNames(){
		return dbManager.getOwnerList();
	}
	public boolean addOwner(String name){
		
		if(NameValidator.validateOwnerName(name)){
			if(dbManager.ownerExist(name))
				return false;
			dbManager.addOwner(name);
			return true;
		}else{
			return false;
		}
	}
	public void deleteOwner(String name){
		dbManager.deleteOwner(name);
	}

}
