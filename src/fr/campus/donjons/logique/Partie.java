package fr.campus.donjons.logique;

import fr.campus.donjons.cases.CasesEquipement;
import fr.campus.donjons.cases.Case;
import fr.campus.donjons.cases.Ennemi;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.personnages.Personnage;
import java.util.Random;

/**
 * La classe Partie gère le déroulement d'une partie de jeu, incluant le personnage, le plateau,
 * les dés, et les interactions avec les cases du plateau.
 */
public class Partie {

    /**
     * Le personnage participant à la partie.
     */
    private Personnage personnage;

    /**
     * Le plateau sur lequel la partie se joue.
     */
    private Plateau plateau;

    /**
     * Instance de gestion des équipements.
     */
    private CasesEquipement casesEquipement = new CasesEquipement();

    /**
     * Crée une nouvelle partie avec un personnage et un plateau donnés.
     *
     * @param personnage Le personnage participant à la partie.
     * @param plateau Le plateau sur lequel la partie se joue.
     */
    public Partie(Personnage personnage, Plateau plateau) {
        this.personnage = personnage;
        this.plateau = plateau;
    }

    /**
     * Lance la partie, gère les tours jusqu'à la fin de la partie.
     */
    public void lancerPartie() {
        System.out.println("Début de partie !");
        try {
            while (personnage.getNiveauDeVie() > 0 && plateau.getPositionJoueur() < plateau.getTaille()) {
                jouerUnTour();
            }
        } catch (PersonnageHorsPlateauExeption e) {
            System.out.println(e.getMessage());
        }
        determinerFinDePartie();
    }

    /**
     * Lance deux dés et retourne le total des deux valeurs obtenues.
     *
     * @return La somme des deux dés lancés.
     */
    private int lancerDes() {
        Random random = new Random();
        int de1 = random.nextInt(6) + 1;
        int de2 = random.nextInt(6) + 1;
        System.out.println("Vous avez lancé les dés et obtenu : " + de1 + " et " + de2);
        int totalDes = de1 + de2;
        System.out.println("Total des deux dés : " + totalDes);
        return totalDes;
    }

    /**
     * Joue un tour de la partie, incluant le lancer des dés, le déplacement du personnage,
     * et les interactions avec la case actuelle.
     *
     * @throws PersonnageHorsPlateauExeption Si le personnage dépasse la case finale du plateau.
     */
    private void jouerUnTour() throws PersonnageHorsPlateauExeption {
        System.out.println("\n========== Lancer de Dés ================");

        int deplacement = lancerDes();
        System.out.println("Vous avancez de " + deplacement + " cases.");

        // Vérifier si le déplacement dépasse la taille du plateau
        if (plateau.getPositionJoueur() + deplacement >= plateau.getTaille()) {
            throw new PersonnageHorsPlateauExeption("Le personnage a dépassé la case finale ! Fin du jeu");
        }

        plateau.avancerPersonnage(deplacement);

        System.out.println("Vous êtes maintenant sur la case " + plateau.getPositionJoueur() + " / " + plateau.getTaille());
        Case caseActuelle = plateau.getCaseActuelle();
        caseActuelle.interagir(personnage);

        if (caseActuelle instanceof EquipementOffensif) {
            casesEquipement.gererInteractionEquipement(personnage, (EquipementOffensif) caseActuelle);
        }

        if (caseActuelle instanceof Ennemi) {
            // Lancer la logique de combat
            Ennemi ennemi = (Ennemi) caseActuelle;
            gererCombat(ennemi);
        }

        System.out.println(personnage);

        if (personnage.getNiveauDeVie() <= 0) {
            System.out.println("Le personnage est mort !");
        }

        System.out.println("========== Fin du tour ================\n");
    }

    /**
     * Détermine la fin de la partie en fonction de l'état du personnage et de sa position sur le plateau.
     */
    private void determinerFinDePartie() {
        if (personnage.getNiveauDeVie() == 0) {
            System.out.println("Le personnage est mort.");
        } else if (plateau.getPositionJoueur() >= plateau.getTaille()) {
            System.out.println("Félicitations ! Vous avez gagné !");
        }
    }


    private void gererCombat(Ennemi ennemi) {
        System.out.println("Combat engagé avec un ennemi !");

        // Le personnage attaque l'ennemi
        int forceAttaque = personnage.attaquer();
        ennemi.diminuerPointsDeVie(forceAttaque);
        System.out.println("Vous avez infligé " + forceAttaque + " points de dégâts à l'ennemi.");

        // Vérifier si l'ennemi est mort
        if (!ennemi.isVivant()) {
            System.out.println("Vous avez vaincu l'ennemi !");
            plateau.retirerEnnemi(plateau.getPositionJoueur());
        } else {
            // L'ennemi riposte
            int forceEnnemi = ennemi.getForce();
            personnage.diminuerPointsDeVie(forceEnnemi);  // L'ennemi attaque le personnage ici
            System.out.println("L'ennemi vous a infligé " + forceEnnemi + " points de dégâts.");

            // Vérifier si le personnage est mort
            if (personnage.getNiveauDeVie() <= 0) {
                System.out.println("Vous êtes mort !");
            } else {
                System.out.println("L'ennemi s'enfuit après vous avoir frappé.");
            }
        }
    }
}