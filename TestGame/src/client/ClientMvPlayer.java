package client;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.TreeMap;

import network.Network;
import graphics.*;

@SuppressWarnings("serial")
public class ClientMvPlayer extends MovingPlayer{
	private Network net = new Network();
	private Map<String,Player> players = new TreeMap<String,Player>();
	
	public ClientMvPlayer() {
		setBackground(Color.WHITE);		
		setVisible(true);
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		for(Player pl:players.values())
			pl.draw(window);
	}
	public void check(){
		String line[] = net.recieve(false).split(" ");
		System.out.println(line);
		if(!line[1].contains("."))
			if(players.containsKey(line[0]))
				players.get(line[0]).setAll(line);
			else
				players.put(line[0], new Player(line));
		else
			check();
	}
}
