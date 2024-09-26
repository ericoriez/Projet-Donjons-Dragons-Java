public class Magiciens extends Personnage{
    private EquipementOffensif equipementOffensif;
    private EquipementDefensif equipementDefensif;
    public Magiciens(String nom) {
        super(nom);
        this.niveauDeVie = 6;
        this.forceAttaque =15;
        this.equipementOffensif = new Sort(" Sort ", "Boule de feu", 18);
        this.equipementDefensif = new Philtre(" Philtre ", "Carapace", 15);

    }

    public void SetEquipementOffensif(EquipementOffensif equipementOff){
        this.equipementOffensif = equipementOff;
    }

    public void setEquipementDefensif(EquipementDefensif equipementDefensif) {
        this.equipementDefensif = equipementDefensif;
    }

    //    @Override
//    public void attaquer(){
//      if(equipementOffensif == null){
//          System.out.println(nom + "Lance" + equipementOffensif.getNom() + "Puissance de " + equipementOffensif.getPuissance());
//      }else{
//          System.out.println(nom + " attaque sans équipement offensif ");
//      }
//    }


    public String toString() {
        return "Magiciens : " + nom + " Vie: " + niveauDeVie + " Force: " + forceAttaque + " Equipement Offensif: " + equipementOffensif + " Equipement Defensif: " + equipementDefensif;
    }
}
