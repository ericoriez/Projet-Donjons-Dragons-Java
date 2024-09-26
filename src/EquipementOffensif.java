public abstract class EquipementOffensif {

    protected String type;
    protected String nom;
    protected int puissance;



    public EquipementOffensif( String type, String nom, int puissance) {
        this.type = type;
        this.nom = nom;
        this.puissance = puissance;
    }



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






    public String toString() {
        return type + nom + " (Puissance : " + puissance + ")";
    }
}