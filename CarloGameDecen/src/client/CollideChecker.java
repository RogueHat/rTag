package client;

import java.util.Map;

import elements.Player;

public class CollideChecker implements Runnable{
	private Map<String, Player> players;
	private Player myPl;
	int delay = 0;
	
	public CollideChecker(Map<String, Player> pls){
		players = pls;
		myPl = GraphicsRunner.myPl;
		new Thread(this).start();
	}
	public void checkCollide(){
		for(String IP:players.keySet()){
			if(!IP.equals(GraphicsRunner.myIp) && myPl.collidedWith(players.get(IP))){
				delay = 5000;
				myPl.changeItStatus();
				players.get(IP).changeItStatus();
			}
		}
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				checkCollide();
				Thread.currentThread().sleep(delay);
				delay = 0;
			}
		} catch (Exception e) {
		}
	}

}
