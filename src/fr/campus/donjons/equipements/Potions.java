package fr.campus.donjons.equipements;

public class Potions {

    /////////////////////////////////// Attributs ///////////////////////////////////

    private String nom;
    private int lvlVie;

    ////////////////////////////////// Constructeurs ///////////////////////////////


    public Potions() {

    }
    public Potions(String nom) {
        this.nom = nom;
    }
    public Potions(String nom, int lvlVie){
        this.nom = nom;
        this.lvlVie = lvlVie;
    }

    /////////////////////////////// Getter Setter  /////////////////////////////////


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getLvlVie() {
        return lvlVie;
    }
    public void setLvlVie(int lvlVie) {
        this.lvlVie = lvlVie;
    }




}
