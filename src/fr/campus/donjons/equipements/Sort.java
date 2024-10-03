package fr.campus.donjons.equipements;

import fr.campus.donjons.logique.Case;
import fr.campus.donjons.personnages.Personnage;

public class Sort extends EquipementOffensif implements Case {

    public Sort(int id, String type, String nom, int puissance) {

        super(id, type, nom, puissance);
    }

    @Override
    public void interagir(Personnage personnage) {
        System.out.println("Vous trouver un sort : " + nom + " ! La puissance d'attaque du magicien augmente. ");
        if(personnage instanceof  fr.campus.donjons.personnages.Magiciens){
            ((fr.campus.donjons.personnages.Magiciens) personnage).SetEquipementOffensif(this);
        }
    }


    @Override
    public String toString() {
        return type +" [Nom : " + nom + ", Puissance : " + puissance + "]";
    }
}
