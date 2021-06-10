package Arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gamePlay2 extends gamePlay{

	public gamePlay2() {
		
		super();
		myBall.setVx(6);
		myBall.setVy(6);
		
	}
	
	@Override
	public void drawatStart() {
		int i=0;
		int j=0;
		int n=0;
	
		t.start();
		myBackgroundIcon = new ImageIcon(getClass().getResource("sea1.png"));
		backgroundimage = myBackgroundIcon.getImage();
		brick = new ImageIcon(getClass().getResource("11329lw2.png"));
		paddle = new ImageIcon(getClass().getResource("ash.png"));
		ball = new ImageIcon(getClass().getResource("pokeball.png"));
		
		
		
		setLayout(null);
		lifeLabel = new JLabel("Life: "+lives);
		scoreLabel = new JLabel("Score: "+score);
		myPaddle = new paddle(paddle);
		myBall = new ball(ball);
		blocks = new bricks[row*column];
		JLabel levellabel = new JLabel("Level 2");
		
		for(i=0; i<column*row; i++)
		{
		blocks[i] = new bricks(brick);
		}
		
		n=0;
		i=0;
		j=0;
		lifeLabel.setBounds(100,400,600,500);
		lifeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		lifeLabel.setForeground(Color.RED);
		
		scoreLabel.setBounds(700, 400, 600, 500);
		scoreLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		scoreLabel.setForeground(Color.RED);
		
		
		levellabel.setBounds(400,400,600,500);
		levellabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		levellabel.setForeground(Color.RED);
		
		myBall.setBounds(myBall.getX(),myBall.getY(), ball.getIconWidth(),ball.getIconHeight());
		myPaddle.setBounds(myPaddle.getX(), myPaddle.getY(), paddle.getIconWidth(),paddle.getIconHeight());
		
		for(i=1; i<=row; i++) {
			for(j=1; j<=column; j++) {
				blocks[n].setBounds(j*120,i*40,brick.getIconWidth(),brick.getIconHeight());
				add(blocks[n]);
				n++;
				}		
		}
		add(myPaddle);
		add(myBall);
		add(lifeLabel);
		add(scoreLabel);
		add(levellabel);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		
		if(myBall.getX() < 0 || myBall.getX() > 900)
		{
			myBall.setVx(-myBall.getVx());
		}
		if(myBall.getY() < 0 || myBall.getY() > 910)
		{
			myBall.setVy(-myBall.getVy());
		}
		if(myBall.getY() > 900)
		{
			lives--;
			lifeLabel.setText("Life: "+lives);
			myBall.setX(395);
			myBall.setY(300);
			if(lives == 0)
			{	
				lives=3;
				t.stop();  
				JOptionPane.showMessageDialog(null, "GAME OVER :[");
				
				scorepopup = new JFrame("NICE SCORE :)");
				okbutton = new JButton("Ok");
				JPanel scorepanel = new JPanel();
				JLabel namelabel = new JLabel("Enter Your Name: ");
				JTextField name = new JTextField(20);
				scorepanel.add(namelabel);
				scorepanel.add(name);
				scorepanel.add(okbutton);
				scorepopup.add(scorepanel);
				
				scorepopup.setSize(500, 100);
				scorepopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				scorepopup.setLocationRelativeTo(null);
				scorepopup.setVisible(true);
				scorepopup.setResizable(false);
				
				ActionListener actionListenerpopupf = new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				    		try {
								File f0 = new File("scores.txt"); 
								f0.createNewFile();
								String Username = name.getText();
								Writer output1;
								
								String DEFAULT_PATTERN = "yyyy-MM-dd HH.mm.ss";
								DateFormat formatter = new SimpleDateFormat(DEFAULT_PATTERN);
								Date newdate = new Date();
								playerData data = new playerData(Username,score,formatter.format(newdate));
								
								output1 = new BufferedWriter(new FileWriter("scores.txt", true));
								output1.append(data.toString());
								output1.close();
						
								score=0;
								menuPanel.gameFrame.setVisible(false);
								scorepopup.setVisible(false);
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				};
				
				okbutton.setActionCommand("popup");
				okbutton.addActionListener(actionListenerpopupf);
			}
		}
		if(winCounter > 35)
		{
			t.stop();
			menuPanel.gameFrame.getContentPane().removeAll();
			JOptionPane.showMessageDialog(null,"LEVEL 2 CLEARED" );
			menuPanel.gameFrame.setVisible(false);
			
			menuPanel.gameFrame = new JFrame();
			gamePlay3 game = new gamePlay3();
			menuPanel.gameFrame.add(game);
			menuPanel.gameFrame.addKeyListener(game);
			menuPanel.gameFrame.setSize(950, 950);
			menuPanel.gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			menuPanel.gameFrame.setLocationRelativeTo(null);
			menuPanel.gameFrame.setVisible(true);
			menuPanel.gameFrame.setResizable(false);	
			
		}
		if(collisionChecker())
		{
			myBall.setVy(-myBall.getVy());
		}
		if(broken)
		{
			myBall.setVy(-myBall.getVy());
		}

		myBall.setX(myBall.getVx()+myBall.getX());
		myBall.setY(myBall.getVy()+myBall.getY());
		myBall.setBounds(myBall.getX(),myBall.getY(), ball.getIconWidth(),ball.getIconHeight());
	
	}
	
	@Override
	public boolean collisionChecker() {
		Rectangle b = myPaddle.getBounds();
		Rectangle a = myBall.getBounds();
		
		int l1x = b.x;
		int l1y = b.y;
		int r1x = b.x+paddle.getIconWidth();
		int r1y = b.y+paddle.getIconHeight();
		
		int l2x = a.x;
		int l2y = a.y;
		int r2x = a.x+ball.getIconWidth();
		int r2y = a.y+ball.getIconHeight();
		
		if(a.y > 600)
		{	
		if (l1x >= r2x || l2x >= r1x)
		{
			//System.out.println("NoCollusion");
			return false;
		}
		
		if (l1y >= r2y || l2y >= r1y)
		{
			//System.out.println("NoCollusion");
			return false;
		}
		return true;
		}
		
		else
		{
		for(int i=0; i<blocks.length; i++)
		{	
			Rectangle blockk = blocks[i].getBounds();
			int l3x = blockk.x;
			int l3y = blockk.y;
			
			int r3x = blockk.x+brick.getIconWidth();
			int r3y = blockk.y+brick.getIconHeight();
			
		if (l3x >= r2x || l2x >= r3x)
		{
			broken = false;
		}
			
		else if (l3y >= r2y || l2y >= r3y)
		{
			broken = false;
		}
		else {
		blocks[i].hitctCounter();
		myBall.setVy(-myBall.getVy());
		if(blocks[i].hitctGet() == 3)
		{
		blocks[i].setBounds(-1000, -1000, 0, 0);
		winCounter++;
		score+=2;
		}
		
		scoreLabel.setText("Score: "+score);
		
		
		}
		}
		return false;
	}
	}

	
	
}
