package modele;


/**
 * La class ExceptionPlanning représente créer excpetion pour gérer des erreurs liées au planning.
 * Elle hérite de la classe Exception.*/
public class ExceptionPlanning extends Exception {

    /** Un champ pour le code erreur liée à l'exception */
    private int codeErreur;



    /**
     * Le constructeur créer une nouvelle instance d'ExceptionPlanning avec un message d'erreur.
     *
     * @param parMessage Le message d'erreur.
     */
    public ExceptionPlanning (String parMessage){
        super(parMessage);
    }


    /**
     * Un constructeur pour créer une nouvelle d'ExceptionPlanning avec un code erreur.
     *
     * @param parCodeErreur Le code erreur.
     */
    public ExceptionPlanning(int parCodeErreur){
        codeErreur = parCodeErreur;
    }


    /**
     * Accesseur permettant d'obtenir le code d'erreur associé à l'exception.
     *
     * @return le code erreur.
     */
    public int getCodeErreur(){
        return codeErreur;
    }
}
