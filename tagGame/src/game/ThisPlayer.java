package game;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ThisPlayer implements Runnable{
	
	ArrayList<Player> players = Main.players;
	public static int playerIndex, itPlayerIndex, delay=300;
	
	public ThisPlayer(int index, int itIndex)
	{
		playerIndex=index;
		itPlayerIndex=itIndex;
		new Thread(this).start();
	}
	
	public void taged()
	{
		delay--;
		if(delay<=0)
			for(int i=0; i<players.size();i++)
			{
				if(i!=itPlayerIndex)
					if(players.get(i).getX()==players.get(itPlayerIndex).getX() && players.get(i).getY()==players.get(itPlayerIndex).getY())
						{
							tag(i, itPlayerIndex);
							itPlayerIndex=i;
							break;
						}
							else if(players.get(i).getX()-10==players.get(itPlayerIndex).getX()) 
							{
								tag(i, itPlayerIndex);
								itPlayerIndex=i;
								break;
							}
								else if(players.get(i).getX()==players.get(itPlayerIndex).getX()-10)
								{
									tag(i, itPlayerIndex);
									itPlayerIndex=i;
									break;
								}
									else if(players.get(i).getX()-10==players.get(itPlayerIndex).getX()-10)
									{
										tag(i, itPlayerIndex);
										itPlayerIndex=i;
										break;
									}
			}
			
	}
	
	public void tag(int i, int x)
	{
		players.set(i, players.get(i).toItPlayer(players.get(i)));
		players.set(x, players.get(x).toPlayer(players.get(x)));
		delay=300;
		players = Main.players;
	}
	
	public void run()
	{
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
