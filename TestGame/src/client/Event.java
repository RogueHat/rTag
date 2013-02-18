package client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import network.Network;

public class Event implements KeyListener{
	private Network net = new Network();
	private int spd = 5;
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_UP: 	net.send("0 "+(-spd));	break;
		case KeyEvent.VK_DOWN: 	net.send("0 "+(spd));	break;
		case KeyEvent.VK_LEFT: 	net.send((-spd)+"0 ");	break;
		case KeyEvent.VK_RIGHT:	net.send((spd)+"0 ");	break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
