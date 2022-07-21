package fr.uvsq.cprog.logidessin;
/**
 * Classe courbe 
 * Permettant de gérer différentes courbes
 * Classe mère de Polygone et Cercle
 */
public abstract class Courbe implements java.io.Serializable{
    public String nom;

    public String toString(){
        String ret = "Ma longueur est "+longueur()+ " , mon aire est "+aire() +
        " et mon barycentre :"+ barycentre().toString()+"\n";
        //if(aire() == 0) ret+="Ce n'est pas un polygone. \n";
		return ret;
	}

    public abstract double longueur();

    public abstract double aire();

    public abstract APoint barycentre();

    public abstract void move(double dx, double dy);

    public String getNom() {
        return this.nom;
    }
    
}
