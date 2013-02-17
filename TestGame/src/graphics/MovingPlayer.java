package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MovingPlayer extends JPanel implements Runnable{
	/**
	 * 
	 */
	private Map<String,Player> players = new TreeMap<String,Player>();
	
	public MovingPlayer(Map<String,Player> list) {
		setBackground(Color.WHITE);		
		setVisible(true);
		players=list;
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

	public void run() {
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
