package banque.compte;

public enum TypeCompte {
    SIMPLE("simple"), EPARGNE("epargne"), PAYANT("payant");

    private String libelle;

    TypeCompte(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
