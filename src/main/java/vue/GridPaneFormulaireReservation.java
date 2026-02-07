package vue;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.*;

/**
 * La class GridPaneFormulaireReservation représente un formulaire de reservation sous forme de grille.
 * L'utilisateur peut saisir les informations necessaires pour effectuer une reservation,
 * telles que l'intitule du cours , la date et l'horaire.
 */
public class GridPaneFormulaireReservation extends GridPane implements ConstantesCalendrier {

    // ATTRIBUTS
    Label labelDate;
    DateCalendrier date;
    TextField textFieldCours = new TextField();

    ComboBox<String> comboHeureDebut;
    ComboBox<String> comboMinuteDebut;
    ComboBox<String> comboHeureFin;
    ComboBox<String> comboMinuteFin;

    public GridPaneFormulaireReservation() {
        this.setPadding(new Insets(20));
        this.setHgap(5);
        this.setVgap(5);
        this.setGridLinesVisible(false);

        // DATE
        date = new DateCalendrier();
        labelDate = new Label(date.toString());
        Separator separateurDate = new Separator();
        this.add(labelDate, 1, 0, 5, 1);
        this.add(separateurDate, 0, 1, 6, 1);

        // COURS
        Label cours = new Label("_cours ");
        textFieldCours = new TextField();
        cours.setMnemonicParsing(true);
        cours.setLabelFor(textFieldCours);
        this.add(cours, 0, 2);
        this.add(textFieldCours, 1, 2, 6, 1);
        Platform.runLater(() -> textFieldCours.requestFocus());

        // NIVEAU
        int ligne = 1;
        Label labelNiveau = new Label("niveau");
        ToggleGroup radioGroup = new ToggleGroup();
        for (String niveau : NIVEAUX) {
            RadioButton radioButton = new RadioButton("_" + niveau);
            radioButton.setSelected(niveau.equals(NIVEAUX[0]));
            radioButton.setUserData(niveau);
            radioButton.setToggleGroup(radioGroup);
            this.add(radioButton, ligne++, 3);
        }
        this.add(labelNiveau, 0, 3);

        // HORAIRE
        Separator separateurHoraire = new Separator();
        Label horaire = new Label("horaire ");
        Label de = new Label("de");
        Label a = new Label("à");
        Label hDebut = new Label(" h");
        Label mnDebut = new Label(" mn");
        this.add(horaire, 0, 4);
        this.add(de, 1, 4);
        this.add(a, 1, 5);
        this.add(hDebut, 3, 4);
        this.add(mnDebut, 5, 4);
        this.add(separateurHoraire, 0, 6, 6, 1);

        Label hFin = new Label(" h");
        Label mnFin = new Label(" mn");
        this.add(hFin, 3, 5);
        this.add(mnFin, 5, 5);

        comboHeureDebut = peupleComboBox(HEURES);
        comboHeureDebut.setValue(HEURES[0]);
        comboMinuteDebut = peupleComboBox(MINUTES);
        comboMinuteDebut.setValue(MINUTES[0]);
        this.add(comboHeureDebut, 2, 4);
        this.add(comboMinuteDebut, 4, 4);

        comboHeureFin = peupleComboBox(HEURES);
        comboHeureFin.setValue(HEURES[1]);
        comboMinuteFin = peupleComboBox(MINUTES);
        comboMinuteFin.setValue(MINUTES[0]);
        this.add(comboHeureFin, 2, 5);
        this.add(comboMinuteFin, 4, 5);

        // BOUTONS
        Button annuler = new Button("Annuler");
        annuler.setOnAction(actionEvent -> {
            textFieldCours.setText("");
            comboHeureDebut.setValue(HEURES[0]);
            comboMinuteDebut.setValue(MINUTES[0]);
            comboHeureFin.setValue(HEURES[1]);
            comboMinuteFin.setValue(MINUTES[0]);
        });

        Button enregistrer = new Button("Enregistrer");
        enregistrer.setOnAction(HBoxRoot.getControleur());

        this.add(annuler, 3, 7);
        this.add(enregistrer, 5, 7);
    }

    private ComboBox<String> peupleComboBox(String[] strings) {
        ComboBox<String> comboBox = new ComboBox<>();
        for (String string : strings) {
            comboBox.getItems().add(string);
        }
        return comboBox;
    }

    public void update(DateCalendrier pardate) {
        date = pardate;
        labelDate.setText(pardate.toString());
    }

    public DateCalendrier getDate() {
        return date;
    }

    public String getIntitule() {
        return textFieldCours.getText();
    }

    public PlageHoraire getPlagehoraire() {
        Horaire horaireDebut = new Horaire(comboHeureDebut.getSelectionModel().getSelectedIndex() + 7,
                comboMinuteDebut.getSelectionModel().getSelectedIndex() * 15);
        Horaire horaireFin = new Horaire(comboHeureFin.getSelectionModel().getSelectedIndex() + 7,
                comboMinuteFin.getSelectionModel().getSelectedIndex() * 15);
        try {
            return new PlageHoraire(horaireDebut, horaireFin);
        } catch (ExceptionPlanning e) {
            throw new RuntimeException(e);
        }
    }

    public void creerReservation() {
        Reservation res = new Reservation(getIntitule(), getDate(), getPlagehoraire());
        HBoxRoot.getPlanning().ajout(res);
    }
}
