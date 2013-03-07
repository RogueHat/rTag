package client;

import java.util.Map;

import elements.Player;

public class CollideChecker implements Runnable {
	private Map<String, Player> players;
	private Player myPl;
	int delay = 0;

	public CollideChecker() {
		players = MovingPlayers.players;
		myPl = GraphicsRunner.myPl;
		new Thread(this).start();
		if(!myPl.isIt() && players.size()<=1)myPl.changeItStatus();
	}

	public void checkCollide() {
		for (String IP : players.keySet()) {
			Player otherPl = players.get(IP);
			if (!IP.equals(GraphicsRunner.myIp)
					&& (myPl.collidedWith(otherPl) || otherPl.collidedWith(myPl))
					&& myPl.isIt() != otherPl.isIt()) {
				delay = 5000;
				myPl.changeItStatus();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.currentThread().sleep(0);
			while (true) {
				checkCollide();
				Thread.currentThread().sleep(delay);
				delay = 0;
			}
		} catch (Exception e) {
		}
	}

}
