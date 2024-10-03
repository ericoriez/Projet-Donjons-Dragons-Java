package fr.campus.donjons.equipements;

import fr.campus.donjons.logique.Case;
import fr.campus.donjons.personnages.Personnage;

public class PotionStandard extends Potions implements Case{

    public PotionStandard(String nom, int lvlVie) {
        super(nom, lvlVie);
    }

    @Override
    public void interagir(Personnage personnage) {
        System.out.println("Vous buvez la potion " + getNom() + " ! Vous regagnez " + getLvlVie() + " points de vie.");
        personnage.setNiveauDeVie(personnage.getNiveauDeVie() + getLvlVie());
    }

//    @Override
//    public String toString() {
//        return "Potion : "
//    }


}
