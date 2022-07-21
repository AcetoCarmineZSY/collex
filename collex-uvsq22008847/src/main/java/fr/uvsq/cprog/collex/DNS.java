package fr.uvsq.cprog.collex;
/**
 * Classe: DNS
 * Charger le BDD
 * Transferer entre Adresse IP et NomMachine
 * 
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Collections;

public class DNS {

    //IO variable to read the properties file
    private Properties prop;

    //constructor to load the database
    public DNS() {

        try (InputStream input = new FileInputStream("dns.properties")) {

            this.prop = new Properties();

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //methode getItem() qui retourne une instance de DnsItem 
    //soit à partir d’une adresse IP, soit à partir d’un nom de machine
    public AdresseIP getIP(DnsItem i) throws UnknownHostException {
        //si i est un nom machine
        AdresseIP aip = new AdresseIP(i.getNomMachine().getFQDN().getHostAddress());
        return aip;
    }

    public NomMachine getNomMac(DnsItem i) throws UnknownHostException{
        //si i est un adresse IP
        NomMachine nm = new NomMachine(i.getDNSitem().getHostName());
        return nm;
    }

    //Search from the database, string to string, faster than using DnsItem(should consult DNS server)
    public String FQDNtoIP(String s) {
        for (String key : prop.stringPropertyNames()) {
            if (prop.getProperty(key).equals(s)){
                return key;
            }
        }
        return "Not valid FQDN";
    }

    public String IPtoFQDN(String s){
        return prop.getProperty(s);
    }

    //une méthode getItems qui retournera une liste d’items à partir d’un nom de domaine.

    public ArrayList<String> getFQDNsFromDomaine(String domaine){
        ArrayList<String> Items = new ArrayList<>();
        //Traverse every FQDN(value) of dns.properties, seperate into FQDN[]
        for (String key : prop.stringPropertyNames()){
            String value = prop.getProperty(key);
            String delimeter = "\\.";   //seperate by ".",
            //"machine.domaine.local" -> "machine","domaine","local"
            String[] FQDN = value.split(delimeter);

            //Compare the second last string and the given string 'domaine'
            if (FQDN[FQDN.length-2].equals(domaine)){
                Items.add(value + " , " + key);
            }
        }
        //sort the list by FQDN
        Collections.sort(Items);
        if(Items.isEmpty()) Items.add("Not found");
        return Items;
    }

    public ArrayList<String> getIPsFromDomaine(String domaine){
        ArrayList<String> Items = new ArrayList<>();
        //Same as getFQDNs, but return list sort by IP@ (key)
        for (String key : prop.stringPropertyNames()){
            String value = prop.getProperty(key);
            String delimeter = "\\.";
            String[] FQDN = value.split(delimeter);

            //Compare the second last string and the given string 'domaine'
            if (FQDN[FQDN.length-2].equals(domaine)){
                Items.add(key + " , " + value);
            }
        }
        Collections.sort(Items);
        if(Items.isEmpty()) Items.add("Not found");
        return Items;
    }


    
}
