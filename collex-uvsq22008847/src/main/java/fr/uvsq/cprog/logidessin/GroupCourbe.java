package fr.uvsq.cprog.logidessin;

import java.util.ArrayList;

/**
 * Classe GroupCourbe
 * regroupement d’objets afin de leur faire subir un traitement global
 * ajoute/supprimer courbe dans le groupe
 * deplace toutes les courbes de groupe ensemble
 */

public class GroupCourbe {
    public ArrayList<Courbe> listCourbe;

    public GroupCourbe() {
        listCourbe = new ArrayList<>();
    }
    public GroupCourbe(ArrayList<Courbe> lstC) {
        for (Courbe c: lstC) listCourbe.add(c);
    }

    public void addCourbe(Courbe c) {
        listCourbe.add(c);
    }

    public void move(double dx, double dy) {
        for (Courbe c:listCourbe) c.move(dx, dy);
    }

    public void deleteCourbe(Courbe c) {
        listCourbe.remove(c);
    }

    public String toString() {
        String res =  "\n" + "Un ensemble de courbe, y compris les courbes suivants:" + "\n";
        for (Courbe c:listCourbe) res+=c.toString();
        return res+"Fin de groupe.\n"; 
    }

}
