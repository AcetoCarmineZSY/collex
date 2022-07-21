package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class DnsTUITest {
    @Test
    public void testTUI() throws IOException {
        String str = "dns9.quad9.net";
        DnsTUI d = new DnsTUI();
        assertEquals("9.9.9.9", d.nextCommande(str).execute(str));
    }
}
