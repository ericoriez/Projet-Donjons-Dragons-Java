package fr.campus.donjons.equipements;

public class Bouclier extends EquipementDefensif {

    public Bouclier(int id, String type, String nom, int defense){

        super(type, nom, defense);
    }

    @Override
    public String toString() {
        return type + " [Nom : " + nom + ", Defense : " + defense + "]";
    }
}
