package modele;

/**
 * Cette interface définit plusieurs constantes liées à certain éléments du calendrier comme les jours de la semaine,
 * les mois, les heures, les minutes et les niveaux de compétences
 */
public interface ConstantesCalendrier {


    /** Tableau contenant les jours de la semaine.*/
    final String [] JOURS_SEMAINE = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};


    /** Tableau contenant les mois de l'année */
    final String [] MOIS = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};


    /** Tableau contenant les abréviations des jours de la semaine.*/
    final String [] JOURS_SEMAINE_ABR = {"lu","ma","me","je","ve","sa","di"};


    /** Tableau contenant les heures.*/
    final String [] HEURES = {"07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22"};


    /** Tableau contenant les minutes.*/
    final String [] MINUTES = {"00","15","30","45"};



    /** Tableau contenant les niveaux de compétences.*/
    final String [] NIVEAUX = {"débutant", "moyen", "avancé", "expert"};
}
