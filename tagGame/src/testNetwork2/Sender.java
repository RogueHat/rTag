package testNetwork2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
	public static void main(String[] arg) throws Throwable {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress receiverAddress = InetAddress.getByName("128.250.234.114");
		Scanner scan = new Scanner(System.in);
		
		while(true){
			byte[] buffer = scan.next().getBytes();
	//		InetAddress receiverAddress = InetAddress.getLocalHost();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length,receiverAddress, 8080);
			datagramSocket.send(packet);
		}
	}
}
