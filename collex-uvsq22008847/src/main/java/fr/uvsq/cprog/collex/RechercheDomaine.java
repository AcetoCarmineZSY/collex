package fr.uvsq.cprog.collex;

import java.util.ArrayList;

public class RechercheDomaine implements Command{
    public String execute(String inp) {
        //triée selon le nom des machines ou selon les adresses IP (si -a est présent).
        String[] temp = inp.split("\s");
        if (temp[0].equals("ls")){
            if (temp[1].equals("-a")){
                return with_a(inp.substring(6));
            }else{
                return without_a(inp.substring(3));
            }
        }else{
            return "Not a valid command.";
        }
    }
    
    public String without_a(String domaine) {
        DNS s =new DNS();
        ArrayList<String> nameTab = s.getFQDNsFromDomaine(domaine);
        String namelist = "";

        //Change the ArrayList to one Sting (with \n) to print
        for(String x :  nameTab){
            //get the name of machine: substring "FQDN", then substring before "domaine"
            String[] FQDN_IP = x.split(" , ");
            int place = FQDN_IP[0].indexOf(domaine);
            String name = FQDN_IP[0].substring(0,place-1);
            namelist = namelist + name;
            namelist = namelist + " ( " + x + " )\n";
        }
        return namelist;
    }

    public String with_a(String domaine) {
        DNS s =new DNS();
        ArrayList<String> nameTab = s.getIPsFromDomaine(domaine);
        String namelist = "";

        //Change the ArrayList to one Sting (with \n) to print
        for(String x :  nameTab){
            //get the name of machine: substring "FQDN", then substring before "domaine"
            String[] IP_FQDN = x.split(" , ");
            int place = IP_FQDN[1].indexOf(domaine);
            String name = IP_FQDN[1].substring(0,place-1);
            namelist = namelist + name;
            namelist = namelist + " ( " + x + " )\n";
        }
        return namelist;
    }
}
