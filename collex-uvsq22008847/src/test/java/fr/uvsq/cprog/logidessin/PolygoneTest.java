package fr.uvsq.cprog.logidessin;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolygoneTest {
    @Test
    public void testpoly() {
        APoint[] p1 = new APoint[4];
		p1[0] = new APoint(50, 200);
		p1[1] = new APoint(200, 200);
		p1[2] = new APoint(150, 300);
		p1[3] = new APoint(100, 300);
		Courbe poly1 = new Polygone(p1, "polygone");
        assertEquals("[x=125.0, y=241.66666666666666]", String.valueOf(poly1.barycentre()));
    }
}
