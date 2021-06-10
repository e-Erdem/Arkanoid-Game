package Arkanoid;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

public class gamePlay extends JPanel implements KeyListener, ActionListener{
		
		protected static File file = new File("scores.txt");
	
		protected int row = 6;
		protected int column = 6;
		protected int winCounter = 0;
		public static int lives=3;
		public static int score = 0;
		private int i = 0;
		private int j = 0;
		private int n = 0;
		
		protected boolean broken;
		
		public JFrame frame;
		public JFrame scorepopup;
		public JLabel lifeLabel;
		public JLabel scoreLabel;
		
		protected Icon paddle;
		protected Icon ball;
		protected Icon brick;
		
		
		protected paddle myPaddle;
		protected ball myBall;
		protected bricks[] blocks;
		
		public Timer t;
		
		protected ImageIcon myBackgroundIcon;
		protected Image backgroundimage;
		protected String LW = "L1";
		protected JButton okbutton;
		
		public gamePlay() {
			// TODO Auto-generated method stub
			t = new Timer(10,this);
			drawatStart();
			
		}
		
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
			myBall.setVy(-myBall.getVy());
			blocks[i].setBounds(-1000, -1000, 0, 0);
			winCounter++;
		
			
			score+=2;
			scoreLabel.setText("Score: "+score);
			}
			
			
			}
			}
			return false;
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
				System.err.println("LIFE: "+lives);
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
				JOptionPane.showMessageDialog(null,"LEVEL 1 CLEARED" );
				menuPanel.gameFrame.setVisible(false);
				
				menuPanel.gameFrame = new JFrame();
				gamePlay2 game = new gamePlay2();
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
				//velX = -velX;
			}

			myBall.setX(myBall.getVx()+myBall.getX());
			myBall.setY(myBall.getVy()+myBall.getY());
			myBall.setBounds(myBall.getX(),myBall.getY(), ball.getIconWidth(),ball.getIconHeight());
			//System.out.println("ballX: "+ballX + "ballY: "+ballY);
		
			}

		
		
		
		
		public void movePaddle(int newX, int newY)
		{
			if(myPaddle.getX() > 805)
			{
				myPaddle.setX(805);
				myPaddle.setBounds(myPaddle.getX(), newY, paddle.getIconWidth(), paddle.getIconHeight());
			}
			else if(myPaddle.getX() <= -1)
			{
				myPaddle.setX(-1);
				myPaddle.setBounds(myPaddle.getX(), newY, paddle.getIconWidth(), paddle.getIconHeight());
			}
			else {
			myPaddle.setBounds(newX, newY, paddle.getIconWidth(), paddle.getIconHeight());
			System.out.println(myPaddle.getX());
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			String whichKey = KeyEvent.getKeyText(e.getKeyCode());
			if(whichKey.compareTo("Left")==0)
			{
				changeLayoutLeft();
			}else if(whichKey.compareTo("Right")==0){
				changeLayoutRight();
			}

			else if (e.isControlDown() && e.getKeyChar() != 'q' && e.getKeyCode() == 81) {
				t.stop();
				JOptionPane.showMessageDialog(null, "GOOD BYE PLAYER");
				System.exit(0);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		

		private void changeLayoutLeft() {
			// TODO Auto-generated method stub
			myPaddle.setX(myPaddle.getX()-10);
			movePaddle(myPaddle.getX(),myPaddle.getY());
		}
		private void changeLayoutRight() {
			// TODO Auto-generated method stub
			myPaddle.setX(myPaddle.getX()+10);
			movePaddle(myPaddle.getX(),myPaddle.getY());
			
		}
		
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			g.drawImage(backgroundimage, 0,0,null);
			
		}

		public void drawatStart() {
			
			t.start();
			
			myBackgroundIcon = new ImageIcon(getClass().getResource("background6.jpg"));
			backgroundimage = myBackgroundIcon.getImage();
			brick = new ImageIcon(getClass().getResource("11329.png"));
			paddle = new ImageIcon(getClass().getResource("ash.png"));
			ball = new ImageIcon(getClass().getResource("pokeball.png"));
			
			
			
			setLayout(null);
			lifeLabel = new JLabel("Life: "+lives);
			scoreLabel = new JLabel("Score: "+score); 
			JLabel levellabel = new JLabel("Level 1");
			myPaddle = new paddle(paddle);
			myBall = new ball(ball);
			blocks = new bricks[row*column];
			
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


		
	}

