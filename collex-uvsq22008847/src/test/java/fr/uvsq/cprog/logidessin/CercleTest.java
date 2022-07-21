package fr.uvsq.cprog.logidessin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CercleTest {
    @Test
    public void testcercle() {
        APoint p = new APoint(1, 1);
        Cercle c = new Cercle(p, 2, "cercle");
        assertEquals("12.566370614359172", String.valueOf(c.aire()));
    }
}
