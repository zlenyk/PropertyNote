package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class PropertyComponent extends JComponent{
	private String name;
	private String ownerName;
	private PropertyListWindow parent;
	private PropertyComponent myself;
	
	public PropertyComponent(String _name,String _ownerName,PropertyListWindow p) {
		
		parent = p;
		myself = this;
		
 		setBackground(Color.BLUE);
		setBorder(new LineBorder(new Color(0, 0, 0),5));
		
		this.name = _name;
		this.ownerName = _ownerName;
		
		JLabel ownerNameLbl = new JLabel(ownerName);
		ownerNameLbl.setBounds(12, 12, 130, 15);
		add(ownerNameLbl);
		
		JLabel nameLbl = new JLabel(name);
		nameLbl.setBounds(12, 43, 110, 15);
		add(nameLbl);
		
		setBorder(new LineBorder(new Color(0, 0, 0),5));
		
		this.addMouseListener(new MouseAdapterMod());

	}
	public String getName(){
		return name;
	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(100,100);
	}
	public class MouseAdapterMod extends MouseAdapter {
		   public void mousePressed(MouseEvent e) {
			   parent.setClickedProperty(myself);
		   }
		}
}
