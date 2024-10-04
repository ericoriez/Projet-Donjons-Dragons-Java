package fr.campus.donjons.logique;

import fr.campus.donjons.cases.CaseVide;

import fr.campus.donjons.cases.Case;
import fr.campus.donjons.cases.Ennemi;

import fr.campus.donjons.db.EquipementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Plateau {
    private static final int TAILLE_PLATEAU = 64;
    private List<Case> cases;
    private int positionJoueur = 0;
    private Random random = new Random();
    private EquipementRepository equipementRepository = new EquipementRepository();

    public Plateau() {
        cases = new ArrayList<>();
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            cases.add(genererCaseAleatoire());
        }
    }

    private Case genererCaseAleatoire() {
        int typeCase = random.nextInt(4);
        switch (typeCase) {
            case 0: return new CaseVide();
            case 1: return new Ennemi();
            case 2: return equipementRepository.getRandomArme();
            case 3: return equipementRepository.getRandomSort();
            default: return new CaseVide();
        }
    }

    // Méthode publique pour récupérer la position du joueur
    public int getPositionJoueur() {
        return positionJoueur;
    }

    // Méthode publique pour récupérer la taille du plateau
    public int getTaille() {
        return TAILLE_PLATEAU;
    }

    public void avancer(int deplacement) {
        positionJoueur = Math.min(positionJoueur + deplacement, TAILLE_PLATEAU - 1);
    }

    public Case getCaseActuelle() {
        return cases.get(positionJoueur);
    }

    public void avancerPersonnage(int deplacement) {
        positionJoueur += deplacement;
        // Vérifiez si la position dépasse la taille du plateau
        if (positionJoueur >= TAILLE_PLATEAU) {
            positionJoueur = TAILLE_PLATEAU - 1;  // Pour éviter de dépasser la fin du plateau
        }
    }

    public void setPositionJoueur(int positionJoueur) {
        this.positionJoueur = positionJoueur;
    }


}
