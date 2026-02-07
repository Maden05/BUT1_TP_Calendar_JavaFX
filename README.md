# Projet Calendrier et Gestion de Réservations

## Description
Ce projet est une application JavaFX de gestion de planning.  
Il permet de visualiser un calendrier, de créer des réservations de cours à des dates et horaires précis, et d’afficher les réservations par semaine.  
L’application empêche les doublons horaires pour une même date et offre une navigation intuitive entre les mois et les années.

## Fonctionnalités
- Affichage d’un calendrier interactif (mois/année)
- Formulaire pour saisir un cours avec date et plage horaire
- Visualisation des réservations par semaine dans un tableau
- Validation pour empêcher les doublons de réservations à la même heure
- Navigation mois/mois et premier/dernier mois
- Mise à jour dynamique des vues après ajout de réservation

## Structure du projet
- `vue/` : contient toutes les classes JavaFX pour l’interface graphique
    - `VBoxCalendrier.java` : calendrier interactif
    - `GridPaneFormulaireReservation.java` : formulaire de réservation
    - `VBoxAffichagePlanning.java` : affichage des réservations par semaine
    - `HBoxRoot.java` : conteneur principal
    - `Projet2Application.java` : classe principale de lancement
- `modele/` : classes du modèle de données
    - `Reservation.java` : classe représentant une réservation
    - `DateCalendrier.java` : gestion des dates
    - `PlageHoraire.java` : gestion des horaires de cours
    - `PlanningCollection.java` : collection de réservations
    - `ConstantesCalendrier.java` : constantes du calendrier

## Prérequis
- Java 17+
- JavaFX 17+

## Lancement
1. Cloner le projet :
   ```bash
   git clone <repo-url>
