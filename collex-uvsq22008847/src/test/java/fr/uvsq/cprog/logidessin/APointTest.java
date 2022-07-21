package fr.uvsq.cprog.logidessin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class APointTest {
    @Test
    public void testpoint() {
        APoint a = new APoint(1, 1);
        APoint b = new APoint(1, 2);
        assertEquals("[x=1.0, y=1.0]",a.toString());
        assertEquals("1.0", String.valueOf(a.distance(b)));
    }
}
