package server;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import elements.Player;

import network.Network;

public class Server implements Runnable{
	private Network net;
	private Map<String, String> playerStrings;
	private Scanner scan;
	
	public Server(){
		net = new Network();
		playerStrings = new HashMap<String, String>();
		new Thread(this).start();
	}
	
	public void check(int i) {
		boolean newVals = false;
		String line[];
		for (int x = 0; x < i; x++) {
			line = net.recieve(true).split(" ");
			if (!line[1].contains("/")) {
				playerStrings.put(line[0], line[1]+" "+line[2]+" "+line[3]);
				newVals = true;
			}
		}
		if(newVals)update();
	}
	
	public void update(){
		for(String IP: playerStrings.keySet()){
			String out = IP+" "+playerStrings.get(IP);
			//System.out.println(out);
			net.send(out);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server serv = new Server();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				Thread.currentThread().sleep(10);
				check(10);
				//update();
			}
		} catch (Exception e) {
		}
	}

}
