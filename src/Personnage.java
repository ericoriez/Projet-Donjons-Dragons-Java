public class Personnage {
    private String nom;
    private String type;
    private int niveauDeVie;
    private int forceAttaque;

    // CONSTRUCTEUR
    public Personnage() {

    }
    public Personnage(String nom) {
        this.nom = nom;

    }
    public Personnage(String nom, String type) {
        this.nom = nom;
        this.type = type;
    }




    // GETTER SETTER
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getNiveauDeVie() {
        return niveauDeVie;
    }
    public void setNiveauDeVie(int niveauDeVie) {
        this.niveauDeVie = niveauDeVie;
    }
    public int getForceAttaque() {
        return forceAttaque;
    }
    public void setForceAttaque(int forceAttaque) {
        this.forceAttaque = forceAttaque;
    }

}
