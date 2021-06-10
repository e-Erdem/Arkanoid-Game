package Arkanoid;

import javax.swing.Icon;
import javax.swing.JLabel;

public class paddle extends JLabel {
	
	private int paddleX = 395;
	private int paddleY = 810;
	
	public paddle(Icon name) {
		
		super(name);
		
	}
	
	public int getX() {
		
		return paddleX;
		
	}
	
	public int getY() {
		
		return paddleY;
	}
	
	public void setY(int Y)
	{
		paddleY = Y;
		
	}
	
	public void setX(int X)
	{
		paddleX = X;
	}
	

}
