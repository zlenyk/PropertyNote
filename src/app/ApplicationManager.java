package app;

import gui.GUIManager;

import java.util.List;

import obj.OwnerManager;
import util.DatabaseManager;

public class ApplicationManager {
	GUIManager guiManager;
	OwnerManager ownerManager;
	DatabaseManager dbManager;
	
	public void start(){
		dbManager = DatabaseManager.getDatabaseManager();
		guiManager = GUIManager.getGUIManager(this);
		ownerManager = OwnerManager.getOwnerManager(dbManager);
		
		guiManager.startGUI();
		guiManager.populateOwnerList(ownerManager.getOwnerNames());
	}
	public void close(){
		guiManager.close();
		dbManager.close();
	}
	
	public DatabaseManager getDatabaseManager(){
		return dbManager;
	}
	
	public void addOwner(String name){
		guiManager.closeActiveWindow();
		if(ownerManager.addOwner(name)){
			guiManager.populateOwnerList(ownerManager.getOwnerNames());
		}else{
			guiManager.displayWrongOwnerName();
		}
	}
	public void deleteOwner(String name){
		ownerManager.deleteOwner(name);
		guiManager.populateOwnerList(ownerManager.getOwnerNames());
	}
	public void addProperty(String name,String ownerName){
		guiManager.closeActiveWindow();
		dbManager.addProperty(name, ownerName);
		guiManager.populatePropertyList(dbManager.getOwnerProperties(ownerName));
	}
	public void deleteProperty(String propertyName,String ownerName){
		dbManager.deleteProperty(ownerName, propertyName);
		guiManager.populatePropertyList(dbManager.getOwnerProperties(ownerName));
	}
	public List<String> getOwnerPropertyList(String ownerName){
		return dbManager.getOwnerProperties(ownerName);
	}
}
