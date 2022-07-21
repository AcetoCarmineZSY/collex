package fr.uvsq.cprog.collex;

/**
 * Classe: WriteFile
 * Creer le base de donnnes
 * Ecrire un fichier texte (une ligne par machine au format “un_nom_de_machine une.adresse.IP”)
 * Stocké dans un fichier de propriétés
 * 
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.net.*;

public class WriteFile {

    private String[] IPs;
    private String[] FQDNs;

    public WriteFile() throws UnknownHostException {
        //tableau des adresse IP
        this.IPs = new String[]{"74.125.65.91",    //Google
                        "74.125.65.93",
                        "74.125.65.94",
                        "74.125.65.101",
                        "74.125.65.105",
                        "74.125.65.110",
                        "74.125.65.90",
                        "74.125.66.90",
                        "74.125.64.92",
                        "8.8.8.8",         //Google
                        "9.9.9.9",         //quad9
                        "208.67.222.222",  //OpenDNS Home
                        "188.138.57.95",   //Host Europe GmbH
                        "199.59.149.230",  //twitter
                        "199.59.149.229",
                        "199.59.149.228",
                        "83.236.183.211",  //Plusnet GmbH
                        "81.82.253.90",    //Telenet BVBA
                        "129.79.1.1",      //indiana.edu
                        "129.79.1.2",
                        "129.79.1.3",
                        "129.79.1.4",
                        "129.79.1.5",
                        "129.79.1.6",
                        "129.79.1.7",
                        "129.79.1.8",
                        "129.79.1.9",
                        "129.79.1.10",
                        "129.79.1.11",
                        "129.79.1.12",
                        "129.79.1.13",
                        "129.79.1.14",
                        "129.79.1.15",
                        "129.79.1.16",
                        "129.79.1.19",
                        "129.79.1.20",
                        "129.79.1.23",
                        "34.227.4.120",    //amazonaws
                        "35.153.58.124",
                        "34.234.59.120",
                        "34.236.214.109",
                        "34.238.74.93",
                        "34.229.8.114",
                        "54.85.172.124",
                        "52.20.168.249",
                        "193.51.31.90",    //uvsq
                        "193.51.31.91",
                        "193.51.31.94",
                        "193.51.31.92",
                        "193.51.31.93",
                        "193.51.31.95",
                        "193.51.31.96",
                        "193.51.31.97",
                        "193.51.31.98",
                        "193.51.31.99",
                        "193.51.31.100",
                        "129.175.212.146",   //universite-paris-saclay
                        "129.175.212.170",
                        "129.175.212.147",
                        "129.175.212.148",
                        "129.175.212.150",   //u-psud
                        "129.175.212.160",
                        "129.175.212.165",
                        "129.175.212.161",
                        "129.175.212.169",
                    };
        
        //calculer FQDN tableau
        this.FQDNs = new String[IPs.length];
        for (int i = 0; i<IPs.length; i++){
            InetAddress addr = InetAddress.getByName(IPs[i]);
            FQDNs[i] = addr.getCanonicalHostName();
        }

        //I/O,write a properties file
        try (OutputStream output = new FileOutputStream("dns.properties")) {

            Properties prop = new Properties();

            // set the properties value
            for (int i = 0; i<IPs.length; i++){
                prop.setProperty(IPs[i], FQDNs[i]);
            }

            // save properties to project root folder
            prop.store(output, null);

            //System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String[] getIPs() {
        return IPs;
    }

    public String[] getFQDNs(){
        return FQDNs;
    }
}
