package game;


import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;

//import elements.Player;

//import elements.Player;

import network.Network;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Map;
//import lab01_make_a_shape.ShapePanel;
import java.util.HashMap;

//import lab01_make_a_shape.GraphicsRunner;
//import lab01_make_a_shape.ShapePanel;

public class DrawPlayer extends JPanel implements Runnable{
	private Network net;
	private Map<String, Player> playersMap;
	ArrayList<Player> players= Main.players;
	
	public DrawPlayer()
	{
		net=new Network();
		playersMap = new HashMap<String, Player>();
		
		setBackground(Color.WHITE);
		setVisible(true);
		new Thread(this).start();
	}
	
	public DrawPlayer(Network n)
	{
		this();
		net=n;
	}

	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		
		Player player= players.get(ThisPlayer.playerIndex);
		
		if(Main.w!=0)	player.moveUp(player.getSpeed());
		if(Main.s!=0)	player.moveDown(player.getSpeed());
		if(Main.a!=0)	player.moveLeft(player.getSpeed());
		if(Main.d!=0)	player.moveRight(player.getSpeed());
	
		for(int i=0; i<players.size();i++)
		{
			players.get(i).draw(window);
		}
		
	}
	
	public void check(int i) {
		String line[];
		for (int x = 0; x < i; x++) {
			line = net.recieve(true).split(" ");
			if (playersMap.containsKey(line[0]))
				playersMap.get(line[0]).set(line);
			else if (line[0].contains("/"))
			{
				playersMap.put(line[0], new Player(line));
				players.add(new Player(line));
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public void run()
	{
		try {
			while (true) {
				Thread.currentThread().sleep(10);
				//check(1);
				repaint();
			}
		} catch (Exception e) {
		}

	}

}