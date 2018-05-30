package garage;

public class Vehicule {

    private static Long _instances;
    private String _matricule;
    private String _annee;
    private Float _prix;


    Vehicule(String matricule, String annee, Float prix) {
        _instances++;
        _matricule = matricule + _instances;
        _annee = annee;
        _prix = prix;
    }

    protected String getMatricule() {
        return _matricule;
    }

    protected String getAnnee() {
        return _annee;
    }

    protected void setAnnee(String annee) {
        _annee = annee;
    }

    protected Float getPrix() {
        return _prix;
    }

    protected void setPrix(Float prix) {
        _prix = prix;
    }
}
