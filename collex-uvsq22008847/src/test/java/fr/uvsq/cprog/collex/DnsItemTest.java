package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;
import java.net.*;

public class DnsItemTest {
    @Test
    public void TestDNSitem() throws UnknownHostException {
        InetAddress TestAddr = InetAddress.getByName("74.125.65.91");
        DnsItem DNSitem = new DnsItem("74.125.65.91");
        assertEquals(TestAddr, DNSitem.getDNSitem());

        //Test le constructeur avec AdresseIP puis le methode getAdresseIP()
        AdresseIP ip = new AdresseIP("74.125.65.91");
        DnsItem item2 = new DnsItem(ip); 
        assertEquals(ip, item2.getAdresseIP());

        //Test le constructeur avec NomMachine puis le methode getNomMachine()
        NomMachine nom = new NomMachine("91.65.125.74.bc.googleusercontent.com");
        DnsItem item3 = new DnsItem(nom);
        assertEquals(nom, item3.getNomMachine());
    }
}
