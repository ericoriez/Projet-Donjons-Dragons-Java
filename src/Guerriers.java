public class Guerriers extends Personnage {

    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;

    // Constructeur pour initialiser un guerrier avec nom
    public Guerriers(String nom) {
        super(nom);
        this.niveauDeVie = 10;
        this.forceAttaque = 10;
        this.equipementOffensif = new Arme("Epée", "Excalibur", 100);
        this.equipementDefensif = new Bouclier("Bouclier", "Bouclier d'acier", 15);
    }


    public void setEquipementOffensif(EquipementOffensif equipementOffensif) {
        this.equipementOffensif = equipementOffensif;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    @Override
    public String toString(){
        return "Guerriers : " + nom + " Vie: " + niveauDeVie + " Force: " + forceAttaque + " Equipement Offensif: " + equipementOffensif + " Equipement Defensif: " + equipementDefensif;
    }
}
