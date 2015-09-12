package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOwnerWindow extends AddWindow {
	
	/**
	 * Create the frame.
	 */
	public AddOwnerWindow(GUIManager _guiManager,Window _parent) {
		super(_guiManager,_parent);
		mainFrame.setTitle("Add owner");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.addOwner(name.getText());
			}
		});
	}
}
