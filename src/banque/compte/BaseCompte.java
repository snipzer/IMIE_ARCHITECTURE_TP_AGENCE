package banque.compte;

import banque.agence.Agence;

import java.io.Serializable;

public abstract class BaseCompte implements Serializable {

    private static Long NOMBRE_COMPTES = 1L;
    private TypeCompte typeCompte;
    private Long code;
    private Float solde;
    private Agence agence;

    public BaseCompte(TypeCompte typeCompte, Float solde, Agence agence) {
        this.code = BaseCompte.NOMBRE_COMPTES++;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.agence = agence;
    }

    protected String getTypeCompte() {
        return typeCompte.name();
    }

    protected Long getCode() {
        return this.code;
    }

    protected Float getSolde() {
        return solde;
    }

    protected void setSolde(Float solde) {
        this.solde = solde;
    }

    protected void addToSolde(Float number) {
        this.solde = this.solde + number;
    }

    protected void removeToSolde(Float number) {
        this.solde = this.solde - number;
    }

    protected Agence getAgence() {
        return agence;
    }

    protected void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Override
    public String toString() {
        return "Compte n°" + this.code +
                " de type " + this.typeCompte.getLibelle() +
                " appartenant à l'agence n°" + this.agence.getIdentifier() +
                " solde du compte: " + this.solde;
    }
}