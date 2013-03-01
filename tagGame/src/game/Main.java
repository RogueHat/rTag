package game;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFrame;

import network.Network;

//import client.MovingPlayers;
//import client.GraphicsRunner.KeySniff;
//import elements.Player;

public class Main extends JFrame implements Runnable
{
	public static ArrayList<Player> players=new ArrayList<Player>();
	private Network net = new Network();
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	public static int w=0,s=0,a=0,d=0,m=0,space=0;
	private boolean hasMoved = false;
	private Player myPl;

	public Main()
	{
		super("Tag");
		setSize(WIDTH,HEIGHT);
		Color randColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		myPl = new Player((int)(Math.random()*WIDTH)+1,(int)(Math.random()*HEIGHT)+1, randColor);
		net.send(myPl.toString());
		//myPl = new Player();
		getContentPane().add(new DrawPlayer(net));
		this.addKeyListener(new Event());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//new Thread(this).start();
		
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
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_SPACE: space=0; break;
			case KeyEvent.VK_W:		w=0; m=0; hasMoved=false; break;
			case KeyEvent.VK_S: 	s=0; m=0; hasMoved=false; break;
			case KeyEvent.VK_A: 	a=0; m=0; hasMoved=false; break;
			case KeyEvent.VK_D:		d=0; m=0; hasMoved=false; break;
		}
		}
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			Player player= players.get(ThisPlayer.playerIndex);
			
			switch(arg0.getKeyCode()){
			case KeyEvent.VK_SPACE: space=1; break;
			case KeyEvent.VK_W:		w=1; m=1; hasMoved=true; break;
			case KeyEvent.VK_S: 	s=1; m=1; hasMoved=true; break;
			case KeyEvent.VK_A: 	a=1; m=1; hasMoved=true; break;
			case KeyEvent.VK_D:		d=1; m=1; hasMoved=true; break;
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
	
//	P=new Player(43,34,"person");
//	players.add(P);
	
	ThisPlayer you = new ThisPlayer(0,1);
	Main run = new Main();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(1);
				for(int x = 0; x<2 && hasMoved; x++)
					net.send(myPl.toString());
				hasMoved = false;
			}
		} catch (Exception e) {
		}
	}
}

