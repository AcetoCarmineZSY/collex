package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 *Classe: DnsTUI
 *se chargera des interactions avec l’utilisateur. 
 **/

public class DnsTUI {
    public DnsTUI(){

    }
//analysera le texte saisi par l’utilisateur 
//et retournera un objet implémentant l’interface Commande
    public Command nextCommande(String inp) {
        Pattern patternMAC = Pattern.compile("[a-z0-9.]*");
        Pattern patternIP = Pattern.compile("[0-9.]*");
        if(inp == "quit"){
            QUIT q = new QUIT();
            return q;
        }else if (patternIP.matcher(inp).matches()){
            RechercheNom rn = new RechercheNom();
            return rn;
        }else if(patternMAC.matcher(inp).matches()){
            RechercheIP rip = new RechercheIP();
            return rip;
        }else if (inp.charAt(0)=='l' && inp.charAt(1)=='s'){
            RechercheDomaine rd = new RechercheDomaine();
            return rd;
        }else{
            WrongCommand wc = new WrongCommand();
            return wc;
        }
    }

    //affichera un résultat
    public void affiche(Command c, String inp) throws IOException {
        System.out.println(c.execute(inp));
    }
}
