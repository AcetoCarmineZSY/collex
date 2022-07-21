package fr.uvsq.cprog.collex;

/**
 * Classe: AdresseIP
 * Représentent une adresse IP
 * 
 */

import java.net.*;

public class AdresseIP {
    
    private InetAddress Ip_ads;
    private String Ip_str;

    //constructeur avec IP ecrit en String
    public AdresseIP(String s) throws UnknownHostException{
        this.Ip_ads = InetAddress.getByName(s);
        this.Ip_str = Ip_ads.getHostAddress();
    }

    public String getIpStr() {
        return Ip_str;
    }

    public InetAddress getIp(){
        return Ip_ads;
    }

}
