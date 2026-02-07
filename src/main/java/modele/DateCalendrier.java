
package modele;


import java.util.Calendar;


/**
 * La class DateCalendrier représente une date dans notre calendrier avec des fonctionnalité
 * spécifiques liée au calendier. On peut obtenir le jour de la semaine et le numéro de la semaine
 * de l'année.
 * La class hérite avec Date et implémente l'interface comparable de Date.
 */
public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable <Date> {

    /** Un champ pour le jour de la semaine ( 1 --> lundi, 2 --> mardi ...)*/
    private int jourSemaine;

    /** Un champ pour le numéro de semaine de l'année */
    private int weekOfYear;


    /**
     * Un constructeur qui créer une instance de DateCalendrier représentant la date d'aujourd'hui
     */
    public DateCalendrier() {
        // GregorianCalendar dateAuj = new GregorianCalendar ();
        Calendar dateAuj = Calendar.getInstance();
        channee = dateAuj.get(Calendar.YEAR);
        chmois = dateAuj.get(Calendar.MONTH) + 1;
        chjour = dateAuj.get(Calendar.DAY_OF_MONTH);
        jourSemaine = dateAuj.get(Calendar.DAY_OF_WEEK);
        if (jourSemaine == 1)
            jourSemaine = 7;
        else jourSemaine -= 1;
        weekOfYear = dateAuj.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * Un constructeur qui créer une instance de DateCalendrier avec les paramètres spécifiés.
     *
     * @param parJour  le jour
     * @param parMois  le mois
     * @param parAnnee l'année
     */
    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        date.set(channee, chmois - 1, chjour);
        jourSemaine = date.get(Calendar.DAY_OF_WEEK);
        if (jourSemaine == 1)
            jourSemaine = 7;
        else jourSemaine -= 1;
        weekOfYear = date.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * Renvoie la date au format jour de la semaine, jour et mois.
     *
     * @return la représentation de la date en str
     */
    public String toString() {
        return JOURS_SEMAINE[jourSemaine - 1] + " " + chjour + " " + MOIS[chmois - 1];
    }


    /**
     * Obtient le jour de la semaine.
     *
     * @return le jour de la semaine
     */
    public int getJourSemaine() {
        return jourSemaine;
    }


    /**
     * Vérifie si la date est la date d'aujourd'hui.
     *
     * @return true si la date est la même sinon false.
     */
    public boolean isToday() {
        return this.compareTo(new DateCalendrier()) == 0;
    }


    /**
     * Obtient le numéro de la semaine de l'année.
     *
     * @return le numéro de la semaine de l'année.
     */
    public int getWeekOfYear() {
        return weekOfYear;
    }


    /**
     * Une méthode qui renvoie la date du lendemain.
     *
     * @return la adte du lendemain.
     */
    public DateCalendrier dateDuLendemain() {
        Date dateLendemain = super.dateDuLendemain();
        return new DateCalendrier(dateLendemain.chjour, dateLendemain.chmois, dateLendemain.channee);
    }


    /**
     * Une méthode qui renvoie la date de la veille.
     *
     * @return la date de la veille.
     */
    public DateCalendrier dateDeLaVeille() {
        Date dateVeille = super.dateDeLaVeille();
        return new DateCalendrier(dateVeille.chjour, dateVeille.chmois, dateVeille.channee);
    }

}