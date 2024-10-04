package fr.campus.donjons.equipements;

import fr.campus.donjons.cases.Case;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.Personnage;

public class Sort extends EquipementOffensif implements Case {

    public Sort(int id, String type, String nom, int puissance) {

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
