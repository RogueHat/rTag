package testNetwork2.copy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Sender {
	public static void main(String[] arg) throws Throwable {

		Scanner scan = new Scanner(System.in);
		InetAddress group = InetAddress.getByName("228.5.6.7");
		MulticastSocket s = new MulticastSocket(6789);
		s.joinGroup(group);

		while (true) {
			String msg = scan.nextLine();
			DatagramPacket hi = new DatagramPacket(msg.getBytes(),
					msg.length(), group, 6789);
			s.send(hi);
		}
	}
}
