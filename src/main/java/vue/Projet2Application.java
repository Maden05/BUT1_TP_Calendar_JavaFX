    package vue;

    import javafx.application.Application;
    import javafx.scene.Scene;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    import java.io.File;


    /**
     * La class Projet2Application est une application JAVAFX qui lance l'interface graphique
     * de l'application Projet2.
     */
    public class Projet2Application extends Application {


        /**
         * Méthode principal pour démarrer une application.
         *
         * @param stage stage principal de l'application.
         */
        public void start(Stage stage) {
            // Création du conteneur principal de l'interface utilisateur
            HBox root = new HBoxRoot();
            // Création de la scène avec le conteneur principal
            Scene scene = new Scene(root, 800, 380);

            // Chargement des fichiers CSS pour personnaliser le style de l'interface
            File [] fichiersCss = new File("css").listFiles();
            for (File fichier : fichiersCss) {
                scene.getStylesheets().add(fichier.toURI().toString());
            }
            // Configuration de la scène sur la fenêtre principale de l'application
            stage.setScene(scene);
            stage.setTitle("Calendrier");
            stage.show();
        }


        /**
         * Permet de pouvoir lancer l'application
         * @param args une syntaxe obligatoire pour cette méthode..
         */
        public static void main (String [] args) {
            Application.launch(args);
        }
    }