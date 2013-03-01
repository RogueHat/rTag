package game;

import game.Main.Event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ThisPlayer implements Runnable {

	ArrayList<Player> players = Main.players;
	public static int playerIndex, itPlayerIndex, delay = 200;
	private boolean broke;

	public ThisPlayer(int index, int itIndex) {
		playerIndex = index;
		itPlayerIndex = itIndex;
		new Thread(this).start();
	}

	public void taged() {
		delay--;
		if (delay <= 0)
		{
			if(playerIndex==itPlayerIndex && Main.space!=0 && Main.m!=0 ) ((ItPlayer)players.get(itPlayerIndex)).Boost();
			else players.get(itPlayerIndex).setSpeed(5);
			broke=false;
			for (int i = 0; i < players.size(); i++) {
				if (i != itPlayerIndex)
				{
					
					for(int x1=0; x1<=10;x1++)
					{
						for(int y2=0; y2<=10;y2++)
						{
							if(isTaged(x1,y2,x1,y2,i))break;
							if(isTaged(y2,x1,x1,y2,i))break;
							if(isTaged(x1,y2,y2,x1,i))break;
							if(isTaged(y2,x1,y2,x1,i))break;
							
							//sides
							if(isTaged(x1,y2,x1,x1,i))break;
							if(isTaged(y2,x1,x1,x1,i))break;
							if(isTaged(x1,x1,y2,x1,i))break;
							if(isTaged(x1,x1,x1,y2,i))break;
						}
						if(broke)break;
						
					}
					if(broke)break;
					
					if(isTaged(5,10,0,10,i))break;
					if(isTaged(10,5,0,10,i))break;
					if(isTaged(5,10,10,0,i))break;
					if(isTaged(10,0,10,5,i))break;
					if(isTaged(0,10,5,10,i))break;
					if(isTaged(10,0,5,10,i))break;
					if(isTaged(0,10,10,5,i))break;
					if(isTaged(10,5,10,0,i))break;
						
				}else if(Main.space!=0) ((ItPlayer)players.get(i)).addBoost();
			}
		}
	}
	
	public boolean isTaged(int x1, int x2, int y1, int y2, int index)
	{
		if (players.get(index).getX()-x1 == players.get(itPlayerIndex).getX()-x2 && players.get(index).getY()-y1 == players.get(itPlayerIndex).getY()-y2)
		{
			tag(index, itPlayerIndex);
			broke=true;
			return true;
		}		
		return false;
	}

	public void tag(int i, int x) {
		players.set(i, players.get(i).toItPlayer(players.get(i)));
		players.set(x, players.get(x).toPlayer(players.get(x)));
		itPlayerIndex = i;
		//players.get(i).setSpeed(0);
		((ItPlayer) players.get(i)).setBoost(100);
		delay = 200;
	}

	public void run() {
		try {
			while (true) {
				//System.out.println(delay);
				Thread.currentThread();
				Thread.sleep(10);
				taged();
			}
		} catch (Exception e) {
		}
	}

}


