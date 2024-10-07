package fr.campus.donjons.personnages;

import fr.campus.donjons.equipements.EquipementOffensif;

/**
 * La classe Personnage représente un personnage dans le jeu Donjons & Dragons.
 * Chaque personnage a des points de vie, une force d'attaque, et peut être équipé d'équipements offensifs.
 */
public abstract class Personnage {

    // Attributs
    protected int id;
    protected String nom;
    protected int niveauDeVie;
    protected int forceAttaque;
    protected EquipementOffensif equipementOffensif;

    // Constructeur avec nom
    public Personnage(String nom) {
        this.nom = nom;
        this.niveauDeVie = 10; // Valeur par défaut du niveau de vie
        this.forceAttaque = 10; // Valeur par défaut de la force d'attaque
    }

    // Getters et Setters pour chaque attribut
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveauDeVie() {
        return niveauDeVie;
    }

    public void setNiveauDeVie(int niveauDeVie) {
        this.niveauDeVie = niveauDeVie;
    }

    public int getForceAttaque() {
        return forceAttaque;
    }

    public void setForceAttaque(int forceAttaque) {
        this.forceAttaque = forceAttaque;
    }

    public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
    }

    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    // Méthode pour diminuer les points de vie du personnage
    public void diminuerPointsDeVie(int degats) {
        this.niveauDeVie -= degats;

        if (this.niveauDeVie < 0) {
            this.niveauDeVie = 0; // Les points de vie ne peuvent pas être négatifs
        }

        System.out.println(nom + " a perdu " + degats + " points de vie. Niveau de vie restant : " + niveauDeVie);
    }

    // Méthode pour attaquer un ennemi
    public int attaquer() {
        int forceTotale = forceAttaque;

        // Ajouter la puissance de l'équipement offensif s'il y en a un
        if (equipementOffensif != null) {
            forceTotale += equipementOffensif.getPuissance();
            System.out.println(nom + " attaque avec " + equipementOffensif.getNom() + " !");
        } else {
            System.out.println(nom + " attaque sans équipement offensif !");
        }

        System.out.println(nom + " attaque avec une force de " + forceTotale);
        return forceTotale;
    }

    // Méthode toString pour afficher les informations du personnage
    @Override
    public String toString() {
        return "Personnage : " +
                "Nom : " + nom +
                ", Niveau de vie : " + niveauDeVie +
                ", Force d'attaque : " + forceAttaque +
                ", Equipement Offensif : " + (equipementOffensif != null ? equipementOffensif.getNom() : "Aucun");
    }
}