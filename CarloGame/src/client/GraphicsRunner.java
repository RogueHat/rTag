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
	
	Network net = new Network();
	
	private Player myPl;

	public GraphicsRunner()
	{
		super("Carlo's Game");
		setSize(WIDTH,HEIGHT);
		Color randColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
		myPl = new Player((int)(Math.random()*WIDTH)+1,(int)(Math.random()*HEIGHT)+1,randColor);
		//myPl = new Player();
		getContentPane().add(new MovingPlayers(net));
		this.addKeyListener(new KeySniff());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(this).start();
	}

	public class KeySniff implements KeyListener{
		@Override
		public void keyPressed(KeyEvent e) {
			int spd = myPl.getSpd();
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:	myPl.move(0, -spd);	break;
			case KeyEvent.VK_DOWN:	myPl.move(0, spd);	break;
			case KeyEvent.VK_LEFT:	myPl.move(-spd, 0);	break;
			case KeyEvent.VK_RIGHT:	myPl.move(spd, 0);	break;
			}
			//System.out.println(e.getKeyCode());
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
		
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
				Thread.currentThread().sleep(10);
				//System.out.println(myPl);
				net.send(myPl.toString());
			}
		} catch (Exception e) {
		}
	}
}