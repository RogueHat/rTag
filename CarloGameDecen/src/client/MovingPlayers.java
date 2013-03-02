package client;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import elements.Player;

import network.Network;

@SuppressWarnings("serial")
public class MovingPlayers extends JPanel implements Runnable {
	private Network net;
	private Map<String, Player> players;
	private boolean hardMode = false;

	public MovingPlayers() {		
		net = new Network();
		players = new HashMap<String, Player>();

		setBackground(Color.WHITE);		
		setVisible(true);
		new Thread(this).start();
	}
	public MovingPlayers(Network n){
		this();
		net = n;
	}
	
	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		if(hardMode)
			window.setColor(new Color((float)Math.random(),(float)Math.random(),(float)Math.random()));
		else
			window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		for(Player pl:players.values())
			pl.draw(window);
	}
	

	public void check(int i) {
		String line[];
		for (int x = 0; x < i; x++) {
			line = net.recieve(true).split(" ");
			if (players.containsKey(line[0]))
				players.get(line[0]).set(line);
			else if (line[0].contains("/"))
				players.put(line[0], new Player(line));
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(0);
				check(1);
				repaint();
			}
		} catch (Exception e) {
		}
	}

}
