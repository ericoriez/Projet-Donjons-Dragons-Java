package fr.campus.donjons.equipements;

import fr.campus.donjons.logique.Case;
import fr.campus.donjons.personnages.Personnage;

public class Arme extends EquipementOffensif implements Case {
    public Arme(int id, String type, String nom, int puissance) {
        super(id, type, nom, puissance);
    }

    @Override
    public void interagir(Personnage personnage) {
        System.out.println(" Vous trouver une arme ! Votre force d'attaque augmente. ");
        personnage.setForceAttaque(personnage.getForceAttaque() + 5);
    }

    @Override
    public String toString() {
        return type +" [Nom : " + nom + ", Puissance : " + puissance + "]";

    }
}
