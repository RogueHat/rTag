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
		window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		for(Player pl:players.values())
			pl.draw(window);
	}
	

	public void check(int i) {
		String line[];
		for (int x = 0; x < i; x++) {
			line = net.recieve(false).split(" ");
			if (line[0].contains("/")) {
				if (players.containsKey(line[0]))
					players.get(line[0]).set(line);
				else
					players.put(line[0], new Player(line));
			}
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				check(10);
				repaint();
			}
		} catch (Exception e) {
		}
	}

}
