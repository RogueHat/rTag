package game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFrame;

public class Main extends JFrame
{
	public static ArrayList<Player> players=new ArrayList<Player>();
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Main()
	{
		super("Tag");

		setSize(WIDTH,HEIGHT);

		getContentPane().add(new DrawPlayer());
		this.addKeyListener(new Event());
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public class Event implements KeyListener{
		
		ArrayList<Player> players= Main.getPlayers();
		
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
			Player player= players.get(ThisPlayer.playerIndex);;
			
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_UP: 	player.moveY(-player.getSpeed());	break;
			case KeyEvent.VK_DOWN: 	player.moveY(player.getSpeed());	break;
			case KeyEvent.VK_LEFT: 	player.moveX(-player.getSpeed());	break;
			case KeyEvent.VK_RIGHT:	player.moveX(player.getSpeed()); 	break;
			}
		}
	}
	
	public static ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	public static void main(String args[])
	{
	Player P = new Player(23,34,"person");
	players.add(P);
	
	P = new ItPlayer(33,34,"person");
	players.add(P);
	
	//P=new Player(43,34,"person");
	//players.add(P);
	
	ThisPlayer you = new ThisPlayer(0,1);
	Main run = new Main();
	}
}

