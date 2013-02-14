package testNetwork2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
	public static void main (String[]arg) throws Throwable{
		DatagramSocket datagramSocket = new DatagramSocket();

		byte[] buffer = "0123456789".getBytes();
		InetAddress receiverAddress = InetAddress.getLocalHost();

		DatagramPacket packet = new DatagramPacket(
		        buffer, buffer.length, receiverAddress, 80);
		datagramSocket.send(packet);
	}
}
