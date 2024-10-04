package fr.campus.donjons.equipements;

import fr.campus.donjons.cases.Case;
import fr.campus.donjons.personnages.Personnage;

public class Arme extends EquipementOffensif implements Case {
    public Arme(int id, String type, String nom, int puissance) {

        super(id, type, nom, puissance);
    }

    @Override
    public void interagir(Personnage personnage) {
    }

    @Override
    public String toString() {
        return type +" [Nom : " + nom + ", Puissance : " + puissance + "]";

    }
}
