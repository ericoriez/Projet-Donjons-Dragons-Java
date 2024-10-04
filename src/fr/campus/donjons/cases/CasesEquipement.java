package fr.campus.donjons.cases;

import fr.campus.donjons.db.HeroRepository;
import fr.campus.donjons.equipements.Arme;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.equipements.Sort;
import fr.campus.donjons.personnages.Guerriers;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.Personnage;

import java.util.Scanner;

public class CasesEquipement {

    private static Scanner scanner = new Scanner(System.in);
    private HeroRepository heroRepository = new HeroRepository();

    // Méthode pour gérer l'interaction lorsqu'un personnage tombe sur une case avec un équipement
    public void gererInteractionEquipement(Personnage personnage, EquipementOffensif equipement) {
        // Vérifier si le personnage peut utiliser l'équipement
        if ((equipement instanceof Arme && personnage instanceof Guerriers) ||
                (equipement instanceof Sort && personnage instanceof Magiciens)) {

            System.out.println("Vous avez trouvé un nouvel équipement offensif : " + equipement);
            System.out.println("Voulez-vous l'équiper ? (oui/non)");
            String choix = scanner.nextLine().trim().toLowerCase();

            if (choix.equals("oui")) {
                personnage.setEquipementOffensif(equipement);


                // Ajouter la puissance de l'équipement à la force d'attaque du personnage
                personnage.setForceAttaque(personnage.getForceAttaque() + equipement.getPuissance());

                // Mettre à jour le personnage dans la base de données
                if (personnage.getId() != 0) {
                    boolean success = heroRepository.editHero(personnage);
                    if (!success) {
                        System.out.println("Échec de la mise à jour du héros en base de données.");
                    }
                } else {
                    System.out.println("Impossible de mettre à jour le héros en base de données car l'ID n'est pas défini.");
                }
            } else {
                System.out.println("Vous avez choisi de ne pas équiper le nouvel équipement.");
            }

        } else {
            System.out.println("Vous avez trouvé un équipement que vous ne pouvez pas utiliser.");
        }
    }
}
