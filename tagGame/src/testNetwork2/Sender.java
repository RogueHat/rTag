package testNetwork2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
	public static void main(String[] arg) throws Throwable {
		DatagramSocket datagramSocket = new DatagramSocket();
		Scanner scan = new Scanner(System.in);
		byte[] buffer = scan.next().getBytes();
		InetAddress receiverAddress = InetAddress.getByName("10.9.30.73");
//		InetAddress receiverAddress = InetAddress.getLocalHost();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length,receiverAddress, 80);
		datagramSocket.send(packet);
	}
}
