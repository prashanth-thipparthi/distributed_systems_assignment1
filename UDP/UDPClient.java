package distributed_systems_assignment1.UDP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address; 
    private byte[] buf;
    private byte[] buf2;
    static PrintWriter printWriter = null;
 
    public UDPClient() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
            printWriter = new PrintWriter(new FileWriter("./distributed_systems_assignment1/logger.txt",true));
            buf2 = new byte[1024];
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
 
    public String sendEcho(String msg) {
        Instant instant = null;
        long requestSent = 0;
        long requestReceive = 0;
        buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        String received = null;
        try {
            instant = Instant.now();
            requestSent = instant.toEpochMilli();
            socket.send(packet);
            packet = new DatagramPacket(buf2, buf2.length);
            socket.receive(packet);
            instant = Instant.now();
            requestReceive = instant.toEpochMilli();
            received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("recv:"+received);
            String[] values = received.split(":");
            //System.out.println("request sent:"+requestSent+"received:"+requestReceive);
            if(values.length < 2) {
                System.out.println(values.length);
                System.out.println("No response from server");
            }else {
                //printWriter.printf("\n Client side: Sent = %d , received = %d -- server side: received = %s, sent = %s",requestSent,requestReceive,values[0],values[1]);
                printWriter.printf("\n%d %d %s %s",requestSent,requestReceive,values[0],values[1]);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return received;        
    }
 
    public void close() {
        socket.close();
    }

    public static void main(String args[]) {
        UDPClient udpClient = new UDPClient();
        int count = 0;

        try {        
            while(count < 120) {
                String response = udpClient.sendEcho("Sai Ram");
                TimeUnit.SECONDS.sleep(60);
                count ++;
                System.out.println(response);
            } 
            printWriter.close();     
        }  catch(Exception e) {
            e.printStackTrace();
        }
    }
}
