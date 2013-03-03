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
		//boolean newVals = false;
		String line[];
		for (int x = 0; x < i; x++) {
			line = net.recieve(true).split(" ");
			if (!line[1].contains("/")) {
				String in = "";
				for(int y=1; y<line.length;y++)
					in += line[y]+" ";
				playerStrings.put(line[0],in.trim());
				net.send(line[0]+" "+playerStrings.get(line[0]));
			}
		}
	}
	
//	public void update(){
//		for(String IP: playerStrings.keySet()){
//			String out = IP+" "+playerStrings.get(IP);
//			//System.out.println(out);
//			net.send(out);
//		}
//	}
	
	
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
				Thread.currentThread().sleep(0);
				check(1);
				//update();
			}
		} catch (Exception e) {
		}
	}

}
