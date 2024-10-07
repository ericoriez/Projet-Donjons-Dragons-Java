package fr.campus.donjons.personnages;

import fr.campus.donjons.equipements.EquipementDefensif;
import fr.campus.donjons.equipements.EquipementOffensif;


public class Magiciens extends Personnage {
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;


    public Magiciens(String nom) {
        super(nom);
        this.niveauDeVie = 7;
        this.forceAttaque = 15;
        this.equipementOffensif = null;
        this.equipementDefensif = null;

    }
    public Magiciens(String nom, int niveauDeVie, int forceAttaque) {
        super(nom);
        this.niveauDeVie = niveauDeVie;
        this.forceAttaque = forceAttaque;
        this.equipementOffensif = null;
        this.equipementDefensif = null;

    }


    public void SetEquipementOffensif(EquipementOffensif equipementOff){
        this.equipementOffensif = equipementOff;
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
