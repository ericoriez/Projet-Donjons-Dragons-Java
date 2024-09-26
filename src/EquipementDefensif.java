public class EquipementDefensif {
    protected String nom;
    protected int niveauDefense;
    protected  String type;

    // Constructeur
    public EquipementDefensif(String type, String nom, int niveauDefense) {
        this.type = type;
        this.nom = nom;
        this.niveauDefense = niveauDefense;
    }

    // Getters Setters
    public String getNom() {
        return nom;
    }
    public int getNiveauDefense() {
        return niveauDefense;
    }
    public String getType() {
        return type;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNiveauDefense(int niveauDefense) {
        this.niveauDefense = niveauDefense;
    }
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type + nom + " (Puissance : " + niveauDefense + ")";
    }
}