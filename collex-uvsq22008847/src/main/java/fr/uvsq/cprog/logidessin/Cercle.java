package fr.uvsq.cprog.logidessin;
/**
 * Classe cercle pour définir un cercle
 * 	calcul du périmètre
 * 	calcul de l'aire
 * 	calcul du centre
 * 	méthode toString
 * 
 */

public class Cercle extends Courbe{
    private APoint centre;
	private double rayon;
	public String nom;

    public Cercle(APoint c, double r, String n){
		centre = new APoint(c.x,c.y);
		rayon = r;
		nom = n;
	}

    public double longueur(){
		return 2.0*Math.PI*rayon;
	}

    public double aire(){
		return Math.PI*rayon*rayon;
	}

    public APoint barycentre(){
		return centre;
	}

    public String toString(){
		String res;
		res=("Cercle "+ nom +" de centre ("+centre.x+","+centre.y+") et de rayon "+rayon+". \n");
		res+=super.toString();
		return res;
	}

	public void move(double dx, double dy) {
		this.centre.move(dx, dy);
	}

	public String getNom() {
		return this.nom;
	}
    
}
