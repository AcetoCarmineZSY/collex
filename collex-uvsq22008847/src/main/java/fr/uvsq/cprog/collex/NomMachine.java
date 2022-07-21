package fr.uvsq.cprog.collex;

/**
 * Classe: NomMachine
 * Représentent un nom qualifié de machine
 * Comme la forme:"machine.domaine.local"
 * 
 */

import java.net.*;
public class NomMachine {

    private InetAddress FQDN;  //Fully Qualified Domain Name

    //constructeur avec le nom_machine, ecrit en String
    public NomMachine(String s) throws UnknownHostException{
        this.FQDN = InetAddress.getByName(s);
    }

    public String getFQDNStr() {
        return FQDN.getCanonicalHostName();
    }

    public InetAddress getFQDN(){
        return FQDN;
    }
}
