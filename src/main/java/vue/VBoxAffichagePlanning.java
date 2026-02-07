package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.*;

import java.util.TreeSet;

public class VBoxAffichagePlanning extends VBox {

    private int num;
    private DateCalendrier dateCalendrier;
    private Label labelNumSemaine;
    TreeSet<Reservation> reservationsdelaSemaine;
    TableView<Reservation> tabledesReservations;

    public VBoxAffichagePlanning() {

        dateCalendrier = new DateCalendrier();
        labelNumSemaine = new Label("semaine :" + num);
        this.getChildren().add(labelNumSemaine);

        tabledesReservations = new TableView<>();

        TableColumn<Reservation, String> coursColumn = new TableColumn<>("Cours");
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("intitule"));
        tabledesReservations.getColumns().add(coursColumn);

        TableColumn<Reservation, DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        tabledesReservations.getColumns().add(dateColumn);

        TableColumn<Reservation, PlageHoraire> horaireColumn = new TableColumn<>("Horaire");
        horaireColumn.setCellValueFactory(new PropertyValueFactory<>("plagehoraire"));
        tabledesReservations.getColumns().add(horaireColumn);

        reservationsdelaSemaine = HBoxRoot.getPlanning().getTreeMapReservation(dateCalendrier.getWeekOfYear());
        if (reservationsdelaSemaine != null) {
            for (Reservation reservation : reservationsdelaSemaine) {
                tabledesReservations.getItems().add(reservation);
            }
        }
        this.getChildren().add(tabledesReservations);
    }

    public void setNumSemaine(int parNum) {
        num = parNum;
        labelNumSemaine.setText("semaine : " + num);
    }
}
