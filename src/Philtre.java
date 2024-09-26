public class Philtre  extends EquipementDefensif{
     public Philtre(String type, String nom, int defense) {

         super(type, nom, defense);
     }

     @Override
    public String toString() {
         return type + " [Nom : " + nom + ", Defense : " + niveauDefense + "]";
     }
}
