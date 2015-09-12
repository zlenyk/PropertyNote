package gui;

import java.awt.EventQueue;
import java.util.List;

import app.ApplicationManager;

public class GUIManager {

	private ApplicationManager appManager;
	private Window activeWindow;
	
	//////////Singleton stuff///////////
	private static GUIManager instance = null;
	private GUIManager(ApplicationManager am){
		appManager = am;
	}
	
	public static GUIManager getGUIManager(ApplicationManager am){
		if(instance == null){
			instance = new GUIManager(am);
		}
		return instance;
	}
	///////////////////////////////////
		
	public void startGUI(){
		AppWindow appWindow = new AppWindow(this);
		activeWindow = appWindow;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					activeWindow.displayWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		activeWindow.closeWindow();
	}
	public void populateOwnerList(List<String> ownerList){
		((AppWindow)activeWindow).populateOwnerList(ownerList);
	}
	public void populatePropertyList(List<String> propertyList){
		((PropertyListWindow)activeWindow).populatePropertyList(propertyList);
	}
	public void displayWrongOwnerName(){
		AddOwnerWindow addOwnerWindow = new AddOwnerWindow(this,activeWindow);
		addOwnerWindow.setMessage("Wrong owner name");
		activeWindow = addOwnerWindow;
		activeWindow.displayWindow();
	}
	public void displayAddOwnerWindow(){
		activeWindow = new AddOwnerWindow(this,activeWindow);
		displayActiveWindow();
	}
	public void displayAddPropertyWindow(String ownerName){
		activeWindow = new AddPropertyWindow(this,activeWindow,ownerName);
		activeWindow.displayWindow();
	}
	
	public void displayPropertyWindow(String ownerName){
		activeWindow = new PropertyListWindow(this,activeWindow,ownerName);
		populatePropertyList(appManager.getOwnerPropertyList(ownerName));
		activeWindow.displayWindow();
	}
	
	public void closeActiveWindow(){
		Window newActive = activeWindow.parent;
		activeWindow.closeWindow();
		activeWindow = newActive;
	}
	public void displayActiveWindow(){
		activeWindow.displayWindow();
	}
	///////////methods up////////////////////
	
	protected void addOwner(String name){
		appManager.addOwner(name);
	}
	protected void deleteOwner(String name){
		appManager.deleteOwner(name);
	}
	protected void addProperty(String name,String ownerName){
		appManager.addProperty(name, ownerName);
	}
	protected void closeApplication(){
		appManager.close();
	}
}
