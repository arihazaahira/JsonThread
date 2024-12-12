package Main;

public class main {
    public static void main(String[] args) {
        String inputDirectory = "src/Data/Inputfiles";
        String outputFile = "C:/Users/j/IdeaProjects/Jsondevoir/src/Data/Outpufiles/Orders.txt";
        String errorFile = "C:/Users/j//IdeaProjects/Jsondevoir/src/Data/Errorfiles/orders_error.txt";

        // Créer et démarrer le thread
        ParseJsonThread parseThread = new ParseJsonThread(inputDirectory, outputFile, errorFile);
        parseThread.start();
    }
}
