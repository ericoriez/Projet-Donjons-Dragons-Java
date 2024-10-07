package fr.campus.donjons.logique;

import fr.campus.donjons.db.HeroRepository;
import fr.campus.donjons.personnages.GuerrierSpecial;
import fr.campus.donjons.personnages.Guerriers;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.Personnage;
import java.sql.SQLException;
import java.util.Scanner; // Importation de la classe Scanner pour gérer les entrées utilisateur

/**
 * La classe Menu gère les différents menus du jeu Donjons & Dragons,
 * permettant de créer, choisir et démarrer une partie avec un personnage.
 */
public class Menu {

    /**
     * Scanner pour lire les entrées utilisateur.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Repository pour la gestion des héros (création, récupération, etc.).
     */
    private HeroRepository heroRepository = new HeroRepository();

    /**
     * Affiche le menu d'accueil du jeu.
     */
    public void afficherMenuAccueil() {
        System.out.println("Bienvenue dans le jeu Donjons & Dragons !");
        System.out.println("1. Créer ou Choisir un personnage");
        System.out.println("2. Quitter");
    }

    /**
     * Affiche le menu de création ou de choix de personnage.
     */
    public void afficherMenuCreationPersonnage() {
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Choisir un personnage existant");
        System.out.println("3. Quitter");
    }

    /**
     * Affiche le menu de la partie pour démarrer ou quitter le jeu.
     */
    public void afficherMenuPartie() {
        System.out.println("1. Démarrer la partie");
        System.out.println("2. Quitter");
    }

    /**
     * Permet de créer un nouveau personnage ou de choisir un personnage existant.
     *
     * @return Le personnage créé ou choisi par l'utilisateur, ou {@code null} en cas d'erreur ou de choix de quitter.
     */
    public Personnage creerOuChoisirPersonnage() {
        afficherMenuCreationPersonnage();  // Affiche le menu de création ou choix du personnage
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        switch (choix) {
            case 1:
                // Création d'un nouveau personnage
                System.out.println("Choisissez un type de personnage : 1 pour Guerrier, 2 pour Magicien, 3 pour Guerrier Special.");
                int typeChoix = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne

                System.out.println("Entrez le nom du personnage :");
                String nom = scanner.nextLine();

                Personnage personnage;
                if (typeChoix == 1) {
                    personnage = new Guerriers(nom);
                } else if (typeChoix == 2) {
                    personnage = new Magiciens(nom);
                } else if (typeChoix == 3) {
                    personnage = new GuerrierSpecial(nom);
                } else {
                    System.out.println("Choix invalide");
                    return null;
                }

                heroRepository.createHero(personnage);
                return personnage;

            case 2:
                // Choisir un personnage existant
                try {
                    heroRepository.getAllHeroes();  // Afficher tous les personnages disponibles
                } catch (SQLException e) {
                    System.out.println("Erreur lors de la récupération des héros : " + e.getMessage());
                    e.printStackTrace();
                    return null;  // Retourne null en cas d'erreur
                }

                System.out.println("Entrez l'ID du personnage que vous voulez choisir :");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne

                // Récupérer le personnage avec l'ID spécifié
                Personnage personnageExistant = heroRepository.getHeroById(id);
                if (personnageExistant != null) {
                    return personnageExistant;
                } else {
                    System.out.println("Personnage non trouvé avec l'ID : " + id);
                    return null;
                }

            case 3:
                System.out.println("Quitter...");
                return null;

            default:
                System.out.println("Choix non valide");
                return null;
        }
    }

    /**
     * Affiche les informations du personnage donné.
     *
     * @param personnage Le personnage dont les informations doivent être affichées.
     */
    public void afficherPersonnage(Personnage personnage) {
        // Utilise la méthode toString() du personnage pour afficher ses infos
        System.out.println(personnage.toString());
    }
}