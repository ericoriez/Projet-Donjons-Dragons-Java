import java.util.Scanner; // Importation de la classe Scanner pour gérer les entrées utilisateur

public class Menu {

    // Initialisation d'un scanner pour lire les entrées utilisateur
    private Scanner scanner = new Scanner(System.in);

    // Méthode pour afficher le menu de création de personnage
    public void afficherMenuCreationPersonnage() {
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Quitter");
    }

    // Méthode pour afficher le menu de la partie (démarrer ou quitter)
    public void afficherMenuPartie() {
        System.out.println("1. Démarrer la partie");
        System.out.println("2. Quitter");
    }

    // Méthode pour créer un nouveau personnage en fonction du choix de l'utilisateur
    public Personnage creerPersonnage() {
        // Demande à l'utilisateur de choisir le type de personnage
        System.out.println("Choisissez un type de personnage : 1 pour Guerrier, 2 pour Magicien, 3 pour Guerrier Special.");
        int choix = scanner.nextInt(); // Lecture du choix de l'utilisateur
        scanner.nextLine(); // Consommer la nouvelle ligne

        // Demande à l'utilisateur d'entrer le nom du personnage
        System.out.println("Entrez votre nom du personnage");
        String nom = scanner.nextLine(); // Lecture du nom du personnage

        // Création du personnage en fonction du choix de l'utilisateur
        Personnage personnage;
        if (choix == 1) {
            personnage = new Guerriers(nom);  // Si choix = 1, création d'un Guerrier
        } else if (choix == 2) {
            personnage = new Magiciens(nom);  // Si choix = 2, création d'un Magicien
        } else if (choix == 3) {
            personnage = new GuerrierSpecial(nom);  // Si choix = 3, création d'un Guerrier spécial
        } else {
            // Si le choix est invalide, afficher un message et retourner null
            System.out.println("Choix invalide");
            return null;
        }

        return personnage;  // Retourne l'objet personnage créé sans lancer la partie immédiatement
    }

    // Méthode pour lancer la partie avec un personnage
    public void lancerPartie(Personnage personnage) {
        Plateau plateau = new Plateau();  // Création d'un plateau de jeu
        try {
            plateau.lancerPartie(personnage);  // Lancer la partie avec le personnage
        } catch (PersonnageHorsPlateauExeption e) {
            // En cas d'exception (personnage hors du plateau), afficher le message d'erreur
            System.out.println(e.getMessage());
        }
    }

    // Méthode pour afficher les informations du personnage
    public void afficherPersonnage(Personnage personnage) {
        // Utilise la méthode toString() du personnage pour afficher ses infos
        System.out.println(personnage.toString());
    }
}
