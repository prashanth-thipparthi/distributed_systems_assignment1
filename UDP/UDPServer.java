package distributed_systems_assignment1.UDP;

import java.net.*;
import java.time.Instant;

public class UDPServer extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[1024];
    private byte[] buf2 = new byte[1024];

    public UDPServer() {
        try {
            socket = new DatagramSocket(4445);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public void run() {
        running = true;
        Instant instant = null;
        long requestSent = 0;
        long requestReceived = 0;
        try {
            while (running) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                instant = Instant.now();
                requestReceived = instant.toEpochMilli();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();                
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("received: "+received);
                if (received.equals("end")) {
                    running = false;
                    continue;
                }
                instant = Instant.now();
                requestSent = instant.toEpochMilli();
                String serverTimes = requestReceived+":"+requestSent;
                System.out.println("server times:"+serverTimes);
                buf2 = serverTimes.getBytes();
                System.out.println("buf:"+buf2);
                packet = new DatagramPacket(buf2, buf2.length, address, port);
                socket.send(packet);                
            }
            socket.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        UDPServer udpServer = new UDPServer();
        udpServer.start();
    }
}