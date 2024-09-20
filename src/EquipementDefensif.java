public class EquipementDefensif {

    private String type;
    private int niveauDeDefense;
    private String nom;

    public EquipementDefensif(String type, int niveauDeDefense, String nom) {
        this.type = type;
        this.niveauDeDefense = niveauDeDefense;
        this.nom = nom;

    }
    public String getType() {
        return type;
    }
    public int getNiveauDeDefense() {
        return niveauDeDefense;
    }
    public String getNom() {
        return nom;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setNiveauDeDefense(int niveauDeDefense) {
        this.niveauDeDefense = niveauDeDefense;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

}
