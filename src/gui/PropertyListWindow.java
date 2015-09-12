package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PropertyListWindow extends ChildWindow {

	private String ownerName;
	private JList<String> propertyList;
	private DefaultListModel<String> dlm;
	private JButton btnDelete;
	/**
	 * Create the frame.
	 */
	public PropertyListWindow(GUIManager gui,Window parent,String _ownerName) {
		super(gui,parent);
		
		ownerName = _ownerName;
		mainFrame.setTitle("Show properties");
		
		JLabel ownerLabel = new JLabel("New label");
		ownerLabel.setBounds(12, 12, 70, 15);
		ownerLabel.setText(ownerName);
		mainFrame.getContentPane().add(ownerLabel);
		
		dlm = new DefaultListModel<String>();
		propertyList = new JList<String>(dlm);
		propertyList.getSelectionModel().addListSelectionListener(new SelectionListener());
		propertyList.setBounds(22, 39, 237, 202);
		mainFrame.getContentPane().add(propertyList);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(271, 35, 117, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.displayAddPropertyWindow(ownerName);
			}
		});
		mainFrame.getContentPane().add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(271, 72, 117, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.deleteProperty(propertyList.getSelectedValue(),ownerName);
			}
		});
		mainFrame.getContentPane().add(btnDelete);
	}
	public void populatePropertyList(List<String> owners){
		dlm.clear();
		if(owners.size() > 0){
			for(String name : owners){
				dlm.addElement(name);
			}
			propertyList.repaint();
		}
	}
	private class SelectionListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			if(propertyList.getSelectedValue() != null)
				btnDelete.setEnabled(true);
		}
	}
}
