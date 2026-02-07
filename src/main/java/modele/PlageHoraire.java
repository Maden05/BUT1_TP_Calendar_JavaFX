package modele;


/**
 * La class PlageHoraire représente une plage horaire définie par un horaire de début et de fin.
 * Elle permet de vérifier la validité de la plage horaire, de calculer sa durée
 * et de la comparer à d'autres plages horaires.
 */
public class PlageHoraire{

    /** un champ pour la durée minimal d'une plage horaire en minutes */
    private final static int DUREE_MINIMUM = 60;

    /** l'horaire de début de la plage horaire*/
    private Horaire horaireDebut;

    /** l'horaire de fin de la plage horaire*/
    private Horaire horaireFin;



    /**
     * Le constructeur créer une nouvelle instance de PlageHoraire avec un horaire de début et de fin.
     *
     * @param parhoraireDebut horaire de début
     * @param parHoraireFin horaire de fin
     * @throws ExceptionPlanning Si la plage horaire est inferieur au minimum.
     */
    public PlageHoraire (Horaire parhoraireDebut, Horaire parHoraireFin) throws ExceptionPlanning {
        if (parHoraireFin.toMinutes() - parhoraireDebut.toMinutes() < DUREE_MINIMUM){
            throw new ExceptionPlanning(3);
        }
        horaireDebut = parhoraireDebut;
        horaireFin = parHoraireFin;
    }



    /**
     * Vérifie si la plage hoarire est valide, si la durée et supérieur ou égale à la durée minimale.
     *
     * @return true si la plage horaire est valide sinon false.
     */
    public boolean estValide (){
        if (duree() > DUREE_MINIMUM){
            return true;
        }
        return false;
    }


    /**
     * Calculer la durée de la plage horaire en minutes.
     *
     * @return la durée en minutes
     */
    public int duree () {
        return horaireFin.toMinutes() - horaireDebut.toMinutes();
    }


    /**
     * Creer une methode qui compare la plage horaire actuelle avec une autre.
     *
     * @param plageAcomparer la plage horaire à comparer
     * @return un négatif si la plage horaire actuelle précède celle à colparer,
     *         un positif si la plage horaire à comparer précède l'actuelle,
     *         0 si ce sont les mêmes
     */
    public int compareTo (PlageHoraire plageAcomparer) {
        if (horaireFin.toMinutes() < plageAcomparer.horaireDebut.toMinutes()) {
            return -3;
        }
        if (horaireDebut.toMinutes() > plageAcomparer.horaireFin.toMinutes()) {
            return 3;
        }
        return 0;
    }


    /**
     * renvoie un str de la plage horaire osus la forme heure minutes
     *
     * @return la plage horaire en heure minutes*/
    public String toString() {
        int nmbMinutes = horaireFin.toMinutes() - horaireDebut.toMinutes();
        int nmbHeures = nmbMinutes / 60;
        return nmbHeures + "h" + nmbMinutes % 60 + "mins";
    }
}