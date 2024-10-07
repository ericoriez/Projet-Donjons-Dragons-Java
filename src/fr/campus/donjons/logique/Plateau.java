package fr.campus.donjons.logique;

import fr.campus.donjons.cases.CaseVide;
import fr.campus.donjons.cases.Case;
import fr.campus.donjons.cases.Ennemi;
import fr.campus.donjons.db.EquipementRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe Plateau représente le plateau de jeu contenant un certain nombre de cases sur lesquelles le joueur peut se déplacer.
 * Le plateau est constitué de cases aléatoires comprenant des ennemis, des équipements ou des cases vides.
 */
public class Plateau {

    /**
     * La taille du plateau (nombre total de cases).
     */
    private static final int TAILLE_PLATEAU = 64;

    /**
     * Liste des cases constituant le plateau.
     */
    private List<Case> cases;

    /**
     * Position actuelle du joueur sur le plateau.
     */
    private int positionJoueur = 0;

    /**
     * Générateur de nombres aléatoires pour générer les cases du plateau.
     */
    private Random random = new Random();

    /**
     * Instance du repository pour récupérer des équipements aléatoires.
     */
    private EquipementRepository equipementRepository = new EquipementRepository();

    /**
     * Crée un nouveau plateau de jeu en générant des cases aléatoires pour chaque position.
     */
    public Plateau() {
        cases = new ArrayList<>();
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            cases.add(genererCaseAleatoire());
        }
    }

    /**
     * Génère une case aléatoire qui peut être une case vide, un ennemi ou un équipement.
     *
     * @return Une instance de {@link Case} aléatoire.
     */
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

    /**
     * Récupère la position actuelle du joueur sur le plateau.
     *
     * @return La position actuelle du joueur.
     */
    public int getPositionJoueur() {
        return positionJoueur;
    }

    /**
     * Récupère la taille du plateau.
     *
     * @return Le nombre total de cases du plateau.
     */
    public int getTaille() {
        return TAILLE_PLATEAU;
    }

    /**
     * Avance le joueur sur le plateau d'un certain nombre de cases.
     *
     * @param deplacement Le nombre de cases à avancer.
     */
    public void avancer(int deplacement) {
        positionJoueur = Math.min(positionJoueur + deplacement, TAILLE_PLATEAU - 1);
    }

    /**
     * Récupère la case actuelle sur laquelle le joueur se trouve.
     *
     * @return La case actuelle.
     */
    public Case getCaseActuelle() {
        return cases.get(positionJoueur);
    }

    /**
     * Avance le personnage sur le plateau d'un certain nombre de cases, en vérifiant qu'il ne dépasse pas la taille du plateau.
     *
     * @param deplacement Le nombre de cases à avancer.
     */
    public void avancerPersonnage(int deplacement) {
        positionJoueur += deplacement;
        // Vérifier si la position dépasse la taille du plateau
        if (positionJoueur >= TAILLE_PLATEAU) {
            positionJoueur = TAILLE_PLATEAU - 1;  // Pour éviter de dépasser la fin du plateau
        }
    }

    /**
     * Définit la position actuelle du joueur sur le plateau.
     *
     * @param positionJoueur La nouvelle position du joueur.
     */
    public void setPositionJoueur(int positionJoueur) {
        this.positionJoueur = positionJoueur;
    }

    /**
     * Retire un ennemi de la case actuelle et le remplace par une case vide.
     *
     * @param position La position de l'ennemi à retirer.
     */
    public void retirerEnnemi(int position) {
        if (position >= 0 && position < TAILLE_PLATEAU && cases.get(position) instanceof Ennemi) {
            cases.set(position, new CaseVide());
        }
    }
}