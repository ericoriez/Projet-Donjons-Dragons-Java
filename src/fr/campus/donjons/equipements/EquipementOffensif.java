package fr.campus.donjons.equipements;

public abstract class EquipementOffensif {
    protected int id;  // Ajouter un identifiant unique pour l'équipement
    protected String type;
    protected String nom;
    protected int puissance;

    // Constructeur
    public EquipementOffensif(int id, String type, String nom, int puissance) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.puissance = puissance;
    }

    // Getter pour l'ID
    public int getId() {
        return id;
    }

    // Setters et Getters pour les autres attributs (type, nom, puissance)
    public String getNom() {
        return nom;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getType() {
        return type;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " [Nom : " + nom + ", Puissance : " + puissance + "]";
    }
}
