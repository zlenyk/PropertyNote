package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPropertyWindow extends AddWindow{
	private String ownerName;
	/**
	 * Create the frame.
	 */
	public AddPropertyWindow(GUIManager _guiManager,Window _parent,String _ownerName) {
		super(_guiManager,_parent);
		ownerName = _ownerName;
		mainFrame.setTitle("Add property");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.addProperty(name.getText(),ownerName);
			}
		});
	}
}
