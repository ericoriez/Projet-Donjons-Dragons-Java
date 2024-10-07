package fr.campus.donjons.cases;

import fr.campus.donjons.personnages.Personnage;

/**
 * La classe Ennemi représente un ennemi sur une case du plateau.
 * Chaque ennemi a des points de vie et une force d'attaque qui peuvent être utilisés dans les combats.
 */
public class Ennemi implements Case {

    private int pointsDeVie;
    private int force;

    /**
     * Crée un nouvel ennemi avec des points de vie et une force d'attaque par défaut.
     */
    public Ennemi() {
        this.pointsDeVie = 30; // Par exemple, chaque ennemi commence avec 10 points de vie
        this.force = 3;        // Chaque ennemi a une force de 3 par défaut
    }

    /**
     * Interagit avec le personnage.
     * Cela peut être utilisé pour déclencher un combat ou simplement infliger des dégâts fixes.
     *
     * @param personnage Le personnage qui interagit avec l'ennemi.
     */
    @Override
    public void interagir(Personnage personnage) {
        System.out.println("Un ennemi apparait avec " + pointsDeVie + " points de vie !");
        // Appeler la logique de combat ici, par exemple dans la classe Partie
    }

    /**
     * Diminue les points de vie de l'ennemi lorsque celui-ci est attaqué.
     *
     * @param degats Les dégâts infligés à l'ennemi.
     */
    public void diminuerPointsDeVie(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0; // Les points de vie ne peuvent pas être négatifs
        }
    }

    /**
     * Retourne les points de vie actuels de l'ennemi.
     *
     * @return Les points de vie de l'ennemi.
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Retourne la force d'attaque de l'ennemi.
     *
     * @return La force d'attaque.
     */
    public int getForce() {
        return force;
    }

    /**
     * Vérifie si l'ennemi est encore vivant.
     *
     * @return {@code true} si l'ennemi est vivant, sinon {@code false}.
     */
    public boolean isVivant() {
        return pointsDeVie > 0;
    }
}
