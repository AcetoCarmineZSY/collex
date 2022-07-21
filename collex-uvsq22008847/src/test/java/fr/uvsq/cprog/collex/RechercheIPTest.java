package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.Test;

public class RechercheIPTest {
    @Test
    public void TestRechercheIP() throws UnknownHostException {
        DNS d = new DNS();
        InetAddress addr = InetAddress.getByName("129.79.1.20");
        assertEquals(addr.getCanonicalHostName(),d.IPtoFQDN("129.79.1.20"));
    }
}
