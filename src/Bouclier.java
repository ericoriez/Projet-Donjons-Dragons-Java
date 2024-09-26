public class Bouclier extends EquipementDefensif{

    public Bouclier(String type, String nom, int defense){

        super(type, nom, defense);
    }

    @Override
    public String toString() {
        return type + " [Nom : " + nom + ", Defense : " + niveauDefense + "]";
    }
}
