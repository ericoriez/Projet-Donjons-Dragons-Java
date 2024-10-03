package fr.campus.donjons.personnages;

import fr.campus.donjons.equipements.EquipementDefensif;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.equipements.Philtre;
import fr.campus.donjons.equipements.Sort;

public class Magiciens extends Personnage {
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;


    public Magiciens(String nom) {
        super(nom);
        this.niveauDeVie = 7;
        this.forceAttaque = 15;
        this.equipementOffensif = new Sort(1," Sort ", "Boule de feu", 18);
        this.equipementDefensif = new Philtre(" Philtre ", "Potion", 15);

    }
    public Magiciens(String nom, int niveauDeVie, int forceAttaque) {
        super(nom);
        this.niveauDeVie = niveauDeVie;
        this.forceAttaque = forceAttaque;
        this.equipementOffensif = new Sort(1," Sort ", "Boule de feu", 18);
        this.equipementDefensif = new Philtre(" Philtre ", "Potion", 15);

    }


    public void SetEquipementOffensif(EquipementOffensif equipementOff){
        this.equipementOffensif = equipementOff;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }



    public String toString() {
        return "Magiciens : " + nom + " Vie: " + niveauDeVie + " Force: " + forceAttaque + " Equipement Offensif: " + equipementOffensif + " Equipement Defensif: " + equipementDefensif;
    }
}
