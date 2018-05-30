package banque.compte;

import banque.agence.Agence;

public class Epargne extends BaseCompte {

    private Float tauxInteret;

    public Epargne(TypeCompte typeCompte, Float solde, Agence agence, Float tauxInteret) {
        super(typeCompte, solde, agence);
        this.tauxInteret = tauxInteret;
    }

    public Float getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Float tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret() {
        setSolde(getSolde() * this.tauxInteret);
    }

    @Override
    public String toString() {
        return super.toString() + " taux d'interet du compte: " + this.tauxInteret;
    }
}
