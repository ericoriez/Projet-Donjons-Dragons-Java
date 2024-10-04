package fr.campus.donjons.personnages;

import fr.campus.donjons.equipements.EquipementDefensif;
import fr.campus.donjons.equipements.EquipementOffensif;

public abstract class Personnage {
    // Attributs
    protected int id;
    protected String nom;
    protected int niveauDeVie;
    protected int forceAttaque;
    protected EquipementOffensif equipementOffensif;
    protected EquipementDefensif equipementDefensif;
    // Constructeur avec nom
    public Personnage(String nom) {
        this.nom = nom;
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

    public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
  }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }




    // Méthode toString pour afficher les informations du personnage

    public String toString() {
        return " Personnage :" +
        " Nom: " + nom +
        " Niveau de vie: " + niveauDeVie +
        " Force d'attaque: " + forceAttaque +
        " Equipement Offensif: " + equipementOffensif  +
        " Equipement Defensif: " + equipementDefensif;
    }
}
