package network;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("127.0.0.1", 15064);
        InputStream in = sock.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("output.rar");

        byte [] buffer = new byte[64*1024]; 
        int bytesRead = 0;

        while ( (bytesRead = in.read(buffer)) != -1)
            fileOutputStream.write(buffer, 0, bytesRead);
        sock.close();
        fileOutputStream.close();
    }
}
