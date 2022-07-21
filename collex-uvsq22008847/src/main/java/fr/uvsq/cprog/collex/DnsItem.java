package fr.uvsq.cprog.collex;

/**
 * Classe: DnsItem
 * Représentent un adresse IP ou un nom qualifié de machine
 * 
 */

import java.net.*;

public class DnsItem {
    private AdresseIP ipAdr;
    private NomMachine nomMac;
    private InetAddress DNSitem;
    
    //constructeur avec ip ou nom_machine
    public DnsItem(AdresseIP ip) {
        this.ipAdr = ip;
    }

    public DnsItem(NomMachine nm){
        this.nomMac = nm;
    }

    //constructeur avec le string, s peut etre un ip adresse ou un nom_machine
    public DnsItem(String s) throws UnknownHostException {
        this.DNSitem = InetAddress.getByName(s);
        this.ipAdr = new AdresseIP(s);
        this.nomMac = new NomMachine(s);
    }

    public AdresseIP getAdresseIP(){
        return ipAdr;
    }

    public NomMachine getNomMachine() {
        return nomMac;
    }

    public InetAddress getDNSitem() {
        return DNSitem;
    }
}
