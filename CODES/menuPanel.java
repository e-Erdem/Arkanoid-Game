package Arkanoid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;




public class menuPanel extends JPanel {
	
	private ButtonGroup radioGroup;
	private JRadioButton SelectionLW1;
	private JRadioButton SelectionLW2;
	private JRadioButton SelectionLW3;
	private ImageIcon myBackgroundIcon;
	private Image backgroundimage;
	private JLabel txt = new JLabel("LEVEL SELECTION");
	private gamePlay game;
	protected static JFrame gameFrame;

	private JPanel innerMenu; 
	private String Level="L1";
	
	public menuPanel(){

		gameFrame = new JFrame("PokeBreaker");
		innerMenu = new JPanel();
		SelectionLW1 = new JRadioButton("LEVEL 1", true);
		SelectionLW2 = new JRadioButton("LEVEL 2", false);
		SelectionLW3 = new JRadioButton("LEVEL 3", false);
		radioGroup = new ButtonGroup();
		radioGroup.add(SelectionLW1);
		radioGroup.add(SelectionLW2);
		radioGroup.add(SelectionLW3);
	
		
		setLayout(null);		
		setPreferredSize(new Dimension(500,500));	
		Icon newg = new ImageIcon(getClass().getResource("newgame.png"));
		Icon option = new ImageIcon(getClass().getResource("option.png"));
		Icon score = new ImageIcon(getClass().getResource("star.png"));
		Icon help = new ImageIcon(getClass().getResource("help.png"));
		Icon about = new ImageIcon(getClass().getResource("info.png"));
		Icon exit = new ImageIcon(getClass().getResource("exit.png"));
		
		myBackgroundIcon = new ImageIcon(getClass().getResource("9.png"));
		backgroundimage = myBackgroundIcon.getImage();
		
		JButton newgameButton = new JButton("New Game",newg);
		JButton optionsButton = new JButton("Options",option);
		JButton ScoresButton = new JButton("Scores",score);
		JButton HelpButton = new JButton("Help",help);
		JButton AboutButton = new JButton("About",about);
		JButton ExitButton = new JButton("Exit",exit);
		

	
		newgameButton.setBackground(Color.orange);
		optionsButton.setBackground(Color.orange);
		ScoresButton.setBackground(Color.orange);
		HelpButton.setBackground(Color.orange);
		AboutButton.setBackground(Color.orange);
		ExitButton.setBackground(Color.orange);
		newgameButton.setBounds(100, 115, 200, 75);
		optionsButton.setBounds(100, 240, 200, 75);
		ScoresButton.setBounds(100, 365, 200, 75);
		HelpButton.setBounds(100, 490, 200, 75);
		AboutButton.setBounds(100, 615, 200, 75);
		ExitButton.setBounds(100, 740, 200, 75);
		
		add(newgameButton);
		add(optionsButton);
		add(ScoresButton);
		add(HelpButton);
		add(AboutButton);
		add(ExitButton); 
			
		
		ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  gameFrame.getContentPane().removeAll();
		    	    if(Level == "L1")
		    	    { 
		    	    	game = new gamePlay();
		    	    	gameFrame.add(game);
			    		gameFrame.addKeyListener(game);
			    		gameFrame.setSize(950, 950);
			    		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    		gameFrame.setLocationRelativeTo(null);
			    		gameFrame.setVisible(true);
			    		gameFrame.setResizable(false);	
		    	    }
		    	    else if(Level == "L2")
		    	    {
		    	    	game = new gamePlay2();
		    	    	gameFrame.add(game);
		    	    	gameFrame.addKeyListener(game);
		    	    	gameFrame.setSize(950, 950);
		    	    	gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	    	gameFrame.setLocationRelativeTo(null);
		    	    	gameFrame.setVisible(true);
		    	    	gameFrame.setResizable(false);	
		    	    }
		    	    
		    	    else if(Level == "L3")
		    	    {
		    	    	game = new gamePlay3();
		    	    	gameFrame.add(game);
		    	    	gameFrame.addKeyListener(game);
		    	    	gameFrame.setSize(950, 950);
		    	    	gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	    	gameFrame.setLocationRelativeTo(null);
		    	    	gameFrame.setVisible(true);
		    	    	gameFrame.setResizable(false);	
		    	    }
		    	  	
		     }
		 };
		    newgameButton.setActionCommand("Zero");
			newgameButton.addActionListener(actionListener);
			
			
			
			
		ActionListener actionListener1 = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	JFrame optionsF = new JFrame("Options");
		    	optionsF.getContentPane().removeAll();
				innerMenu.add(SelectionLW1);
				innerMenu.add(SelectionLW2);
				innerMenu.add(SelectionLW3);
				SelectionLW1.addItemListener( new itemlistener1("L1"));
				SelectionLW2.addItemListener( new itemlistener1("L2"));
				SelectionLW3.addItemListener( new itemlistener1("L3"));
				
				txt.setBounds(100,50,10,10);
				txt.setForeground(Color.white);
				innerMenu.add(txt);
				innerMenu.setBackground(Color.black);
	    		optionsF.setSize(300, 100);
	    		optionsF.add(innerMenu);
	    		optionsF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    		optionsF.setLocationRelativeTo(null);
	    		optionsF.setVisible(true);
	    		optionsF.setResizable(false);
				
		     }
		 };		 
		 
		    optionsButton.setActionCommand("One");
			optionsButton.addActionListener(actionListener1);
			
			ActionListener actionListener2 = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			    	  JFrame ScoreFrame = new JFrame("Scores");
			    	  scoresPanel s = new scoresPanel();
			    			  
			    	  ScoreFrame.add(s);
			    	  ScoreFrame.setSize(500, 500);

			    	  ScoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	  ScoreFrame.setLocationRelativeTo(null);
			    	  ScoreFrame.setVisible(true);
			    	  ScoreFrame.setResizable(false);
			      }
			};
			ScoresButton.setActionCommand("Two");
			ScoresButton.addActionListener(actionListener2);
			

			ActionListener actionListener3 = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			    	  JFrame helpF = new JFrame("Help");
			    	  helpPanel p = new helpPanel();
			    	  
			    	  
			    	  helpF.add(p);
			    	  helpF.setSize(500, 500);

			    	  helpF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	  helpF.setLocationRelativeTo(null);
			    	  helpF.setVisible(true);
			    	  helpF.setResizable(false);
			    	  	
			     }
			 };
			    HelpButton.setActionCommand("Three");
			    HelpButton.addActionListener(actionListener3);
			
			
			
			
			
			
			ActionListener actionListener4 = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			    	  JFrame aboutF = new JFrame("About");
			    	  aboutPanel p = new aboutPanel();
			    	  
			    	  
			    	  aboutF.add(p);
			    	  aboutF.setSize(300, 200);

			    	  aboutF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	  aboutF.setLocationRelativeTo(null);
			    	  aboutF.setVisible(true);
			    	  aboutF.setResizable(false);
			    	  	
			     }
			 };
			    AboutButton.setActionCommand("Four");
			    AboutButton.addActionListener(actionListener4);
			
			
			    
			    
			ActionListener actionListener5 = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			    	  
			    	  System.exit(0);
			     }
			 };
			    ExitButton.setActionCommand("Five");
			    ExitButton.addActionListener(actionListener5);	
			    
			    
			    
			    
				 gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			    		@Override
			    		 public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    			System.err.println("stop the game");
			    			gameFrame.getContentPane().removeAll();
			    	  	  }
			    	  });				 
	}
	
	
	
	
	  private class itemlistener1 implements ItemListener{
			 
			 private String s;
			 public itemlistener1(String newone)
				{
					s = newone;
					
				}
			 @Override
			 public void itemStateChanged(ItemEvent e)
			 {
				 Level = s;
				 
			 }
			 
		 }
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(backgroundimage, 0,0,null);
	}


}
