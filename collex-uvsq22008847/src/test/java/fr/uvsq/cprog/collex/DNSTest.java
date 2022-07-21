package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;
import java.net.*;
import java.util.ArrayList;

public class DNSTest {
    @Test
    public void TestFQDNtoIP() throws UnknownHostException {
        DNS d = new DNS();
        InetAddress addr = InetAddress.getByName("129.79.1.20");
        assertEquals(addr.getCanonicalHostName(),d.IPtoFQDN("129.79.1.20"));
    }
    @Test
    public void TestIPtoFQDN() throws UnknownHostException {
        DNS d = new DNS();
        InetAddress addr = InetAddress.getByName("ns-test.indiana.edu");
        assertEquals(addr.getHostAddress(), d.FQDNtoIP("ns-test.indiana.edu"));
    }
    @Test
    public void TestgetFQDNs() {
        DNS d = new DNS();
        ArrayList<String> str = d.getFQDNsFromDomaine("vbap");
        assertEquals("remote.vbap.be , 81.82.253.90", str.get(0));
    }
    @Test
    public void TestGetIPs() {
        DNS d = new DNS();
        ArrayList<String> str = d.getIPsFromDomaine("vbap");
        assertEquals("81.82.253.90 , remote.vbap.be", str.get(0));
    }
}
