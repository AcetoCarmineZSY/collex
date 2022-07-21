package fr.uvsq.cprog.usestreams;

public enum Service {
    SERVICE_ONE("ONE","adrONE"),
    SERVICE_TWO("TWO","adrTWO")
    ;

    private final String nom;
    private final String adresse;

    Service(final String n, final String a) {
        this.nom = n;
        this.adresse = a;
    }

    @Override
    public String toString() {
        return name()+"("+nom + "," + adresse + ") ";
    }
}
