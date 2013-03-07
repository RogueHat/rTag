package client;
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;

import network.Network;

import elements.Player;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphicsRunner extends JFrame implements Runnable
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	public static Player myPl;
	public static String myIp;
	
	private Network net = new Network();
	private boolean hasMoved = false;
	private int xSpd = 0, ySpd = 0;
	

	public GraphicsRunner()
	{
		super("Carlo's Game");
		setSize(WIDTH,HEIGHT);
		Color randColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		myPl = new Player((int)(Math.random()*WIDTH)+1,(int)(Math.random()*HEIGHT)+1,randColor);
		net.send(myPl.toString());
		String loopBack[] = net.recieve(true).split(" ");
		String myString = "";
		for(int x=1;x<loopBack.length;x++)
			myString+=loopBack[x]+" ";
		if(myPl.toString().equals(myString.trim()))
			myIp=loopBack[0];
		net.send(myPl.toString());
		//myPl = new Player();
		getContentPane().add(new MovingPlayers(net));
		this.addKeyListener(new KeySniff());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(this).start();
	}

	public class KeySniff implements KeyListener{
		int spd = 0, boost = 1;
		@Override
		public void keyPressed(KeyEvent e) {
			keyTyped(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:	ySpd = 0;	break;
			case KeyEvent.VK_DOWN:	ySpd = 0;	break;
			case KeyEvent.VK_LEFT:	xSpd = 0;	break;
			case KeyEvent.VK_RIGHT:	xSpd = 0;	break;
			case KeyEvent.VK_SPACE:	boost = 1;	break;
			}
			if(xSpd == 0 && ySpd == 0)hasMoved = false;
		}
		@Override
		public void keyTyped(KeyEvent e) {
			spd = myPl.getSpd()*boost;
			int keyCode = e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_UP:	ySpd = -spd;	hasMoved = true;	break;
			case KeyEvent.VK_DOWN:	ySpd = spd;		hasMoved = true;	break;
			case KeyEvent.VK_LEFT:	xSpd = -spd;	hasMoved = true;	break;
			case KeyEvent.VK_RIGHT:	xSpd = spd;		hasMoved = true;	break;
			case KeyEvent.VK_SPACE: boost = 2;							break;
			}
		}
	}
	public void update(int n){
		for(int x = 0; x<n; x++)
			net.send(myPl.toString());
	}
	
	
	public static void main( String args[] )
	{
		GraphicsRunner run = new GraphicsRunner();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(8);
				myPl.move(xSpd, ySpd);
				if(hasMoved)update(1);
			}
		} catch (Exception e) {
		}
	}
}