package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Network {
	private InetAddress group;
	private MulticastSocket s;
	private int port;

	public Network() {
		port = 6789;
		try {
			group = InetAddress.getByName("228.5.6.7");
			s = new MulticastSocket(port);
			s.joinGroup(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Network(int prt) {
		port = prt;
		try {
			group = InetAddress.getByName("228.5.6.7");
			s = new MulticastSocket(port);
			s.joinGroup(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Network(String IP, int prt) {
		port = prt;
		try {
			group = InetAddress.getByName(IP);
			s = new MulticastSocket(port);
			s.joinGroup(group);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void send(String msg) {
		try {
			s.send(new DatagramPacket(msg.getBytes(), msg.length(), group, port));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String recieve(boolean withIP) {
		byte[] buffer = new byte[512];
		DatagramPacket recv = new DatagramPacket(buffer, buffer.length);
		try {
			s.receive(recv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String out = new String(recv.getData());
		if(withIP)  
			out = recv.getAddress().toString()+" "+out;
		return out.trim();
	}
	public static void main(String[]args){
		Network meh = new Network();
		while(true){
			System.out.println(meh.recieve(true));
		}
	}
}
