package fr.campus.donjons.logique;

/**
 * La classe Main est le point d'entrée du jeu Donjons & Dragons.
 * Elle initialise une instance de la classe Game et lance la partie.
 */
public class Main {

    /**
     * Méthode principale qui démarre le programme.
     *
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
