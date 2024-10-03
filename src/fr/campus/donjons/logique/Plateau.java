package fr.campus.donjons.logique;

import fr.campus.donjons.personnages.GuerrierSpecial;
import fr.campus.donjons.personnages.Guerriers;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.Personnage;
import fr.campus.donjons.equipements.Arme;
import fr.campus.donjons.equipements.Bouclier;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.equipements.Sort;
import fr.campus.donjons.equipements.PotionStandard;
import fr.campus.donjons.logique.Case;
import fr.campus.donjons.personnages.Ennemi;
import fr.campus.donjons.logique.CaseVide;
import fr.campus.donjons.db.HeroRepository;
import fr.campus.donjons.db.EquipementRepository;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Plateau {

    private static final int TAILLE_PLATEAU = 64;
    private ArrayList<Case> cases;
    private int positionJoueur = 1;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private EquipementRepository equipementRepository = new EquipementRepository(); // Pour interagir avec les équipements

    public Plateau() {
        cases = new ArrayList<>();

        // Générer les 64 cases avec des éléments aléatoires
        for (int i = 0; i < TAILLE_PLATEAU; i++) {
            int typeCase = random.nextInt(5); // 0: Case vide, 1: Ennemi, 2: Arme, 3: Sort, 4: Potion

            switch (typeCase) {
                case 0 -> cases.add(new CaseVide());
                case 1 -> cases.add(new Ennemi());
                case 2 -> {
                    Arme arme = equipementRepository.getRandomArme(); // Récupérer une arme aléatoire de la base de données
                    if (arme != null) {
                        cases.add(arme);
                    } else {
                        cases.add(new CaseVide());
                    }
                }
                case 3 -> {
                    Sort sort = equipementRepository.getRandomSort(); // Récupérer un sort aléatoire de la base de données
                    if (sort != null) {
                        cases.add(sort);
                    } else {
                        cases.add(new CaseVide());
                    }
                }
                case 4 -> cases.add(new PotionStandard("Potion de soin standard", 3));
                default -> cases.add(new CaseVide());
            }
        }
    }

    public void lancerPartie(Personnage personnage) throws PersonnageHorsPlateauExeption {
        HeroRepository heroRepository = new HeroRepository();

        System.out.println("Début de la partie ! Le joueur commence sur la case 1.");
        System.out.println(personnage);

        // Boucle de jeu jusqu'à ce que le joueur atteigne ou dépasse la dernière case ou qu'il meure
        while (positionJoueur < TAILLE_PLATEAU && personnage.getNiveauDeVie() > 0) {
            System.out.println("\n========== Lancer de Dés ================");

            // Lancer deux dés
            int de1 = random.nextInt(6) + 1;
            int de2 = random.nextInt(6) + 1;

            if (personnage instanceof GuerrierSpecial) {
                GuerrierSpecial guerrierSpecial = (GuerrierSpecial) personnage;
                guerrierSpecial.regenVie(de1, de2);
                heroRepository.changeLifePoints(guerrierSpecial);
            }

            int deplacement = de1 + de2;
            System.out.println("Vous avez lancé les dés et obtenu : " + de1 + " et " + de2);
            System.out.println("Vous avancez de " + deplacement + " cases.");
            positionJoueur += deplacement;

            // Vérifier si le joueur dépasse la dernière case
            if (positionJoueur >= TAILLE_PLATEAU) {
                System.out.println("Le personnage a dépassé la case finale !");
                break;
            }

            // Interagir avec la case où le joueur est arrivé
            System.out.println("Vous êtes maintenant sur la case " + (positionJoueur + 1) + " / " + TAILLE_PLATEAU);
            Case caseActuelle = cases.get(positionJoueur);
            caseActuelle.interagir(personnage);

            // Gérer les différentes interactions
            if (caseActuelle instanceof PotionStandard) {
                heroRepository.changeLifePoints(personnage);
            } else if (caseActuelle instanceof Arme && personnage instanceof Guerriers) {
                gererEquipementOffensif(personnage, (Arme) caseActuelle, heroRepository);
            } else if (caseActuelle instanceof Sort && personnage instanceof Magiciens) {
                gererEquipementOffensif(personnage, (Sort) caseActuelle, heroRepository);
            } else {
                System.out.println("Vous avez trouvé un équipement que vous ne pouvez pas utiliser.");
            }

            System.out.println(personnage);

            if (personnage.getNiveauDeVie() <= 0) {
                System.out.println("Le personnage est mort !");
                break;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("========== Fin du tour ================\n");

            if (positionJoueur == TAILLE_PLATEAU) {
                System.out.println("Félicitations ! Vous avez gagné !");
                break;
            }
        }
    }

    // Méthode pour gérer l'équipement offensif lorsqu'un personnage tombe sur une case avec une arme ou un sort
    private void gererEquipementOffensif(Personnage personnage, EquipementOffensif equipement, HeroRepository heroRepository) {
        System.out.println("Vous avez trouvé un nouvel équipement offensif : " + equipement);
        System.out.println("Voulez-vous l'équiper ? (oui/non)");
        String choix = scanner.nextLine().trim().toLowerCase();

        if (choix.equals("oui")) {
            personnage.setEquipementOffensif(equipement);
            System.out.println("Nouvel équipement offensif : " + personnage.getEquipementOffensif());

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
    }
}
