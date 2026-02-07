package com.example.javafx1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** La class HelloController est responsable de la gestions des interactions utilisateurs
 * avec JAVAFX.
 * Elle gère l'étiquette de bienvenue et la met à jour lorsque le bouton est cliqué.
 */
public class HelloController {
    @FXML
    /**
     * Etiquette pour afficher le message
     */
    private Label welcomeText;


    /** Cette méthode est appelée lorsque le bouton est cliqué.
     * Elle met à jour l'étiquette de bienvenue avec ce message.*/
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}