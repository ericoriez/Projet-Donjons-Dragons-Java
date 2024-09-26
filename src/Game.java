import java.util.Scanner; // Importation de la classe Scanner pour gérer les entrées utilisateur

public class Game {
    private Menu menu = new Menu(); // Instance de la classe Menu pour gérer l'interface utilisateur
    private Personnage personnage;  // Le personnage qui sera créé par l'utilisateur
    private boolean personnageCree = false;  // Booléen pour savoir si un personnage a déjà été créé

    // Méthode principale qui gère le déroulement du jeu
    public void start() {
        boolean continuer = true;  // Boucle principale pour gérer si l'utilisateur continue ou quitte le jeu
        Scanner scanner = new Scanner(System.in);  // Scanner pour lire les entrées utilisateur

        // Boucle principale du jeu
        while (continuer) {
            // Si aucun personnage n'a été créé, afficher le menu de création de personnage
            if (!personnageCree) {
                menu.afficherMenuCreationPersonnage();  // Afficher le menu de création
                int choix = scanner.nextInt();  // Lire le choix de l'utilisateur
                scanner.nextLine();  // Consommer la nouvelle ligne

                // Gérer le choix de l'utilisateur
                switch (choix) {
                    case 1:
                        personnage = menu.creerPersonnage();  // Créer un personnage
                        menu.afficherPersonnage(personnage);  // Afficher les informations du personnage
                        personnageCree = true;  // Marquer qu'un personnage a été créé
                        break;
                    case 2:
                        continuer = false;  // Quitter le jeu
                        System.out.println("Quitter le jeu...");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } else {
                // Si un personnage a été créé, afficher le menu pour démarrer ou quitter la partie
                menu.afficherMenuPartie();  // Afficher le menu de la partie
                int choix = scanner.nextInt();  // Lire le choix de l'utilisateur
                scanner.nextLine();  // Consommer la nouvelle ligne

                // Gérer le choix de l'utilisateur
                switch (choix) {
                    case 1:
                        menu.lancerPartie(personnage);  // Lancer la partie avec le personnage créé
                        personnageCree = false;  // Réinitialiser pour revenir à la création de personnage
                        break;
                    case 2:
                        continuer = false;  // Quitter le jeu
                        System.out.println("Quitter le jeu...");
                        break;
                    default:
                        System.out.println("Choix non valide, veuillez réessayer.");
                }
            }
        }
    }
}
