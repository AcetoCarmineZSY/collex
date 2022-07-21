package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.util.Scanner;

public class DnsApp {
    // interagira avec l’interface utilisateur pour récupérer la prochaine commande, 
    // l’exécutera puis affichera la résultat.
    public static void run(String str) throws IOException {
        DnsTUI d = new DnsTUI();
        d.affiche(d.nextCommande(str),str);
    }
    public static void main( String[] args) throws IOException{
        //Write dns.properties file
        new WriteFile();
        //Read command
        try (Scanner sc = new Scanner(System.in)) {
            while(sc.hasNextLine()){
                String inp = sc.nextLine();
                if(inp.equals("quit")){
                    break;
                }
                run(inp);
            }
        }   
    }
}
