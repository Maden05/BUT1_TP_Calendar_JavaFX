package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;

import java.util.List;


/**
 * La class VBoxRoot représente une vue verticale contenant un calendrier annuel.
 * Elle affiche les mois de l'année en permettant la navigation entre les mois vial les ToggleButton.
 */
public class VBoxRoot extends VBox implements ConstantesCalendrier {

    /**
     * Contructeur qui initialise l'affichage du calendrier pour l'année en cours, permettant de naviguer
     * entre les mois à l'aide de boutons.
     */
    public VBoxRoot() {

        // Obtenez la date actuelle
        Date today = new Date();

        // Créez le calendrier du mois actuel
        CalendrierDuMois monthCalendar = new CalendrierDuMois(today.getMois(), today.getAnnee());
        System.out.println (monthCalendar);

        // Créez et ajoutez le titre du mois et de l'année en cours
        Label labelTitle = new Label(MOIS[monthCalendar.getMois()-1] + " " + monthCalendar.getAnnee());
        this.getChildren().add(labelTitle);

        // Créez un conteneur pour les mois
        StackPane stackPaneMois = new StackPane();

        // Ajoutez chaque mois au conteneur
        for (int i=1; i<= 12; i++) {
            VBox.setMargin( labelTitle, new Insets(14) );
            VBox boiteDates = new VBox ();
            monthCalendar = new CalendrierDuMois(i, 2024);
            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteDates);
            VBox.setMargin( scrollPaneDates, new Insets(4) );

            // Ajoutez chaque date au conteneur de dates
            for (DateCalendrier date : monthCalendar.getDates()) {
                Label labelDate = new Label(date.toString());

                // Les attributs id sont utilisés dans la feuille de style
                if (date.getMois() != monthCalendar.getMois()) {
                    labelDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    labelDate.setId("today");
                }
                VBox.setMargin(labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }
            scrollPaneDates.setAccessibleText(MOIS[i-1]); // // Associe le nom du mois
            stackPaneMois.getChildren().add(scrollPaneDates);
        }
        this.getChildren().add(stackPaneMois);

        // Liste des mois affichés
        List<Node> listMonthCalendar = stackPaneMois.getChildren();
        final int lastIndice = listMonthCalendar.size()-1;
        Node premierMois = listMonthCalendar.get(0);
        Node dernierMois = listMonthCalendar.get(lastIndice);

        // Place le mois courant en haut de la pile
        while (!listMonthCalendar.get(lastIndice).getAccessibleText().equals(MOIS[today.getMois()-1])) {
            listMonthCalendar.get(lastIndice).toBack();
        }

        // Créez la boîte contenant les boutons de navigation
        HBox boxBouton = new HBox();

        // Bouton de navigation arrière
        Button boutonBack = new Button("<");
        boutonBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton back");
                listMonthCalendar.get(lastIndice).toBack();
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());
            }
        });

        // Bouton de navigation avant
        Button boutonNext = new Button(">");
        boutonNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                listMonthCalendar.get(0).toFront();
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());

            }
        });

        // Bouton pour aller au dernier mois
        Button boutonLast = new Button("<<");
        boutonLast.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                while (!listMonthCalendar.get(lastIndice).getAccessibleText().equals(MOIS[11])) {
                    listMonthCalendar.get(lastIndice).toBack();
                }
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());
            }
        });

        // Bouton pour aller au premier mois
        Button boutonFirst = new Button(">>");
        boutonFirst.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton first");
                while (!listMonthCalendar.get(lastIndice).getAccessibleText().equals(MOIS[0])) {
                    listMonthCalendar.get(lastIndice).toBack();
                }
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());
            }
        });

        // Ajoutez les boutons à la boîte et la boîte au VBoxRoot
        boxBouton.getChildren().addAll(boutonBack, boutonNext, boutonLast, boutonFirst);
        this.getChildren().add(boxBouton);
    }

}
