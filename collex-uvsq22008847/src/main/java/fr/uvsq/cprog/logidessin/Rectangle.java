package fr.uvsq.cprog.logidessin;
/**
 * Rectangle is a polygone with points.length = 4
 */
public class Rectangle extends Polygone {
    private APoint[] points = new APoint[4];

    public Rectangle(APoint[] p, String nom) {
        super(p,nom);
        for(int i=0; i<p.length; i++)
			points[i] = new APoint(p[i].x,p[i].y);
    }
}
