package fr.campus.donjons.cases;

import fr.campus.donjons.personnages.Personnage;

public class CaseVide implements Case {
    @Override
    public void interagir(Personnage personnage) {
        System.out.println(" Case vide, il ne se passe rien. ");
    }
}
