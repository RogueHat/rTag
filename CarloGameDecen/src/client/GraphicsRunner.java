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
	
	private Network net = new Network();
	private boolean hasMoved = false;
	private int xSpd = 0, ySpd = 0;
	
	private Player myPl;

	public GraphicsRunner()
	{
		super("Carlo's Game");
		setSize(WIDTH,HEIGHT);
		Color randColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		myPl = new Player((int)(Math.random()*WIDTH)+1,(int)(Math.random()*HEIGHT)+1,randColor);
		net.send(myPl.toString());
		//myPl = new Player();
		getContentPane().add(new MovingPlayers(net));
		this.addKeyListener(new KeySniff());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(this).start();
	}

	public class KeySniff implements KeyListener{
		int spd = 0;
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
			}
			if(xSpd==0 && ySpd == 0)hasMoved = false;
		}
		@Override
		public void keyTyped(KeyEvent e) {
			spd = myPl.getSpd();
			int keyCode = e.getKeyCode();
			switch(keyCode){
			case KeyEvent.VK_UP:	ySpd = -spd;	break;
			case KeyEvent.VK_DOWN:	ySpd = spd;		break;
			case KeyEvent.VK_LEFT:	xSpd = -spd;	break;
			case KeyEvent.VK_RIGHT:	xSpd = spd;		break;
			}
			hasMoved = true;
		}
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
				Thread.currentThread().sleep(7);
				myPl.move(xSpd, ySpd);
				for(int x = 0; x<1 && hasMoved; x++)
					net.send(myPl.toString());
			}
		} catch (Exception e) {
		}
	}
}