package fr.campus.donjons.cases;

import fr.campus.donjons.personnages.Personnage;

public class Ennemi  implements Case {
    @Override
    public void interagir(Personnage personnage) {
        System.out.println(" Un ennemi apparait ! Vous perdez 3 PV. ");
        personnage.setNiveauDeVie(personnage.getNiveauDeVie() - 3);
    }
}
