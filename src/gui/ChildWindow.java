package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class ChildWindow extends Window{
	
	protected GUIManager guiManager;
	protected JPanel contentPane;
	protected JButton closeButton;
	
	public ChildWindow(GUIManager _guiManager,Window _parent) {
		super();
		guiManager = _guiManager;
		parent = _parent;
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.closeActiveWindow();
			}
		});
		closeButton.setBounds(313, 215, 117, 25);
		contentPane.add(closeButton);
	}
}
