package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public abstract class ChildWindow extends Window{
	
	protected GUIManager guiManager;
	protected JPanel contentPane;
	protected JButton closeButton;
	protected JPanel buttonPanel;
	
	public ChildWindow(GUIManager _guiManager,Window _parent) {
		super();
		guiManager = _guiManager;
		parent = _parent;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		buttonPanel = new JPanel();
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiManager.closeActiveWindow();
			}
		});
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(closeButton);
		contentPane.add(buttonPanel,BorderLayout.EAST);
		
	}
}
