package game;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ThisPlayer implements Runnable {

	ArrayList<Player> players = Main.players;
	public static int playerIndex, itPlayerIndex, delay = 200;

	public ThisPlayer(int index, int itIndex) {
		playerIndex = index;
		itPlayerIndex = itIndex;
		new Thread(this).start();
	}

	public void taged() {
		delay--;
		if (delay <= 0)
		{
			players.get(itPlayerIndex).setSpeed(5);
			for (int i = 0; i < players.size(); i++) {
				if (i != itPlayerIndex)
				{
						//corners
						if(isTaged(0,10,0,10,i))break;
						if(isTaged(10,0,0,10,i))break;
						if(isTaged(0,10,10,0,i))break;
						if(isTaged(10,0,10,0,i))break;
						
						//sides
						if(isTaged(0,10,0,0,i))break;
						if(isTaged(10,0,0,0,i))break;
						if(isTaged(0,0,10,0,i))break;
						if(isTaged(0,0,0,10,i))break;
						
						//inside corners
						if(isTaged(0,5,0,5,i))break;
						if(isTaged(5,0,0,5,i))break;
						if(isTaged(0,5,5,0,i))break;
						if(isTaged(5,0,5,0,i))break;
						
						//inside
						if(isTaged(0,0,0,0,i))break;
						
						//inside sides
						if(isTaged(0,5,0,0,i))break;
						if(isTaged(5,0,0,0,i))break;
						if(isTaged(0,0,5,0,i))break;
						if(isTaged(0,0,0,5,i))break;
						
						//middle sides
						if(isTaged(5,10,0,10,i))break;
						if(isTaged(10,5,0,10,i))break;
						if(isTaged(5,10,10,0,i))break;
						if(isTaged(10,0,10,5,i))break;
						if(isTaged(0,10,5,10,i))break;
						if(isTaged(10,0,5,10,i))break;
						if(isTaged(0,10,10,5,i))break;
						if(isTaged(10,5,10,0,i))break;
						
				}
			}
		}
	}
	
	public boolean isTaged(int x1, int x2, int y1, int y2, int index)
	{
		if (players.get(index).getX()-x1 == players.get(itPlayerIndex).getX()-x2 && players.get(index).getY()-y1 == players.get(itPlayerIndex).getY()-y2)
		{
			tag(index, itPlayerIndex);
			return true;
		}		
		return false;
	}

	public void tag(int i, int x) {
		players.set(i, players.get(i).toItPlayer(players.get(i)));
		players.set(x, players.get(x).toPlayer(players.get(x)));
		itPlayerIndex = i;
		players.get(itPlayerIndex).setSpeed(0);
		delay = 200;
		//players = Main.players;
	}

	public void run() {
		try {
			while (true) {
				System.out.println(delay);
				Thread.currentThread();
				Thread.sleep(10);
				taged();
			}
		} catch (Exception e) {
		}
	}

}
