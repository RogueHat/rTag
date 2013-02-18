package client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import graphics.*;

@SuppressWarnings("serial")
public class ClientGraphics extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	
	
	public ClientGraphics() {
		setSize(WIDTH, HEIGHT);
		getContentPane().add(new ClientMvPlayer());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new Event());
	}
	public static void main(String[]args){
		ClientGraphics run= new ClientGraphics();
	}
}
