package modele;


/**
 * La class Horaire représente un horaire avec des précision au quart d'heure.
 * Elle permet de manipuler es hoarires en heures et en quart d'heure.
 */
public class Horaire {

    /** L'heure de l'horaire*/
    private int heure;

    /** Le quart d'heure de l'horaire*/
    private int quartHeure;


    /**
     * Un constructeur pour créer une nouvelle instance d'Horaire avec une heure et un quart d'heure spécifiés.
     *
     * @param parHeure l'heure.
     * @param parQuartHeure le quart d'heure.
     */
    public Horaire (int parHeure, int parQuartHeure){
        heure = parHeure;
        quartHeure = parQuartHeure;
    }


    /**
     * Crer une méthode qui convertit l'horaire en minute.
     *
     * @return l'horaire en minute.
     */
    public int toMinutes () {
        return heure * 60 + quartHeure;
    }


    /**
     * Accesseur permettant d'obtenir l'heure de l'horaire
     *
     * @return l'heure
     */
    public int getHeure () {
        return heure;
    }


    /**
     * Accesseur permettant d'obtenir le quart d'heure de l'horaire
     *
     * @return le quart d'heure
     */
    public int getQuartHeure () {
        return quartHeure;
    }


    /**
     * Définit l'heure de l'horaire
     *
     * @param parHeure la nouvelle heure.
     */
    public void setHeure (int parHeure) {
        heure = parHeure;
    }


    /**
     * Définit le quart d'heure de l'horaire.
     *
     * @param parQuartHeure le nouveau quart d'heure.
     */
    public void setQuartHeure (int parQuartHeure) {
        quartHeure = parQuartHeure;
    }


    /**
     * Renvoie un string de cet horaire.
     *
     * @return un str de l'horaire heure et quart d'heure.*/
    public String toString () {
        return heure + "h" + quartHeure;
    }
}
