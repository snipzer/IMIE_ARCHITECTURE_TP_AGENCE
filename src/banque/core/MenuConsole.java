package banque.core;

import banque.agence.Agence;
import banque.utils.ErrorUtils;
import banque.utils.ObjectWriterUtils;
import banque.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuConsole {

    private final Scanner sc = new Scanner(System.in);
    private List<Agence> agences;
    private Agence agence;

    public MenuConsole() {
        this.agences = new ArrayList<>();
    }

    public void process() {
        int option;
        Boolean stop = false;
        this.agences = ObjectWriterUtils.getAgences();
        Agence.setNombreAgence(findAgenceLastIndex());
        while (!stop) {
            displayChoices();
            option = askInt();
            checkIfOptionIsCorrect(option);
            stop = (option == 5);
            System.out.println(StringUtils.VOUS_AVEZ_CHOISIE + option);
            this.applyOption(option);
        }
        ObjectWriterUtils.writeToFile(this.agences);
    }

    private void checkIfOptionIsCorrect(int option) {
        if (option < 1 || option > 6) {
            throw new RuntimeException(ErrorUtils.ERREUR_VOUS_POUVEZ_CHOISIR_SEULEMENT_UN_NOMBRE_COMPRIS_ENTRE_1_ET_4);
        }
    }

    private void displayChoices() {
        System.out.println(StringUtils.BONJOUR_VOUS_POUVEZ);
        System.out.println(StringUtils.CREER_UNE_AGENCE);
        System.out.println(StringUtils.SELECTIONNER_UNE_AGENCE);
        System.out.println(StringUtils.MODIFIER_UNE_AGENCE);
        System.out.println(StringUtils.SUPPRIMER_UNE_AGENCE);
        System.out.println(StringUtils.QUITTER_LE_PROGRAMME);
        System.out.print(StringUtils.CHOISSISEZ_UNE_OPTION);
    }

    private Long findAgenceLastIndex() {
        Long index = 0L;
        for (Agence agence : this.agences) {
            if (agence.getIdentifier() > index) {
                index = agence.getIdentifier();
            }
        }
        return index;
    }

    private void applyOption(int option) {
        switch (option) {
            case 1:
                createAgence();
                break;
            case 2:
                selectAgence();
                break;
            case 3:
                updateAgence();
                break;
            case 4:
                deleteAgence();
                break;
            default:
                break;
        }
    }

    private void createAgence() {
        Agence agence = new Agence(askAgenceAdresse(StringUtils.VEUILLEZ_ENTRER_L_ADRESSE_DE_L_AGENCE));
        this.agences.add(agence);
        System.out.println(agence.toString() + StringUtils.EST_BIEN_CREER);
    }

    private void updateAgence() {
        Boolean stop = false;
        while (!stop) {
            selectAgence();
            if (this.agence != null) {
                String adresse = askAgenceAdresse(StringUtils.VEUILLEZ_ECRIRE_LA_NOUVELLE_ADRESSE_DE_L_AGENCE);
                this.agence.setAdresse(adresse);
                stop = true;
            }
        }
    }

    private void deleteAgence() {
        selectAgence();
        if (confirmChoice()) {
            this.agences.remove(this.agence);
        }
    }

    private void selectAgence() {
        printAgencesList();
        System.out.println(StringUtils.VEUILLEZ_SELECTIONNER_UNE_AGENCE_VIA_SONT_CODE);
        Long code = ((Integer) askInt()).longValue();
        this.agence = getAgenceWithIdentifier(code);
    }

    private Boolean confirmChoice() {
        System.out.print(StringUtils.CONFIRMER_VOUS_VOTRE_ACTION_Y_N);
        String response = sc.nextLine();
        return (response.equals(StringUtils.Y));
    }

    private Agence getAgenceWithIdentifier(Long identifier) {
        for (Agence agence : this.agences) {
            if (agence.getIdentifier().equals(identifier)) {
                return agence;
            }
        }
        return null;
    }

    private void printAgencesList() {
        if (!isAgenceEmpty()) {
            System.out.println(StringUtils.LISTES_DES_AGENCES);
            for (Agence agence : this.agences) {
                System.out.println(agence.toString());
            }
        } else {
            System.out.println(StringUtils.PAS_D_AGENCES_D_ENREGISTRER);
        }
    }

    private Boolean isAgenceEmpty() {
        return (this.agences.size() == 0);
    }

    private int askInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    private String askAgenceAdresse(String message) {
        Boolean stop = false;
        String adresse = null;
        while (!stop) {
            System.out.print(message);
            adresse = sc.nextLine();
            stop = confirmChoice();
        }
        return adresse;
    }
}
