
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void afficherMenu() {
        System.out.println("Commencer le jeu");
        System.out.println("Quitter");

    }

    public void creePersonnage(){

        System.out.println("Choisissez un personnage 'guerrier' ou 'mage'");
        String type = scanner.nextLine();
        System.out.println("Entrer le nom :");
        String nom = scanner.nextLine();
    }

    public void afficherPersonnage(String nom, String type) {

        System.out.println("Nom du personnage "+ nom + " de type " + type);
        scanner.nextInt();

    }


}