
/**
 * Module pour le Projet */
module com.example.javafx1 {


    /** javafx.controls est nécessaire pour avoir les composants de base de JAVAFX.*/
    requires javafx.controls;

    /** javafx.fxml permet de charger et interagir avec les fichiers FXML.*/
    requires javafx.fxml;

        /** org.controlsfx.controls est nécéssaire pour faire des controles avec la bibliothèque ControlFX.*/
    requires org.controlsfx.controls;


    opens com.example.javafx1 to javafx.fxml;

    /**
     * Contient les classe principales de l'application.
     * Ce package est utilisé pour être utilisé dans d'autres modules.*/
    exports com.example.javafx1;

    /** Le package vue contient les composants de vue, les interfaces utilisateurs, le/les controleurs
     * et ce package est exporté pour être utilisé dans d'autres modules.*/
    exports vue;
}