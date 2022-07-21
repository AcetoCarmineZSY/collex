package fr.uvsq.cprog.logidessin;
/**
 * Classe permettant de gérer un point
 */

public class APoint {
    //Coordonnées des points
    protected double x;
    protected double y;

    public APoint(double ax, double ay){
        x = ax;
        y = ay;
    }

    //pour calculer la distance euclidienne par rapport à un autre point
    public double distance( APoint otherPoint ) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
		String res ="";
        res="[x=" + x + ", y=" + y + "]";
        return res;  
    }
    
    //déplacement
    public void move(double dx, double dy) {
        x+=dx;
        y+=dy;
    }
}
