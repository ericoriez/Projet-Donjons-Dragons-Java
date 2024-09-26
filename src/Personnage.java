public abstract class Personnage {
    // Attributs
    protected String nom;
    protected int niveauDeVie;
    protected int forceAttaque;
    protected EquipementOffensif equipementOffensif;
    protected EquipementDefensif equipementDefensif;
    protected String vie_max;
    protected String attaque_max ;
    // Constructeur avec nom
    public Personnage(String nom) {
        this.nom = nom;
    }

    // Getters et Setters pour chaque attribut
  public String getNom() {
      return nom;
  }
  public int getNiveauDeVie() {
      return niveauDeVie;
  }
  public int getForceAttaque() {
      return forceAttaque;
  }
  public EquipementOffensif getEquipementOffensif() {
        return equipementOffensif;
  }
  public EquipementDefensif getEquipementDefensif() {
        return equipementDefensif;
  }
  public String getVie_max() {
        return vie_max;
  }
  public String getAttaque_max() {
        return attaque_max;
  }


    // Méthode toString pour afficher les informations du personnage

    public String toString() {
        return "Personnage :" +
        " Nom: " + nom +
        " Niveau de vie: " + niveauDeVie +
        " Force d'attaque: " + forceAttaque +
        " Equipement Offensif: " + equipementOffensif  +
        " Equipement Defensif: " + equipementDefensif +
        " Vie max: " + vie_max +
        " Attaque max: " + attaque_max;
    }
}
