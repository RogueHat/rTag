package graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	private static int spd=0;
	private Map<String,Player> players = new TreeMap<String,Player>();

	public GraphicsRunner() {
		super("Graphics Runner");
		setSize(WIDTH, HEIGHT);
		players.put("10.26.6.11", new Player());
		getContentPane().add(new MovingPlayer(players));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public static void main(String args[]) {
		//Map<String, Player> meh = new TreeMap<String, Player>();
		//meh.put("10.26.6.11", new Player());
		@SuppressWarnings("unused")
		GraphicsRunner run = new GraphicsRunner();
	}
}
