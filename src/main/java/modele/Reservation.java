package modele;


/**
 * La class Reservation représente des réservation d'un événement à une date et à une plage horaire.
 * Elle contient des informations sur l'intitulé de la reservation, de la date et de la plage horaire.
 * On peut notamment comparer les reservations par date et par plage horaire ,
 * vérifier si elles sont bien valide et les afficher.
 */

public class Reservation implements Comparable <Reservation>{

    /** Un champs intitule de la reservation */
    private String intitule;

    /** Date de la reservation*/
    private Date date;

    /** Plage horaire de la reservation */
    private PlageHoraire plageHoraire;



    /**
     * Constructeur qui instancie les champs .
     *
     * @param parIntitule instancie l'intitule de la reservation.
     * @param pardate instancie la date de la reservation.
     * @param parPlageH instancie la plage horaire de la reservation.
     */
    public Reservation(String parIntitule, Date pardate, PlageHoraire parPlageH){
        intitule = parIntitule;
        date = pardate;
        plageHoraire = parPlageH;
    }

    /**
     * Retourne l'intitule de la reservation.
     *
     * @return l'intitule de la reservation.
     */
    public String getIntitule(){
        return intitule;
    }


    /** Retourne la date de la reservation.
     *
     * @return la date de la reservation.
     */
    public Date getDate(){
        return date;
    }

    /**
     * Comparer cette reservation avec une autre par date et par plage horaire.
     *
     * @param parRes La reservation à comparer.
     * @return Un négatif si cette réservation précède la réservation passée en argument,
     *         Un positif si elle suit la réservation passée en argument,
     *         0 si elles sont identiques.
     */
    public int compareTo(Reservation parRes){
        if (date.compareTo(parRes.date) < 0){
            return -1;
        }
        if (date.compareTo(parRes.date) > 0){
            return 1;
        }
        if (plageHoraire.compareTo(parRes.plageHoraire) < 0){
            return -2;
        }
        if (plageHoraire.compareTo(parRes.plageHoraire) > 0){
            return 2;
        }
        return 0;
    }


    /** Vérifie si la reservation est valide, date et plage horaire valide ou non.
     *
     * @return true si elle est valide sinon false.
     */
    public boolean estValide(){

        if (date.estValide() && plageHoraire.estValide()){ // return date.estValide() && plageH.estValide();
            return true;
        }
        return false;
    }


    /** Renvoie les reservations en chaine de caractère.
     *
     * @return Une chaine de caractère des reservations.
     */
    public String toString() {
        return intitule + " Le " + date +" pour une duree de " + plageHoraire;
    }

}
