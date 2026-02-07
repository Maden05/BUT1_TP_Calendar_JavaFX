package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.Date;
import modele.DateCalendrier;
import java.util.List;


/**
 * La class VBoxCalendrier représente une boite vertical qui contient un calendrier.
 * Elle affiche un calendrier, permettant à l'utilisateur de naviguer entre les mois.
 * Chaque mois est affiché dans un ensemble de ToggleButton.
 * L'utilisateur peut selectionner une date et cliquant sur le bouton de date.
 */
public class VBoxCalendrier extends VBox implements ConstantesCalendrier {



    /**
     * Un constructeur qui initialise un affichage du calendrier avec des boutons basculants
     * pour naviguer entre les mois.
     * Chaque mois est affiché dans un ensemble de boutons basculants dans une TilePane.
     * Les mois sont empiler les uns sur les autres dans un StackPane.
     * Lorsque la date est cliqué, l'action correspondante est transmise au controleur.
     * Le titre du calendrier affiche le mois et l'année actuels.
     */
    public VBoxCalendrier() {
        DateCalendrier today = new DateCalendrier();
        Label labelTitle = new Label(MOIS[today.getMois() -1] + " " + today.getAnnee());
        this.getChildren().add(labelTitle);

        StackPane stackPaneMois = new StackPane();

        ToggleGroup buttonGroup = new ToggleGroup();
        for (int numMois = 1; numMois <= 12; numMois++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois, today.getAnnee());
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size() / 7 + 1);
            tilePane.setId("opaque");

            for (String jourAb : JOURS_SEMAINE_ABR) {
                Label labelJour = new Label(jourAb);
                labelJour.setId("labelJour");
                tilePane.getChildren().add(labelJour);
            }

            for (DateCalendrier date : monthCalendar.getDates()) {
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));
                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);
                boutonDate.setUserData(date);
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println(boutonDate.getUserData());
                    }
                });
                boutonDate.setOnAction(HBoxRoot.getControleur());

                if (date.getMois() != monthCalendar.getMois()) {
                    boutonDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    boutonDate.setId("today");
                }
            }
            tilePane.setAccessibleText(MOIS[numMois-1]);
            stackPaneMois.getChildren().add(tilePane);
        }

        this.getChildren().add(stackPaneMois);



        List<Node> listMonthCalendar = stackPaneMois.getChildren();
        final int lastIndice = listMonthCalendar.size()-1;
        Node premierMois = listMonthCalendar.get(0);
        Node dernierMois = listMonthCalendar.get(lastIndice);

        // placer le mois courant en haut de la pile
        while (!listMonthCalendar.get(lastIndice).getAccessibleText().equals(MOIS[today.getMois()-1])) {
            listMonthCalendar.get(lastIndice).toBack();
        }

        HBox boxBouton = new HBox();

        Button boutonBack = new Button("<");
        boutonBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton back");
                listMonthCalendar.get(lastIndice).toBack();
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());
            }
        });
        Button boutonNext = new Button(">");
        boutonNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                listMonthCalendar.get(0).toFront();
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());

            }
        });

        Button boutonLast = new Button(">>");
        boutonLast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton last");
                while (!listMonthCalendar.get(lastIndice).getAccessibleText().equals(MOIS[11])) {
                    listMonthCalendar.get(lastIndice).toBack();
                }
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());
            }
        });
        Button boutonFirst = new Button("<<");
        boutonFirst.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton first");
                while (!listMonthCalendar.get(lastIndice).getAccessibleText().equals(MOIS[0])) {
                    listMonthCalendar.get(lastIndice).toBack();
                }
                labelTitle.setText(listMonthCalendar.get(lastIndice).getAccessibleText());
            }
        });
        boxBouton.getChildren().addAll(boutonFirst, boutonBack, boutonNext, boutonLast);
        this.getChildren().add(boxBouton);
    }

}