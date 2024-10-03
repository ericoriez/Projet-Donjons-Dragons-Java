package fr.campus.donjons.logique;



import fr.campus.donjons.personnages.Personnage;
import fr.campus.donjons.personnages.Guerriers;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.GuerrierSpecial;

import java.util.Scanner;

public class Game {

    private Menu menu = new Menu();  // Instance de la classe Menu
    private Plateau plateau;  // Instance du plateau de jeu
    private Personnage personnage;  // Le personnage créé par l'utilisateur

    // Méthode principale qui gère le déroulement du jeu
    public void start() {
        boolean continuer = true;  // Indicateur pour continuer ou arrêter le jeu
        Scanner scanner = new Scanner(System.in);  // Scanner pour lire les entrées utilisateur

        while (continuer) {
            // Afficher le menu d'accueil une seule fois pour choisir de créer ou de quitter
            menu.afficherMenuAccueil();
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    personnage = menu.creerOuChoisirPersonnage();  // Créer ou choisir un personnage
                    if (personnage != null) {
                        System.out.println("Personnage sélectionné :");
                        menu.afficherPersonnage(personnage);
                        afficherMenuPartie(scanner); // Proposer de démarrer la partie ou quitter
                    }
                    break;
                case 2:
                    continuer = false;  // Quitter le jeu
                    System.out.println("Quitter le jeu...");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    // Méthode pour démarrer la partie
    private void demarrerPartie() {
        System.out.println("La partie commence !");
        plateau = new Plateau();  // Créer un nouveau plateau

        try {
            plateau.lancerPartie(personnage);  // Lancer la partie avec le personnage sur le plateau
        } catch (PersonnageHorsPlateauExeption e) {
            System.out.println(e.getMessage());  // Afficher le message en cas d'exception
        }
    }

    // Méthode pour afficher le menu de la partie (démarrer ou quitter)
    private void afficherMenuPartie(Scanner scanner) {
        boolean partieEnCours = true;

        while (partieEnCours) {
            menu.afficherMenuPartie();
            int choixPartie = scanner.nextInt();
            scanner.nextLine();

            switch (choixPartie) {
                case 1:
                    demarrerPartie();  // Démarrer la partie
                    partieEnCours = false;  // Terminer la partie une fois terminée
                    break;
                case 2:
                    partieEnCours = false;  // Quitter la partie
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix non valide, veuillez réessayer.");
            }
        }
    }
}
