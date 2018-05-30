package banque.utils;

public class ErrorUtils {

    public static final String ERROR_CANNOT_INSTANCIATE_UTILS = "Error, cannot instanciate utils";
    public static final String ERREUR_VOUS_POUVEZ_CHOISIR_SEULEMENT_UN_NOMBRE_COMPRIS_ENTRE_1_ET_4 = "Erreur, vous pouvez choisir seulement un nombre compris entre 1 et 4";
    public static final String YOU_SHOULD_NOT_BE_SUPPOSED_TO_GO_HERE = "You should not be supposed to go here";

    ErrorUtils() {
        throw new RuntimeException(ERROR_CANNOT_INSTANCIATE_UTILS);
    }
}
