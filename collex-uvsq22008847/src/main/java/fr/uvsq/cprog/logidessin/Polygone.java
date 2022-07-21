package fr.uvsq.cprog.logidessin;

/**
 * Classe Polygone pour gérer un polygone quelconque
 * 	calcul du périmètre
 * 	calcul de l'aire
 * 	calcul du centre
 * 	méthode toString
 * 
 */

public class Polygone extends Courbe {
    //le tableau de points décrivant chaque sommet
    protected APoint[] points;
	public String nom;

    public Polygone(APoint[] p, String n){
		points = new APoint[p.length];
		for(int i=0; i<p.length; i++)
			points[i] = new APoint(p[i].x,p[i].y);
		nom = n;
	}

    //Pour calculer le périmètre d'un polygone
    public double longueur(){
		double resultat=0;
		for(int i=1; i<points.length; i++){
			resultat += points[i-1].distance(points[i]);
		}
		// ajout de la distance entre dernier et premier point
		resultat += points[points.length-1].distance(points[0]);
		return resultat;
	}

    public double aire(){
		double a=0;
		int i;
		for(i=0; i<points.length-1; i++)
			a += points[i].x*points[i+1].y - points[i+1].x*points[i].y;
		// "i" a la valeur points.length-1 maintenant
		a += points[i].x*points[0].y - points[0].x*points[i].y;
		return Math.abs(0.5*a);
	}

    public APoint barycentre(){
		APoint resultat = new APoint(0,0);
		int i;
		for(i=0; i<points.length-1; i++){
			resultat.x += (points[i].x+points[i+1].x) * (points[i].x*points[i+1].y - points[i+1].x*points[i].y);
			resultat.y += (points[i].y+points[i+1].y) * (points[i].x*points[i+1].y - points[i+1].x*points[i].y);
		}
		// "i" a la valeur points.length-1 maintenant
		resultat.x += (points[i].x+points[0].x) * (points[i].x*points[0].y - points[0].x*points[i].y);
		resultat.y += (points[i].y+points[0].y) * (points[i].x*points[0].y - points[0].x*points[i].y);
		double a = aire();
		resultat.x /= 6*a;
		resultat.y /= 6*a;
		return resultat;
    }

    public String toString(){
		String res;
		res = "Polygone " + nom+" avec "+ points.length+ " sommets :";
		for(int i=0; i<points.length; i++)
			res += " (" + points[i].x + "," + points[i].y + ")";
		res+=". ";
		res+=super.toString();
		return res;
	}

	public void move(double dx, double dy) {
		for (APoint p: this.points) p.move(dx, dy);
	}

	public String getNom() {
		return this.nom;
	}

}
