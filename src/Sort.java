public class Sort extends EquipementOffensif{

    public Sort(String type, String nom, int puissance) {

        super(type, nom, puissance);
    }

    @Override
    public String toString() {
        return type +" [Nom : " + nom + ", Puissance : " + puissance + "]";
    }
}
