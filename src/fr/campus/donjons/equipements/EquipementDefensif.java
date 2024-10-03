package fr.campus.donjons.equipements;

public class EquipementDefensif {
    protected String nom;
    protected int defense;
    protected  String type;

    // Constructeur
    public EquipementDefensif(String type, String nom, int defense) {
        this.type = type;
        this.nom = nom;
        this.defense = defense;
    }

    // Getters Setters
    public String getNom() {
        return nom;
    }
    public int getNiveauDefense() {
        return defense;
    }
    public String getType() {
        return type;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNiveauDefense(int niveauDefense) {
        this.defense = niveauDefense;
    }
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
//        return type + nom + " (Puissance : " + niveauDefense + ")";
        return this.getClass().getSimpleName() + nom + " (Puissance : " + defense + ")";
    }
}