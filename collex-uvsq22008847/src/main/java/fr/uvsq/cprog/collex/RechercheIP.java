package fr.uvsq.cprog.collex;

public class RechercheIP implements Command {
    public String execute(String nom){
        DNS s = new DNS();
        return s.FQDNtoIP(nom);
    }
}
