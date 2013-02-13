package network;

import java.io.*;
import java.net.*;


public class Host {


    public static void main(String[] args) throws IOException {
    	PrintWriter out = null;
    	BufferedReader in = null;
    	BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));
		String userInput;

		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
		}
		in.close();
		out.close();
		stdIn.close();
    }
}