package fr.uvsq.cprog.collex;

public class RechercheNom implements Command {
    public String execute(String ip) {
        DNS s = new DNS();
        return s.IPtoFQDN(ip);
    }
}
