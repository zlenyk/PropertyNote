package gui;

import javax.swing.JFrame;


public abstract class Window {
	
	protected JFrame mainFrame;
	protected Window parent;
	protected Window myself;

	public Window(){
		mainFrame = new JFrame();
		myself = this;
	}
	public void displayWindow(){
		if(parent != null)
			parent.getFrame().setVisible(false);
		
		getFrame().setVisible(true);
	}
	public void closeWindow(){
		if(parent != null)
			parent.getFrame().setVisible(true);
		
		getFrame().dispose();
	}
	public JFrame getFrame(){
		return mainFrame;
	}
}
