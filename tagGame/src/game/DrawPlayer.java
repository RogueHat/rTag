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
import java.util.ArrayList;
//import lab01_make_a_shape.ShapePanel;

//import lab01_make_a_shape.GraphicsRunner;
//import lab01_make_a_shape.ShapePanel;

public class DrawPlayer extends JPanel{

	
	
	public DrawPlayer()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		
		ArrayList<Player> players= Main.getPlayers();
		
		for(int i=0; i<players.size();i++)
		{
			player.get(i);
		}
		
	}


}