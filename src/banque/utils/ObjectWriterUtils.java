package banque.utils;

import banque.agence.Agence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ObjectWriterUtils {

    static void writeToFile(List<Agence> agences) {
        try (
                FileOutputStream fileOut = new FileOutputStream("./savedEntity/agence.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            out.writeObject(agences);
            out.close();
            fileOut.close();
            System.out.println("Sauvegarde des agences...");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Agence> getAgences() {
        List<Agence> agences = new ArrayList<>();
        try (
                FileInputStream fileIn = new FileInputStream("./savedEntity/agence.txt");
                ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            if (fileIn.available() != 0) {
                agences = (List<Agence>) in.readObject();
                in.close();
                fileIn.close();
                System.out.println("Récupération des agences");
            } else {
                System.out.println("Aucune agence de stockée");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return agences;
    }
}
