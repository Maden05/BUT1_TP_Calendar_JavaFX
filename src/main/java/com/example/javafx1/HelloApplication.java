package com.example.javafx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** Cette class permet de tester si java fonctionne en lançant une application JAVAFX.*/
public class HelloApplication extends Application {



    /**
     * Entrée princiapl pour l'application
     *
     * @param stage la scene principal de l'application.
     * @throws IOException si le fichier FXMl ne peut pas être chargé.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Entrée principal de l'application
     *
     * @param args les arguments*/
    public static void main(String[] args) {
        launch();
    }
}