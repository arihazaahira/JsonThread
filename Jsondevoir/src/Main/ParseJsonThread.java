package Main;

import Models.Order;
import utils.JSONReader;
import utils.JSONWriter;
import utils.FileUtile;
import DAO.CustomerDAO;
import DAO.OrderDAO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonThread extends Thread {

    private final String inputDirectory;
    private final String outputFile;
    private final String errorFile;

    private boolean running = true;

    public ParseJsonThread(String inputDirectory, String outputFile, String errorFile) {
        this.inputDirectory = inputDirectory;
        this.outputFile = outputFile;
        this.errorFile = errorFile;
    }

    @Override
    public void run() {
        while (running) {
            long startTime = System.currentTimeMillis();

            try {
                // Accéder au répertoire contenant les fichiers JSON
                File folder = new File(inputDirectory);
                File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

                if (files != null && files.length > 0) {
                    System.out.println("Début du traitement des fichiers JSON...");

                    for (int i = 0; i < files.length; i++) {
                        File file = files[i];
                        System.out.println("Traitement du fichier : " + file.getName());

                        List<Order> orders = null;
                        try {
                            orders = JSONReader.readOrdersFromFile(file.getPath());
                        } catch (IOException e) {
                            System.err.println("Erreur lors de la lecture du fichier JSON : " + file.getName());
                            e.printStackTrace();
                            continue;
                        }

                        List<Order> remainingOrders = new ArrayList<>(); // Liste des ordres à conserver

                        for (Order order : orders) {
                            if (CustomerDAO.getCustomerById(order.getCustomerId()).isPresent()) {
                                OrderDAO.insertOrder(order);

                                FileUtile.appendToFile(outputFile, order);
                                System.out.println("Commande valide ajoutée : " + order);
                            } else {
                                FileUtile.appendToFile(errorFile, order);
                                System.out.println("Commande invalide ajoutée au fichier d'erreurs : " + order);
                                remainingOrders.add(order); // Conserver l'ordre invalide
                            }
                        }

                        // Mise à jour du fichier JSON avec les ordres restants
                        try {
                            JSONWriter.writeOrdersToFile(file.getPath(), remainingOrders);
                            System.out.println("Mise à jour du fichier JSON après traitement : " + file.getName());
                        } catch (IOException e) {
                            System.err.println("Erreur lors de la mise à jour du fichier JSON : " + file.getName());
                            e.printStackTrace();
                        }

                        if (i < files.length - 1) {
                            System.out.println("Attente de 1h minute avant de traiter le fichier suivant...");
                            Thread.sleep(60000); // Attendre 1 minute
                        }
                    }
                } else {
                    System.out.println("Aucun fichier JSON trouvé dans le répertoire.");
                }

                Thread.sleep(36000);

            } catch (InterruptedException e) {
                System.err.println("Le thread a été interrompu.");
                break;
            }
        }
        System.out.println("Le traitement des fichiers JSON a été arrêté.");
    }

    // Méthode pour arrêter le thread en toute sécurité
    public void stopProcessing() {
        running = false;
        this.interrupt();  // Interrompre la boucle du thread
    }
}
