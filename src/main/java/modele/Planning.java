    package modele;

    /**
     * La class Planning représente un ensemble de reservation organisées dans un tableau.
     * On peut ajouter de nouvelles reservations, de rechercher des reservations par date,
     * de trier les reservations par ordre chronologique.
     */
    public class Planning {

        /** le tableau de reservation */
        Reservation [] tableauR;

        /** la taille max du tableau */
        final int tailleT;


        /**
         * Le constructeur créer de nouvelle instance de Planning avec une taille spécifique.
         *
         * @param parTaille taille max du tableau
         */
        public Planning(int parTaille){
            tableauR = new Reservation[parTaille];
            tailleT = parTaille;
        }


        /**
         * La méthode ajout ajoute une nouvelle redservaton au tableau.
         *
         * @param parnewRes la reservation à ajouter au tableau.
         * @throws ExceptionPlanning Si la reservation n'est pas valide ou si le tableau est plein
         */
        public void ajout(Reservation parnewRes) throws ExceptionPlanning{
            if (!parnewRes.estValide()){
                throw new ExceptionPlanning(0);
            }

            if (tableauR[tableauR.length -1] != null){
                throw new ExceptionPlanning(1);
            }
            for(int i=0; i < tailleT; i++){
                if (tableauR[i] == null){
                    tableauR[i] = parnewRes;
                    break;
                }
                if (parnewRes.compareTo(tableauR[i]) == 0){
                    throw new ExceptionPlanning(2);
                }

            }
        }


        /**
         * Recupère la reservation correspondante à une date donnée.
         *
         * @param parDate la date de la reservation recherchée .
         * @return la reservation correspondante ou null si aucune reservation n'est trouvé.
         */
        public Reservation getReservation(Date parDate){
            for(int i = 0; i < tailleT; i ++){
                if (tableauR[i].getDate() == parDate){
                    return tableauR[i];
                }
            }
            return null; // on ne l'a pas trouvé
        }


        /**
         * Récupère toute les reservation à une date donnée.
         *
         * @param parDate la date des reservations recherchées
         * @return tableau contenant toutes les reservation de la date précise.
         */
        public Reservation [] getReservations(Date parDate){
            Reservation [] tableauRetour = new Reservation[tailleT];
            for(int i = 0; i < tailleT; i ++){
                if (tableauR[i].getDate() == parDate){
                    tableauRetour[i] = tableauR[tailleT];
                }
            }
            return tableauRetour;
        }


        /**
         * Méthode qui trouve la reservation la plus ancienne.
         *
         * @param parDebut indice de début
         * @param parFin indice de fin
         * @return L'indice de la reservation la plus ancienne.
         */
        public int plusAncienneReservation(int parDebut, int parFin){
            int indicePlusAncienneResa = parDebut;
            for (int i=parDebut; i < parFin; i++){
                if (tableauR[indicePlusAncienneResa].compareTo(tableauR[i]) > 0){
                    indicePlusAncienneResa = i;
                }
            }
            return  indicePlusAncienneResa;
        }


        /**
         * Trier les reservations par ordre chronologique.*/
        public void triSelection(){

            for(int indiceElement = 0; indiceElement < tailleT; indiceElement++){

                if (tableauR[indiceElement] == null){ // on vérifie si on est à la fin du tableau
                    break;
                }

                // L'indice de l'élément le plus petit que l'on ait trouvé
                // initié au premier élément en le comparant aux autres
                int indicePetit = indiceElement;

                for(int autreIndice = indiceElement; autreIndice < tailleT; autreIndice ++){
                    if (tableauR[autreIndice] == null) { // on vérifie si on est à la fin du tableau
                        break;
                    }
                    if (tableauR[indicePetit].compareTo(tableauR[indiceElement]) > 0) {
                        indicePetit = autreIndice;
                    }
                }
                Reservation element = tableauR[indiceElement];
                tableauR[indiceElement] = tableauR[indicePetit];
                tableauR[indicePetit] = element;
            }
        }

        /**
         * Renvoie un string du planning.
         *
         * @return une chaine de caractère représentant toutes les réservations du planning.
         */
        public String toString(){
            String monReturn = "";
            for (int i=0; i < tailleT; i++){
                if(tableauR[i] != null)
                    monReturn += tableauR[i].toString();
            }
            return monReturn;

        }
    }
