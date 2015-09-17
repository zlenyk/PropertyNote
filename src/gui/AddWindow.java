package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddWindow extends ChildWindow{
	
	protected JTextField name;
	protected JLabel messageLabel;
	protected JButton btnAdd;
	
	/**
	 * Create the frame.
	 */
	public AddWindow(GUIManager _guiManager,Window _parent) {
		super(_guiManager,_parent);
		
		setBounds(100, 100, 268, 124);
		
		name = new JTextField();
		name.setBounds(0, 21, 151, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 51, 103, 23);

		contentPane.add(btnAdd);
		
		messageLabel = new JLabel("");
		messageLabel.setBounds(0, 0, 70, 15);
		contentPane.add(messageLabel);
		
		closeButton.setBounds(119, 50, 117, 25);
	}
	public void setMessage(String message){
		messageLabel.setText(message);
	}
}
