package vue;


import javafx.scene.layout.HBox;
import modele.ConstantesCalendrier;
import modele.PlanningCollection;
import controleur.Controleur;


/**
 * La class HBoxRoot représente l'interface utilisateur à l'application.
 * Elles contient les différentes vues et le controleur nécessaire au fonctionnement de l'application.
 */
public class HBoxRoot extends HBox implements ConstantesCalendrier {


    /** Le modèle de données de l'application*/
    private static PlanningCollection planning;

    /** Le controleur de l'application,*/
    private static Controleur controleur;

    /** La vue du calendrier */
    private static VBoxCalendrier calendierPane;

    /** La vue du formulaire */
    private static GridPaneFormulaireReservation reservationPane;

    /** La vue affichant les numéro de semaine */
    private static VBoxAffichagePlanning semaineNum ;


    /**
     * Un constructeur qui initialise les différentes vues et le controleur nécessaires
     * au fonctionnement de l'application.
     */
    public HBoxRoot() {

        // le modele
        planning = new PlanningCollection();

        // le controleur
        controleur = new Controleur();

        // semaine
        semaineNum = new VBoxAffichagePlanning();

        // Les vues
        calendierPane = new VBoxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();

        this.getChildren().add(calendierPane);
        this.getChildren().add(reservationPane);
        this.getChildren().add(semaineNum);

    }


    /** Récupère le modèle de donnée de l'applicaion.
     *
     * @return le modèle de données de l'application.
     */
    public static PlanningCollection getPlanning() {
        return planning;
    }


    /** Récupère la vue du formumaire.
     *
     * @return la vue du formaulaire.
     */
    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }


    /** Récupère le controleur de l'applcation.
     *
     * @return le controleur de l'application.
     */
    public static Controleur getControleur() {
        return controleur;
    }


    /** Récupère la vue affichant les numéros de semaine.
     *
     * @return la vue affichant les numéros de semaine.
     */
    public static VBoxAffichagePlanning getSemaineNum(){
        return semaineNum;
    }


}


