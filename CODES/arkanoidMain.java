package Arkanoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class arkanoidMain {
	public static void main(String[] args) {
		
	JFrame frame = new JFrame("PokeBreaker"); 	
	menuPanel p = new menuPanel();
	
	
	frame.add(p);
	frame.setSize(950, 950);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setResizable(false);
	try {
		File file = new File("pokemonmusic.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	catch(Exception e) {
		
	}
	}
	
	public static void music() {
		
	
		
		
	}

}
