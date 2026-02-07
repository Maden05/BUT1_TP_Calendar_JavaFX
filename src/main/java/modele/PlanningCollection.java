package modele;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * la class PlanningCollection représente un ensemble de reservations organisées dans plusieurs collections.
 * On peut ajouter de nouvelles reservations, de récuperer des réservations et d'initialiser une
 * structure de données pour stocker les réservations par semaine.
 */
public class PlanningCollection{

    /**Liste des reservations*/
    private ArrayList <Reservation> listReservations;

    /** Ensemble des reservation triées*/
    private TreeSet <Reservation> setReservations;

    /** Structure de données pour stocker les réservations par semaine*/
    private TreeMap<Integer, TreeSet <Reservation>> treeMapReservations;

    /** Constructeur qui instancie les champs*/
    public PlanningCollection(){
        listReservations = new ArrayList<>();
        setReservations = new TreeSet<>();
        treeMapReservations = new TreeMap<>();
    }

    /**
     * La méthode ajout ajoute une reservation à la liste et à l'ensemble des reservations.
     *
     * @param parReservation : la réservation à ajouter.
     */
    public void ajout (Reservation parReservation){
        for (Reservation eltRes: listReservations){
            if (eltRes.compareTo(parReservation) == 0){
                return;
            }
        }
        listReservations.add(parReservation);
        ajoutTreeMapReservations(parReservation);

        setReservations.add(parReservation);

    }

    /**
     * Obtient toutes les réservations pour une date donnée.
     *
     * @param parDateCalendrier : date des reservation recherchées.
     * @return l'ensemble des reservations pour la date.
     */
    public TreeSet <Reservation> geReservations (DateCalendrier parDateCalendrier){
        TreeSet <Reservation> res = new TreeSet<>();
        for(Reservation element : setReservations){
            if (element.getDate().compareTo(parDateCalendrier) == 0 && element.estValide()){
                res.add(element);
            }

        }

        return res;
    }


    /**
     * Obtient toutes les reservations ayant un ititulé spécifique.
     *
     * @param parString : l'intitulé des reservations recherchées.
     * @return l'ensemble des reservations ayant l'intitulé.
     */
    public TreeSet <Reservation> getReservations (String parString){
        TreeSet <Reservation> res = new TreeSet<>();

        for(Reservation element: setReservations){
            if(element.getIntitule().contains(parString)){
                res.add(element);
            }
        }
        return res;

    }



    /** Initialisation de la structure de données pour stocker les reservations par semaine.*/
    public void initTreeMapReservations () {
        treeMapReservations = new TreeMap<>();
        for(Reservation element: setReservations) {
            Date dateElement = element.getDate();
            int week = dateElement.getWeekOfYear();
            if (treeMapReservations.get(week) == null) {
                TreeSet<Reservation> nouvTree = new TreeSet<>();
                nouvTree.add(element);
                treeMapReservations.put(week, nouvTree);
            } else {
                treeMapReservations.get(week).add(element);
            }
        }
    }



    /**
     * Ajoute une reservation à la structure dde données pour stocker les reservation par semaine.
     *
     * @param element la reservation à ajouter.
     */
    public void ajoutTreeMapReservations(Reservation element){
        Date dateElement = element.getDate();
        DateCalendrier dateCal = new DateCalendrier(dateElement.getJour(), dateElement.getMois(), dateElement.getAnnee());
        int week = dateCal.getWeekOfYear();
        if (treeMapReservations == null){
            treeMapReservations = new TreeMap<>();
        }
        if (treeMapReservations.get(week) == null){
            TreeSet <Reservation> nouvtree = new TreeSet<>();
            nouvtree.add(element);
            treeMapReservations.put(week, nouvtree);
        }
        else {
            treeMapReservations.get(week).add(element);
        }
    }


    /** Renvoie les reservations en str.
     *
     * @return une chaine de caractère des reservations.
     */
    public String toString(){
        return //listReservations.size() + " " + listReservations + "\n-----------------\n" +
               // setReservations.size() + " " + setReservations + "\n-----------------\n" +
                treeMapReservations.size() + " " + treeMapReservations;
    }

    /**
     * Méthode qui renvoie les reservations de la semaine en paramètre.
     *
     * @param parNumSemaine la semaine spécifique
     * @return les reservations de la semaine spécifiée.
     */
    public TreeSet <Reservation> getTreeMapReservation(int parNumSemaine) {
        return treeMapReservations.get(parNumSemaine);
    }



}
