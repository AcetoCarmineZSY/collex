package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;
import java.net.*;

public class NomMachineTest {
    @Test
    public void TestNomMachine() throws UnknownHostException {
        InetAddress TestAddr = InetAddress.getByName("74.125.65.91");
        NomMachine nomMac = new NomMachine("91.65.125.74.bc.googleusercontent.com");
        assertEquals(TestAddr,nomMac.getFQDN());
        assertEquals("74.125.65.91",nomMac.getFQDN().getHostAddress());
        assertEquals("91.65.125.74.bc.googleusercontent.com",nomMac.getFQDNStr());
    }
}
