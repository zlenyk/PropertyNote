package gui;

import javax.swing.JFrame;


public abstract class Window extends JFrame{
	
	protected Window parent;
	final protected Window myself;

	public Window(){
		myself = this;
	}
	public void displayWindow(){
		if(parent != null)
			parent.setVisible(false);
		
		setVisible(true);
	}
	public void closeWindow(){
		if(parent != null)
			parent.setVisible(true);
		
		dispose();
	}
}
