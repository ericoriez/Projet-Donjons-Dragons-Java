package fr.campus.donjons.cases;

import fr.campus.donjons.db.HeroRepository;
import fr.campus.donjons.equipements.Arme;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.equipements.Sort;
import fr.campus.donjons.personnages.Guerriers;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.Personnage;
import java.util.Scanner;

/**
 * La classe {@code CasesEquipement} gère l'interaction du personnage avec une case contenant un équipement offensif.
 * Elle permet au joueur de décider s'il souhaite équiper un nouvel équipement et met à jour les attributs du personnage en conséquence.
 */
public class CasesEquipement {

    /**
     * Scanner pour lire les entrées de l'utilisateur.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Repository pour la gestion des héros dans la base de données.
     */
    private HeroRepository heroRepository = new HeroRepository();

    /**
     * Gère l'interaction lorsqu'un personnage tombe sur une case contenant un équipement offensif.
     * Si l'équipement est compatible avec le type de personnage (Arme pour Guerriers, Sort pour Magiciens),
     * le joueur peut choisir de l'équiper. L'équipement est ensuite ajouté à l'inventaire du personnage,
     * et la force d'attaque du personnage est mise à jour. Si le personnage est présent dans la base de données,
     * ses informations sont également mises à jour.
     *
     * @param personnage Le personnage qui interagit avec l'équipement.
     * @param equipement L'équipement offensif trouvé sur la case.
     */
    public void gererInteractionEquipement(Personnage personnage, EquipementOffensif equipement) {
        // Vérifier si le personnage peut utiliser l'équipement
        if ((equipement instanceof Arme && personnage instanceof Guerriers) ||
                (equipement instanceof Sort && personnage instanceof Magiciens)) {

            System.out.println("Vous avez trouvé un nouvel équipement offensif : " + equipement);
            System.out.println("Voulez-vous l'équiper ? (oui/non)");
            String choix = scanner.nextLine().trim().toLowerCase();

            if (choix.equals("oui")) {
                personnage.setEquipementOffensif(equipement);

                // Mettre à jour la force d'attaque
                int ancienneForce = personnage.getForceAttaque();
                personnage.setForceAttaque(ancienneForce + equipement.getPuissance());
                System.out.println("Vous avez équipé : " + equipement.getNom() + ". Force d'attaque avant : " + ancienneForce + ", après : " + personnage.getForceAttaque());

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
