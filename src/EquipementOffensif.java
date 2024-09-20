public class EquipementOffensif {
    private String type;
    private int niveauAttaque;
    private String nom;

    public EquipementOffensif(String type, int niveauAttaque, String nom) {
        this.type = type;
        this.niveauAttaque = niveauAttaque;
        this.nom = nom;
    }
    public String getType() {
        return type;
    }
    public int getNiveauAttaque() {
        return niveauAttaque;
    }
    public String getNom() {
        return nom;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveauAttaque(int niveauAttaque) {
        this.niveauAttaque = niveauAttaque;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

}
