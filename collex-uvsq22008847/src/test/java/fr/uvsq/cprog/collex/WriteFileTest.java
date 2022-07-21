package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.Test;

public class WriteFileTest {
    @Test
    public void WriteTest() throws UnknownHostException {
        WriteFile w = new WriteFile();
        assertEquals("dns.google", w.getFQDNs()[9]);
    }
}
