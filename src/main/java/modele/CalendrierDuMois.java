package modele;

import java.util.Collection;
import java.util.TreeSet;


/** Cette class représente un calendrier pour un mois spécifique d'une année spécifique.
 * Cette class remplie la liste de DateCalendrier chaque jour du mois.
 */
public class CalendrierDuMois {

    /** Un champ pour les mois du calendrier */
    private int mois;

    /** Un champ pour les années du calendrier */
    private int annee;

    /** Une liste des jours du mois représentés par des instances de DateCalendrier*/
    private Collection <DateCalendrier> treeSetDate;


    /**
     * Le constructeur permet de créer un calendrier pour un mois et une année précise.
     *
     * @param mois représentant les mois du calendrier.
     * @param annee représentant l'année du calendrier.
     */
    public CalendrierDuMois ( int mois, int annee) {
        this.mois = mois;
        this.annee = annee;
        treeSetDate = new TreeSet <DateCalendrier> ();
        DateCalendrier date = new DateCalendrier (1,mois,annee);
        int indiceJour = date.getJourSemaine() ;
        for (int x = indiceJour ; x!=0 ; x--) {
            treeSetDate.add(date);
            date = date.dateDeLaVeille();
        }
        date = new DateCalendrier (2,mois,annee);
        indiceJour = indiceJour % 7 ;
        while (date.getMois() == mois) {
            while(indiceJour<7) {
                treeSetDate.add(date);
                date = date.dateDuLendemain();
                indiceJour++ ;
            }
            indiceJour=0;
        }
    }



    /**
     * Créer une méthode qui renvoie la liste des jours du mois
     *
     * @return Une collection représentant les jours du mois
     */
    public Collection <DateCalendrier> getDates() {
        return treeSetDate;
    }


    /**
     * Méthode retournant le nombre de jours dans le mois
     *
     * @return une chaine de caractère avec le nombre de jours et sa liste.
     */
    public String toString () {
        return treeSetDate.size() + " " +treeSetDate.toString();
    }


    /**
     Accesseur permet d'obtenir le mois du calendrier
     *
     * @return le mois du calendrier
     */
    public int getMois () {
        return mois;
    }


    /**
     * Accesseur permettant d'obtenir l'année du calendrier
     *
     * @return l'année du calendrier
     */
    public int getAnnee() {
        return annee;
    }

}
