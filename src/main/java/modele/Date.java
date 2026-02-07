package modele;

import java.util.Calendar;
import java.util.Scanner;

/** La classe Date représente une date classique de notre calendrier.
 * On créer, manipule et valide des dates dans cette classe.
 */
public class Date {

    /** Le jour de la date en protected pour que ce champ soit accessible
     * sur les autres classes du même package.
     */
    protected int chjour;

    /** Le mois de la date en protected */
    protected int chmois;

    /** L'année de la date en protected*/
    protected int channee;




    /**
     * Le constructeur créer une nouvelle instance de Date avec ce qu'il prend en paramètre.
     *
     * @param parJour : le jour de la date
     * @param parMois : le mois de la date
     * @param parAnnee : l'année de la date
     */
    public Date(int parJour, int parMois, int parAnnee){
        chjour = parJour;
        chmois = parMois;
        channee = parAnnee;
    }



    /**
     * Le constructeur créer une nouvelle instance de Date avec seulement l'année spécifiée.
     *
     * @param parAnnee : l'année de la date.
     */
    public Date(int parAnnee){
        chjour = 1;
        chmois = 1;
        channee = parAnnee;
    }




    /**
     * Le constructeur initialise une instance de Date avec une date spécifique.*/
    public Date(){
        chjour = 1;
        chmois = 1;
        channee = 2024; // Année par default
    }



    /** Une méthode statique pour obtenir le dernier jour d'un mois pour une année et un mois donnée.
     *
     * @param parAnnee : l'année
     * @param parMois : le mois
     * @return : le dernier jour du mois
     */
    public static int dernierJourDuMois(int parAnnee, int parMois){
        switch (parMois) {
            case 2:
                if ((parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0)
                    return 29;
                return 28;
            case 4: case 6: case 9: case 11: return 30;
            default: return 31;
        }
    }



    /**
     * vérifie si la date est valide, si la date existe bien.
     *
     * @return true si la date est valide sinon false
     */
    public boolean estValide(){
        if (channee >= 1583){
            if (1 <= chmois && chmois <= 12){
                if (chjour >= 1 && chjour <= dernierJourDuMois(channee, chmois)){
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * Créer une méthode qui permet à l'utilisateur de rentrer une date depuis la console.
     *
     * @return la date entrer sur la console.
     */
    public static Date lireDate(){
        System.out.println("Veillez saisir un jour");
        Scanner scanner = new Scanner(System.in);
        int jour = scanner.nextInt();
        System.out.println("Veillez saisir un mois");
        scanner = new Scanner(System.in);
        int mois = scanner.nextInt();
        System.out.println("Veillez saisir un annee");
        scanner = new Scanner(System.in);
        int annee = scanner.nextInt();
        return new Date(jour, mois, annee);
    }




    /**
     * Créer une méthode qui compare la date actuelle avec une autre date en paramètre..
     *
     * @param parDate : la date à comparer.
     * @return  un négatif si la date actuelle est avant la date mise en paramètre,
     *          0 si la date actuelle est la même que la date mise en paramètre,
     *          un positif si la date actuelle est après la date mise en paramètre.
     */
    public int compareTo(Date parDate){
        if (channee < parDate.channee){
            return -1;
        }
        if (channee == parDate.channee){
            if (chmois < parDate.chmois){
                return -1;
            }
            if (chmois == parDate.chmois){
                if (chjour < parDate.chjour){
                    return -1;
                }
                if (chjour == parDate.chjour){
                    return 0;
                }
            }
        }
        return 1;
    }



    /**
     * Créer une méthode qui renvoie le numéro de la semaine de l'année pour la date.
     *
     * @return le numéro de la semaine de l'année.
     */

    public int getWeekOfYear () {
        Calendar date = Calendar.getInstance();
        date.set(channee, chmois + 1, chjour);
        return date.get(Calendar.WEEK_OF_YEAR);
    }



    /**
     * Créer une méthode qui renvoie la date du lendemain.
     *
     * @return la date du lendemain
     */
    public Date dateDuLendemain(){
        Date DateLDM = new Date(chjour + 1, chmois, channee);
        if (DateLDM.estValide()){
            return DateLDM;
        }
        DateLDM = new Date(1, chmois + 1, channee);
        if (DateLDM.estValide()){
            return DateLDM;
        }
        DateLDM = new Date(1, 1, channee + 1);

        return DateLDM;
    }



    /**
     * Créer une méthode qui renvoie la date de la veille.
     *
     * @return la date de la veille.
     */
    public Date dateDeLaVeille(){
        Date DateEstime = new Date(chjour - 1, chmois, channee);
        if (DateEstime.estValide()){
            return DateEstime;
        }
        DateEstime = new Date(dernierJourDuMois(channee, chmois - 1), chmois - 1, channee);
        if (DateEstime.estValide()){
            return DateEstime;
        }
        DateEstime = new Date(31, 12, channee - 1);

        return DateEstime;
    }




    /**
     * Obtient le jour de cette date.
     *
     * @return le jour de cette date
     */
    public int getJour(){
        return chjour;
    }

    /**
     * Obtient le mois de cette date.
     *
     * @return le mois de cette date
     */
    public int getMois(){
        return chmois;
    }

    /**
     * Obtient l'année de cette date.
     *
     * @return l'année de cette date
     */
    public  int getAnnee(){
        return channee;
    }


    /**
     * Renvoie une string de cette date
     *
     * @return un str de cette date sous forme jour/mois/année.
     */
    public String toString(){
        return chjour + "/" + chmois + "/" + channee;
    }

}