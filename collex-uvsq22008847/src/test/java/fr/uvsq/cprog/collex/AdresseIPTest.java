package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;
import java.net.*;

public class AdresseIPTest {
    @Test
    public void TestAdressIP() throws UnknownHostException {
        InetAddress TestAddr = InetAddress.getByName("74.125.65.91");
        AdresseIP ip = new AdresseIP("74.125.65.91");
        assertEquals(TestAddr, ip.getIp());
        assertEquals("74.125.65.91", ip.getIpStr());
    }

    @Test  //Test if the input string s is not a real IP
    public void TestWrongIP()  throws UnknownHostException{
        InetAddress TestAddr = InetAddress.getByName("74.15.65");
        AdresseIP ip = new AdresseIP("74.15.65");
        assertEquals(TestAddr, ip.getIp());
        //assertEquals("74.15.65", ip.getIpStr());
    }
    //automatically filled the "74.15.65" to "74.15.0.65"
            
}
