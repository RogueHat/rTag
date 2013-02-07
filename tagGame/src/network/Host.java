package network;

import java.io.*;
import java.net.*;


public class Host {


    public static void main(String[] args) throws IOException {


        ServerSocket servsock = new ServerSocket(12345);
        Socket sock = servsock.accept();
            long time = System.currentTimeMillis();

        OutputStream out = sock.getOutputStream();
        //FileInputStream fileInputStream = new FileInputStream("C:\\complete.rar");

        byte [] buffer = "0123456789".getBytes(); 
    	out.write(buffer);
        
//        while ( (bytesRead = fileInputStream.read(buffer)) != -1)
//        {
//            if (bytesRead > 0)
//            {   
//                out.write(buffer, 0, bytesRead);
//                totalSent += bytesRead;
//                System.out.println("sent " + totalSent);
//            }   
//        }

        sock.close();

        //System.out.println("Sent " + totalSent + " bytes in "
        //        + (System.currentTimeMillis() - time) + "ms.");
        
        
        

    }
}