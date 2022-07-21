package fr.uvsq.cprog.logidessin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale pour gérer différents types de courbe
 * classe TUI
 */

public class GestionFigure {
    public static void main(String[] args){
        //all the curve the user has created
        ArrayList<Courbe> allCourbe = new ArrayList<Courbe>();
        ArrayList<GroupCourbe> allGroup = new ArrayList<>();

        System.out.println("Command list:");
        System.out.println("circle, polygone, regroupe, affiche, deplace, supprime, quit, sauvegarde, charge \n");

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()){
                String inp = sc.nextLine();
                System.out.println("");

                //end program
                if(inp.equals("quit")){
                    break;
                }
                
                //new cercle
                if(inp.equals("circle")){
                    System.out.println("centre (x,y) = ");
                    String x = sc.nextLine();
                    String y = sc.nextLine();
                    APoint centre = new APoint(Double.parseDouble(x),Double.parseDouble(y));
                    System.out.println("rayon = ");
                    String r = sc.nextLine();
                    System.out.println("nom de cette circle:");
                    String n = sc.nextLine();
                    Cercle c = new Cercle(centre, Double.parseDouble(r), n);
                    System.out.println("");
                    System.out.println("deja cree:");
                    System.out.println(c.toString());
                    allCourbe.add(c);
                }

                //new polygone
                if(inp.equals("polygone")){
                    System.out.println("nombre sommet:");
                    int nb = Integer.parseInt(sc.nextLine());
                    if(nb<3){
                        System.out.println("Not a polygone.");
                    }else{
                        APoint[] sommets = new APoint[nb];
                        for (int i = 0; i < nb ; i++){
                            System.out.println("sommet (x,y) = ");
                            Double x = Double.parseDouble(sc.nextLine());
                            Double y = Double.parseDouble(sc.nextLine());
                            sommets[i] = new APoint(x, y);
                        }
                        System.out.println("nom de ce polygone:");
                        String n = sc.nextLine();
                        Polygone p = new Polygone(sommets, n);
                        System.out.println("");
                        System.out.println("deja cree:");
                        System.out.println(p.toString());
                        allCourbe.add(p);
                    }
                }

                //print all
                if(inp.equals("affiche")){
                    System.out.println("Tous les courbes créés:");
                    for (Courbe c: allCourbe) System.out.println(c.getNom());
                    System.out.println("");

                    System.out.println("Tous les groupes créés:");
                    for (int i = 0; i< allGroup.size();i++){
                        System.out.print(i + ": ");
                        GroupCourbe grp = allGroup.get(i);
                        for (Courbe c: grp.listCourbe) System.out.print(c.getNom()+", ");
                        System.out.println("");
                    }
                    System.out.println("\n");
                }

                //regroupe
                if(inp.equals("regroupe")){
                    System.out.println("Tous les courbes créés:");
                    for (Courbe c: allCourbe) System.out.println(c.getNom());
                    System.out.println("");
                    System.out.println("Quels courebes sont regroupés ? Terminer par #");
                    GroupCourbe grp = new GroupCourbe();
                    for (int i = 0; i<allCourbe.size();i++){    
                        String nomGrp = sc.nextLine();
                        if(nomGrp.equals("#")){
                            break;
                        }else{
                            for (Courbe c: allCourbe){
                                if(c.getNom().equals(nomGrp)){
                                    grp.addCourbe(c);
                                }
                            }
                        }
                    }
                    System.out.println(grp.toString());
                    allGroup.add(grp);
                }

                //supprime
                if(inp.equals("supprime")){
                    System.out.println("Supprimer [courbe] ou [groupe]?");
                    String str = sc.nextLine();

                    //supprime courbe
                    if(str.equals("courbe")){
                        System.out.println("Tous les courbes créés:");
                        for (Courbe c: allCourbe) System.out.println(c.getNom());
                        System.out.println("");
                        System.out.println("supprimer le courbe:");
                        String csupprime = sc.nextLine();
                        for (Courbe c: allCourbe){
                            //remove from list allCourbe[]
                            if(c.getNom().equals(csupprime)) allCourbe.remove(c);

                            //remove from groupe
                            for (GroupCourbe grp: allGroup){
                                for (Courbe ctemp: grp.listCourbe){
                                    if(ctemp.getNom().equals(csupprime)) grp.deleteCourbe(ctemp);
                                }
                                System.out.println("");
                            }

                            System.out.println("supprime: "+c.getNom());
                        }
                        System.out.println("Tous les courbes:");
                        for (Courbe c: allCourbe) System.out.println(c.getNom());
                    }

                    //supprime courbe dans le groupe
                    if(str.equals("groupe")){
                        System.out.println("Tous les groupes créés:");
                        for (int i = 0; i< allGroup.size();i++){
                            System.out.print(i + ": ");
                            GroupCourbe grp = allGroup.get(i);
                            for (Courbe c: grp.listCourbe) System.out.print(c.getNom()+", ");
                            System.out.println("");
                        }
                        System.out.println("Indiquer le numero du groupe supprimé:");
                        int nbGrp = Integer.parseInt(sc.nextLine());
                        allGroup.remove(nbGrp);

                        System.out.println("Tous les groupes:");
                        for (int i = 0; i< allGroup.size();i++){
                            System.out.print(i + ": ");
                            GroupCourbe grp = allGroup.get(i);
                            for (Courbe c: grp.listCourbe) System.out.print(c.getNom()+", ");
                            System.out.println("");
                        }
                    }

                }

                //deplacement
                if(inp.equals("deplace")){
                    System.out.println("déplacer les [courbe] ou déplacer les [groupe]");
                    String str = sc.nextLine();

                    //deplace courbe
                    if(str.equals("courbe")){
                        System.out.println("Tous les courbes créés:");
                        for (Courbe c: allCourbe) System.out.println(c.getNom());
                        System.out.println("");

                        System.out.println("deplace le courbe:");
                        String courbeDepla = sc.nextLine();
                        System.out.println("(dx, dy): ");
                        double dx = Double.parseDouble(sc.nextLine());
                        double dy = Double.parseDouble(sc.nextLine());
                        
                        System.out.println("Apres deplacment:");
                        for (Courbe c: allCourbe){
                            if(c.getNom().equals(courbeDepla)) c.move(dx, dy);
                            System.out.println(c.toString());
                        }
                        
                    }

                    //deplace groupe
                    if(str.equals("groupe")){
                        System.out.println("Tous les groupes créés:");
                        for (int i = 0; i< allGroup.size();i++){
                            System.out.print(i + ": ");
                            GroupCourbe grp = allGroup.get(i);
                            for (Courbe c: grp.listCourbe) System.out.print(c.getNom()+", ");
                            System.out.println("");
                        }
                        System.out.println("Indiquer le numero du groupe deplacé:");
                        int nbGrp = Integer.parseInt(sc.nextLine());
                        System.out.println("(dx,dy): ");
                        double dx = Double.parseDouble(sc.nextLine());
                        double dy = Double.parseDouble(sc.nextLine());
                        allGroup.get(nbGrp).move(dx, dy);
                        System.out.println("Apres deplacement:");
                        System.out.println(allGroup.get(nbGrp).toString());
                    }
                }

                //sauvegarde à l’aide de la sérialisation
                if (inp.equals("sauvegarde")){
                    try
                    {
                        FileOutputStream fileOut = new FileOutputStream("courbes.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        for (Courbe c: allCourbe)    out.writeObject(c);
                        out.close();
                        fileOut.close();
                        System.out.printf("Serialized data is saved in courbes.ser");
                    }catch(IOException i)
                    {
                        i.printStackTrace();
                    }
                }

                //charge
                if (inp.equals("charge")){
                    try
                    {
                        FileInputStream fileIn = new FileInputStream("courbes.ser");
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        allCourbe.add( (Courbe) in.readObject());
                        in.close();
                        fileIn.close();
                    }catch(IOException i)
                    {
                        i.printStackTrace();
                        return;
                    }catch(ClassNotFoundException c)
                    {
                       c.printStackTrace();
                       return;
                    }
                }

                System.out.println("Command list:");
                System.out.println("circle, polygone, regroupe, affiche, deplace, supprime, quit, sauvegarde, charge \n");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
