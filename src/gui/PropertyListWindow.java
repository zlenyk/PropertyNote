package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PropertyListWindow extends ChildWindow {

	private String ownerName;
	private JButton btnDelete;
	private JPanel propertiesPanel;
	private PropertyComponent clickedProperty;
	/**
	 * Create the frame.
	 */
	public PropertyListWindow(GUIManager gui,Window parent,String _ownerName) {
		super(gui,parent);
		
		ownerName = _ownerName;
		setTitle("Show properties");
		setBounds(100, 100, 600, 600);

		JLabel ownerLabel = new JLabel("New label");
		ownerLabel.setBounds(12, 12, 70, 15);
		ownerLabel.setText(ownerName);
		getContentPane().add(ownerLabel,BorderLayout.NORTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(271, 35, 117, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.displayAddPropertyWindow(ownerName);
			}
		});
		buttonPanel.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setBounds(271, 72, 117, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.deleteProperty(clickedProperty.getName(),ownerName);
			}
		});
		buttonPanel.add(btnDelete);
		
		propertiesPanel = new JPanel( new FlowLayout());
		propertiesPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		propertiesPanel.setBounds(12, 40, 310, 291);
		propertiesPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		getContentPane().add(propertiesPanel,BorderLayout.CENTER);
		
		validate();
	}
	public void setClickedProperty(PropertyComponent p){
		clickedProperty = p;
		btnDelete.setEnabled(true);
	}
	
	public void populatePropertyList(List<String> owners){
		propertiesPanel.removeAll();
		propertiesPanel.revalidate();
		propertiesPanel.repaint();
		if(owners.size() > 0){
			for(String name : owners){
				propertiesPanel.add(new PropertyComponent(name,ownerName,this));
			}
		}
		validate();
	}
}
