package Arkanoid;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class aboutPanel extends JPanel{
	
	
	public JLabel name = new JLabel ("Efe Ömer Erdem"); 
	public JLabel IDN =  new JLabel ("20170701069");
	public JLabel email = new JLabel ("efeomer.erdem@std.yeditepe.edu.tr");
	public JLabel txt = new JLabel("Developer Team");
	
	public aboutPanel(){
		
		super();
		setLayout(null);
		txt.setBounds(100,0,100,50);
		name.setBounds(100,40,100,50);
		IDN.setBounds(110,60,100,50);
		email.setBounds(45,80,300,50);
		
		txt.setForeground(Color.RED);
		
		setBackground(Color.cyan);
		
		add(txt);
		add(IDN);
		add(email);
		add(name);
		
	}
	
	

	

}
