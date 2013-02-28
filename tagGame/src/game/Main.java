package game;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFrame;

import client.MovingPlayers;
import client.GraphicsRunner.KeySniff;
import elements.Player;

public class Main extends JFrame
{
	public static ArrayList<Player> players=new ArrayList<Player>();
	private int event=0;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private boolean hasMoved = false;
	private Player myPl;

	public Main()
	{
		super("Tag");
		setSize(WIDTH,HEIGHT);
		Color randColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		myPl = new Player((int)(Math.random()*WIDTH)+1,(int)(Math.random()*HEIGHT)+1,randColor);
		net.send(myPl.toString());
		//myPl = new Player();
		getContentPane().add(new MovingPlayers(net));
		this.addKeyListener(new Event());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(this).start();
		
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
			Player player= players.get(ThisPlayer.playerIndex);
			
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_W:		player.moveUp(player.getSpeed()); break;
			case KeyEvent.VK_S: 	player.moveDown(player.getSpeed()); break;
			case KeyEvent.VK_A: 	player.moveLeft(player.getSpeed()); break;
			case KeyEvent.VK_D:		player.moveRight(player.getSpeed()); break;
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

