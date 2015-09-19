package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		
		messageLabel = new JLabel("");
		messageLabel.setBounds(0, 0, 70, 15);
		contentPane.add(messageLabel);
		
		closeButton.setBounds(119, 50, 117, 25);
	}
	@Override
	protected void initialize(){

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		//addButton
		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 51, 103, 23);
		buttonPanel.add(btnAdd);
		
		//closeButton
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.closeActiveWindow();
			}
		});
		buttonPanel.add(closeButton);
		
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
	}
	public void setMessage(String message){
		messageLabel.setText(message);
	}
}
