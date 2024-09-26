import java.util.Random;

public class Plateau {

    private static final int TAILLE_PLATEAU = 64;
    private int positionJoueur = 1;

    public void lancerPartie(Personnage personnage) throws PersonnageHorsPlateauExeption {
        Random random = new Random();

        System.out.println("Début de la partie ! Le joueur commence sur la case 1.");
        System.out.println(personnage);
        // Boucle de jeu jusqu'à ce que le joueur atteigne ou dépasse la dernière case
        while (positionJoueur < TAILLE_PLATEAU) {

            System.out.println("\n==========================");

            // Lancer deux dés
            int de1 = random.nextInt(6) + 1;
            int de2 = random.nextInt(6) + 1;

            // Vérifier si le personnage est une instance de GuerrierSpecial
            if (personnage instanceof GuerrierSpecial) {
                GuerrierSpecial guerrierSpecial = (GuerrierSpecial) personnage;
                guerrierSpecial.regenVie(de1, de2);  // Utiliser la méthode spéciale
            }


            // Mettre à jour la position du joueur
            int deplacement = de1 + de2;
            System.out.println("Vous avez lancé les dés et obtenu : " + deplacement);
            positionJoueur += deplacement;

            // Vérifier si le joueur dépasse la dernière case
            if (positionJoueur > TAILLE_PLATEAU) {
                throw new PersonnageHorsPlateauExeption("Le personnage a dépassé la case finale !");
            }

            // Afficher l'avancement du joueur
            System.out.println("Vous avancez de " + deplacement + " cases.");
            System.out.println("Vous êtes maintenant sur la case " + positionJoueur + " / " + TAILLE_PLATEAU);

            // Ajouter une pause pour rendre le déplacement plus visible
            try {
                Thread.sleep(2000);  // Pause de 2 seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("==========================\n");


            // Vérifier si le joueur a atteint la fin du plateau
            if (positionJoueur == TAILLE_PLATEAU) {
                System.out.println("Félicitations ! Vous avez gagné !");
                break;  // Sortir de la boucle
            }
        }
    }
}
