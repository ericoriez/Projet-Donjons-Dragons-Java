public class GuerrierSpecial extends Guerriers {
    public GuerrierSpecial(String nom) {
        super(nom);
        this.niveauDeVie = 3;
    }

    public void regenVie(int de1, int de2){
      System.out.println("Vous avez lancé les dés et obtenu : " + de1 + " et " + de2);

        if(de1 == de2){
            this.niveauDeVie +=2;
            System.out.println("Double ! Vous avez gagné 2 points de vie.");
            System.out.println("Votre niveau de vie est maintenant : " + this.niveauDeVie);

        }
    }
}
