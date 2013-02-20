package game;


import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
//import lab01_make_a_shape.ShapePanel;

//import lab01_make_a_shape.GraphicsRunner;
//import lab01_make_a_shape.ShapePanel;

public class DrawPlayer extends JPanel implements Runnable{

	
	
	public DrawPlayer()
	{
		setBackground(Color.WHITE);
		setVisible(true);
		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		
		ArrayList<Player> players= Main.players;
		for(int i=0; i<players.size();i++)
		{
			players.get(i).draw(window);
		}
		
	}
	
	public void run()
	{
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(10);
				repaint();
			}
		} catch (Exception e) {
		}

	}

}