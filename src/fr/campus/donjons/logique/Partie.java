
package fr.campus.donjons.logique;
import fr.campus.donjons.cases.CasesEquipement;
import fr.campus.donjons.cases.Case;

import fr.campus.donjons.equipements.EquipementOffensif;

import fr.campus.donjons.personnages.Personnage;

import java.util.Random;



public class Partie {

    private Personnage personnage;
    private Plateau plateau;
    private CasesEquipement casesEquipement = new CasesEquipement(); // Instance de gestion des équipements

    public Partie(Personnage personnage, Plateau plateau) {
        this.personnage = personnage;
        this.plateau = plateau;
    }

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

    private int lancerDes() {
        Random random = new Random();
        int de1 = random.nextInt(6) + 1;
        int de2 = random.nextInt(6) + 1;
        System.out.println("Vous avez lancé les dés et obtenu : " + de1 + " et " + de2);
        int totalDes = de1 + de2;
        System.out.println("Total des deux dés : " + totalDes);
        return totalDes;
    }

    private void jouerUnTour() throws PersonnageHorsPlateauExeption{
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

        System.out.println(personnage);

        if (personnage.getNiveauDeVie() <= 0) {
            System.out.println("Le personnage est mort !");
        }

        System.out.println("========== Fin du tour ================\n");
    }

    private void determinerFinDePartie() {
        if (personnage.getNiveauDeVie() == 0) {
            System.out.println("Le personnage est mort.");
        } else if (plateau.getPositionJoueur() >= plateau.getTaille()) {
            System.out.println("Félicitations ! Vous avez gagné !");
        }
    }
}
