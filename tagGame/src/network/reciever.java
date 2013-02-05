package network;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class reciever {
	public static void main(String[] args) throws IOException {
		// create socket
		ServerSocket servsock = new ServerSocket(13267);
		while (true) {
			System.out.println("Waiting...");

			Socket sock = servsock.accept();
			System.out.println("Accepted connection : " + sock);

			// sendfile
			File myFile = new File("text.txt");
			byte[] mybytearray = new byte[(int) myFile.length()];
			FileInputStream fis = new FileInputStream(myFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			bis.read(mybytearray, 0, mybytearray.length);
			OutputStream os = sock.getOutputStream();
			System.out.println("Sending...");
			os.write(mybytearray, 0, mybytearray.length);
			os.flush();
			sock.close();
		}
	}

}
