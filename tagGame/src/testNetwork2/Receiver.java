package testNetwork2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		DatagramSocket datagramSocket = new DatagramSocket(8080);

		byte[] buffer = new byte[10];
		while(true){
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			datagramSocket.receive(packet);
			buffer = packet.getData();
			
			System.out.println(buffer);
		}
	}

}
