package graphics;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	public GraphicsRunner(Map<String, Player> players) {
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH, HEIGHT);
		getContentPane().add(new MovingPlayer(players));

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Map<String, Player> meh = new TreeMap<String, Player>();
		meh.put("10.26.6.11", new Player());
		@SuppressWarnings("unused")
		GraphicsRunner run = new GraphicsRunner(meh);
	}
}
