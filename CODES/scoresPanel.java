package Arkanoid;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class scoresPanel extends JPanel {
	
	JLabel l = new JLabel("HIGH SCORES");
	int counter=0;
	String createname="";
	int createscore=0;
	String createdate="";
	BufferedReader reader; 
	public JList<String> scoreList;
	
	
	public  scoresPanel() { 
		super();
	
  try {
	setLayout(null);
	reader = new BufferedReader(new FileReader("scores.txt"));
	ArrayList<playerData> arraylist = new ArrayList<playerData>();
 
  for(counter=0; counter<10; counter++)
	{
	  String line = reader.readLine();
	  if(line == null)
	  {
		  break;
	  }
	  StringTokenizer tokenizer = new StringTokenizer(line, ":");
	  counter = 0;
	  	while(counter<6)
	  	{	
		  	String a = tokenizer.nextToken();
		if(counter == 1)
	  	{
		  createname = a;
	  	}
	  	if(counter == 3)
	  	{
		  createscore = Integer.parseInt(a);
	  	}
	  	if(counter == 5)
	  	{
	  		createdate = a;
	  		playerData olddata = new playerData(createname,createscore,createdate);
	  		arraylist.add(olddata);
	  	}
	  	counter++;
	  }
	}
	Collections.sort(arraylist,new ScoreComparator());
	DefaultListModel<String> l2 = new DefaultListModel<>();
	playerData clk;
	Iterator<playerData> itr1 = arraylist.iterator();
	counter=0;
	while(itr1.hasNext()) 
	{
	clk = itr1.next();
	System.out.println(clk.printonList());
	l2.addElement(clk.printonList());
	}
	scoreList = new JList<>(l2);
  }
  catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
	  JOptionPane.showMessageDialog(null, "THIS IS THE FIRST TIME YOU OPEN THE GAME :)", "Scores", JOptionPane.ERROR_MESSAGE  );
	} catch (IOException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
}
  catch(NoSuchElementException e)
  {
	  JOptionPane.showMessageDialog(null, "NO SCORES TO SHOW!!", "Scores", JOptionPane.ERROR_MESSAGE  );
  }
 
  l.setBounds(210,0,100,100);
  l.setForeground(Color.red);
  setBackground(Color.black);
  scoreList.setBounds(70,100,350,180);
  add(l);
  add(scoreList);

}
}
