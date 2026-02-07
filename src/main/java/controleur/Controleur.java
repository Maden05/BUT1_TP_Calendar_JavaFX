package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;
import vue.VBoxAffichagePlanning;


/**
 * La class controleur a pour but de gérer les évenements de l'application de reservation.
 * avec l'implémentation d'EventHandler qui permet d'écouter les actions.
 */
public class Controleur implements EventHandler {


    /**
     * Cette méthode gère les évenement déclenchés par l'interface utilisateur.
     * Cette méthode est appelé lorsqu'il y a un bouton cliqué.
     * Elle traite des évenement via des ToggleButton et des bouton classique.
     * @param event qui est l'évenement à gerer lorsqu'un bouton est cliqué par exemple
     */
    @Override
    public void handle(Event event) {
        PlanningCollection planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        VBoxAffichagePlanning semaine = HBoxRoot.getSemaineNum();

        // la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            ToggleButton toggle = (ToggleButton)event.getSource(); //bouton
            DateCalendrier date = (DateCalendrier)toggle.getUserData();// date cliquée
            // Met à jour le formulaire de réservation avec la date sélectionnée
            reservationPane.update(date);
            // met à jour l'affichage de la semaine
            semaine.setNumSemaine((reservationPane.getDate().getWeekOfYear()));
        }

        // Bouton enregistrer
        if (event.getSource() instanceof Button) {
            String intitule = reservationPane.getIntitule();
            DateCalendrier date = reservationPane.getDate();
            PlageHoraire plagehoraire = reservationPane.getPlagehoraire();
            Reservation resa = new Reservation(intitule, date, plagehoraire);
            // Ajoute la nouvelle réservation dans le planning
            planning.ajout(resa);
            // Affiche le planning mis à jour dans la console
            System.out.println(planning);
        }
    }

}