package fr.campus.donjons.personnages;

import fr.campus.donjons.equipements.EquipementDefensif;
import fr.campus.donjons.equipements.EquipementOffensif;

public class Guerriers extends Personnage {

    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;


    public Guerriers(String nom) {
        super(nom);
        this.niveauDeVie = 10;
        this.forceAttaque = 15;
        this.equipementOffensif = null;
        this.equipementDefensif = null;
    }

    // Constructeur pour initialiser un guerrier avec nom
    public Guerriers(String nom, int niveauDeVie, int forceAttaque) {
        super(nom);
        this.niveauDeVie = niveauDeVie;
        this.forceAttaque = forceAttaque;
        this.equipementOffensif = null;
        this.equipementDefensif = null;
    }




    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    @Override
    public String toString() {
        return "Guerriers : " + nom + " Vie: " + niveauDeVie + " Force: " + forceAttaque +
                " Equipement Offensif: " + (equipementOffensif != null ? equipementOffensif : "Aucun") +
                " Equipement Defensif: " + (equipementDefensif != null ? equipementDefensif : "Aucun");
    }
}
