package Arkanoid;

import javax.swing.Icon;
import javax.swing.JLabel;

public class bricks extends JLabel {
	
	private int hitcounter;
	
	
	public bricks(Icon icon){
		
		super(icon);
	}	
	
	
	
	
	public void hitctCounter()
	{
		hitcounter++;
	}
	public void hitctSet(int a)
	{
		hitcounter = a;
	}
	public int hitctGet()
	{
		return hitcounter;
	}

}
