package banque.compte;

import banque.agence.Agence;

public class Classique extends BaseCompte {

    private Long decouvert;

    public Classique(TypeCompte typeCompte, Float solde, Agence agence, Long decouvert) {
        super(typeCompte, solde, agence);
        this.decouvert = decouvert;
    }

    public Long getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Long decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public void removeToSolde(Float number) {
        Float soldeAfterCalc = getSolde() - number;
        if (soldeAfterCalc >= this.decouvert) {
            setSolde(soldeAfterCalc);
        } else {
            throw new RuntimeException("Vous n'êtes pas autoriser à dépasser votre découvert");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " decouvert autorisé :" + this.decouvert;
    }
}
