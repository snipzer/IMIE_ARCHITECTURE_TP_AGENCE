package banque.compte;

import banque.agence.Agence;

public class Payant extends BaseCompte {

    Payant(TypeCompte typeCompte, Float solde, Agence agence) {
        super(typeCompte, solde, agence);
    }

    @Override
    public void addToSolde(Float nombre) {
        Float detteProcedure = (float) (nombre * 0.5);
        setSolde(getSolde() + nombre - detteProcedure);
    }

    @Override
    public void removeToSolde(Float nombre) {
        Float detteProcedure = (float) (nombre * 0.5);
        setSolde(getSolde() - nombre - detteProcedure);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
