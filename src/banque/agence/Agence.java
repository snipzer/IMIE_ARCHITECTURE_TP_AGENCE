package banque.agence;

import banque.compte.BaseCompte;

import java.io.Serializable;
import java.util.List;

public class Agence implements Serializable {

    private static Long NOMBRE_AGENCE = 0L;

    private List<BaseCompte> comptes;
    private String adresse;
    private Long identifier;

    public Agence(String adresse) {
        this.identifier = ++Agence.NOMBRE_AGENCE;
        this.adresse = adresse;
    }

    public static void setNombreAgence(Long number) {
        NOMBRE_AGENCE = number;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public List<BaseCompte> getComptes() {
        return comptes;
    }

    public void setComptes(List<BaseCompte> comptes) {
        this.comptes = comptes;
    }

    public void addComptes(BaseCompte compte) {
        this.comptes.add(compte);
    }

    public void removeComptes(BaseCompte compte) {
        this.comptes.remove(compte);
    }

    public String toString() {
        return "Agence n°" + this.identifier + ", adresse: " + this.adresse;
    }
}
