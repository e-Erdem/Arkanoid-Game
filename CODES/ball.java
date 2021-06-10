package Arkanoid;

import javax.swing.Icon;
import javax.swing.JLabel;

public class ball extends JLabel {

	private int ballX = 395;
	private int ballY = 300;
	private int velX  = 4;
	private int velY  = 4;
	
	public ball(Icon icon) {
		
		super(icon);
		
	}
	
	public int getX() 
	{
		return ballX;	
	}
	public int getY() 
	{	
		return ballY;
	}
	public void setY(int Y)
	{
		ballY = Y;
	}
	public void setX(int X)
	{
		ballX = X;
	}
	
	public int getVx()
	{
		return velX;
	}
	public int getVy()
	{
		return velY;
	}
	public void setVy(int Vy)
	{
		velY = Vy;
	}
	public void setVx(int Vx)
	{
		velX = Vx;
	}
	
	
}
