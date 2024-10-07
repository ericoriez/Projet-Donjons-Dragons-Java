package fr.campus.donjons.logique;

import fr.campus.donjons.db.HeroRepository;
import fr.campus.donjons.personnages.Personnage;
import java.util.Scanner;

/**
 * La classe Game gère le déroulement global du jeu Donjons & Dragons,
 * incluant la gestion des menus, la création de personnages, et le démarrage de la partie.
 */
public class Game {

    /**
     * Instance de la classe Menu pour gérer les différents menus du jeu.
     */
    private final Menu menu = new Menu();

    /**
     * Instance du repository des héros pour gérer la persistance des personnages.
     */
    private final HeroRepository heroRepository = new HeroRepository();

    /**
     * Plateau de jeu sur lequel se déroule la partie.
     */
    private Plateau plateau;

    /**
     * Le personnage créé ou choisi par l'utilisateur.
     */
    private Personnage personnage;

    /**
     * Méthode principale qui gère le déroulement du jeu.
     * Affiche le menu principal, permet de créer ou choisir un personnage et de démarrer une partie.
     */
    public void start() {
        boolean continuer = true;  // Indicateur pour continuer ou arrêter le jeu
        Scanner scanner = new Scanner(System.in);  // Scanner pour lire les entrées utilisateur

        while (continuer) {
            menu.afficherMenuAccueil();  // Afficher le menu d'accueil
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    personnage = menu.creerOuChoisirPersonnage();  // Créer ou choisir un personnage
                    if (personnage != null) {
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

    /**
     * Démarre la partie en initialisant un plateau et en créant une instance de Partie.
     */
    private void demarrerPartie() {
        System.out.println("La partie commence !");
        plateau = new Plateau();  // Créer un nouveau plateau
        Partie partie = new Partie(personnage, plateau);  // Créer une nouvelle instance de Partie
        partie.lancerPartie();  // Lancer la partie avec le personnage sur le plateau
    }

    /**
     * Affiche le menu de la partie permettant de démarrer ou de quitter la partie.
     *
     * @param scanner Scanner pour lire les entrées utilisateur.
     */
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