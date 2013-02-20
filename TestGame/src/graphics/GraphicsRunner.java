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
	private static int spd=5;
	private Map<String,Player> players = new TreeMap<String,Player>();

	public GraphicsRunner() {
		super("Graphics Runner");
		setSize(WIDTH, HEIGHT);
		players.put("10.26.6.11", new Player());
		getContentPane().add(new MovingPlayer(players));
		this.addKeyListener(new Event());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public GraphicsRunner(MovingPlayer pl) {
		setSize(WIDTH, HEIGHT);
		getContentPane().add(pl);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public class Event implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			keyTyped(arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			Player pl = players.get("10.26.6.11");;
			
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_UP: 	pl.moveY(-spd);	break;
			case KeyEvent.VK_DOWN: 	pl.moveY(spd);	break;
			case KeyEvent.VK_LEFT: 	pl.moveX(-spd);	break;
			case KeyEvent.VK_RIGHT:	pl.moveX(spd); 	break;
			}
		}
	}
	

	public static void main(String args[]) {
//		Map<String, Player> meh = new TreeMap<String, Player>();
//		meh.put("10.26.6.11", new Player());
		@SuppressWarnings("unused")
		GraphicsRunner run = new GraphicsRunner();
	}
}
