package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import conf.Configuration;

public class AppWindow extends Window{

	private GUIManager guiManager;
	private JList<String> ownerList;
	private DefaultListModel<String> dlm;
	
	private JButton btnDeleteOwner;
	private JButton btnClose;
	private JButton btnShow;

	/**
	 * Create the application.
	 */
	public AppWindow(GUIManager _guiManager) {
		super();
		this.guiManager = _guiManager;
		parent = null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle(Configuration.getAppName());
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		dlm = new DefaultListModel<String>();
		ownerList = new JList<String>(dlm);
		ownerList.getSelectionModel().addListSelectionListener(new SelectionListener());
		ownerList.setBounds(12, 35, 127, 192);
		getContentPane().add(ownerList);
		
		JLabel ownerListLabel = new JLabel("Owners");
		ownerListLabel.setBounds(12, 12, 70, 15);
		getContentPane().add(ownerListLabel);
		
		JButton btnAddOwner = new JButton("Add Owner");
		btnAddOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.displayAddOwnerWindow();
			}
		});
		btnAddOwner.setBounds(151, 31, 117, 25);
		getContentPane().add(btnAddOwner);
		
		btnDeleteOwner = new JButton("Delete Owner");
		btnDeleteOwner.setEnabled(false);
		btnDeleteOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.deleteOwner(ownerList.getSelectedValue());
			}
		});
		btnDeleteOwner.setBounds(151, 63, 117, 25);
		getContentPane().add(btnDeleteOwner);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.closeApplication();
			}
		});
		btnClose.setBounds(301, 215, 117, 25);
		getContentPane().add(btnClose);
		
		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ownerName = ownerList.getSelectedValue();
				guiManager.displayPropertyWindow(ownerName);
			}
		});
		btnShow.setEnabled(false);
		btnShow.setBounds(151, 97, 117, 25);
		getContentPane().add(btnShow);
	}

	public void populateOwnerList(List<String> owners){
		dlm.clear();
		if(owners.size() > 0){
			for(String name : owners){
				dlm.addElement(name);
			}
			ownerList.repaint();
		}
	}
	
	private class SelectionListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			if(ownerList.getSelectedValue() != null)
				btnDeleteOwner.setEnabled(true);
				btnShow.setEnabled(true);
		}
	}
}
