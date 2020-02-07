/*
package distributed_systems_assignment1.UDP;

import java.net.*;
import org.junit.jupiter.api.*;

public class UDPTest {
    UDPClient client;
 
    @Before
    public void setup(){
        new UDPServer().start();
        client = new UDPClient();
    }
 
    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        assertFalse(echo.equals("hello server"));
    }
 
    @After
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}

*/