package testNetwork2.copy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver {

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		InetAddress group = InetAddress.getByName("228.5.6.7");
		MulticastSocket s = new MulticastSocket(6789);
		s.joinGroup(group);
		
		while (true) {
			byte[] buf = new byte[1000];
			DatagramPacket recv = new DatagramPacket(buf, buf.length);
			s.receive(recv);
			System.out.println(new String(recv.getData()));
		}
	}

}
