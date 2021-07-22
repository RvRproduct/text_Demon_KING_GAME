import java.util.Random;

import java.io.Console;

/*
text_Demon_King
By Roberto Reynoso
A TURN BASED RPG
*/
public class PlayGame extends Enemies {

    public static void main(String[] args) {

        // mapping health to each object
        health.put(DEMON_KING_HEALTH, 4000);
        health.put(SLIME_HEALTH, 50);
        health.put(GOBLIN_HEALTH, 150);
        health.put(DARK_SLIME_HEALTH, 300);
        health.put(TROLL_HEALTH, 500);
        health.put(ORC_HEALTH, 800);
        health.put(DEMON_GOBLIN_HEALTH, 1000);
        health.put(DEMON_TROLL_HEALTH, 1500);
        health.put(DEMON_ORC_HEALTH, 2000);
        health.put(HERO_HEALTH, 100);

        // mapping hit points to each object
        hitPoints.put(DEMON_KING_HIT, 150);
        hitPoints.put(SLIME_HIT, 5);
        hitPoints.put(GOBLIN_HIT, 15);
        hitPoints.put(DARK_SLIME_HIT, 30);
        hitPoints.put(TROLL_HIT, 50);
        hitPoints.put(ORC_HIT, 60);
        hitPoints.put(DEMON_GOBLIN_HIT, 70);
        hitPoints.put(DEMON_TROLL_HIT, 90);
        hitPoints.put(DEMON_ORC_HIT, 100);
        hitPoints.put(HERO_HIT, 5);

        // mapping gold
        wallet.put(WALLET, 0);

        // mapping swords
        swords.put(HANDS, 5);
        swords.put(STICK, 10);
        swords.put(CLUB, 20);
        swords.put(DAGGER, 25);
        swords.put(AXE, 40);
        swords.put(SPEAR, 45);
        swords.put(SHORT_SWORD, 50);
        swords.put(SWORD, 60);
        swords.put(LONG_SWORD, 70);
        swords.put(KINGS_SWORD, 100);
        swords.put(MASTER_SWORD, 200);

        // mapping shields
        shields.put(FEET, 1);
        shields.put(WOOD_PLANK, 5);
        shields.put(GRASS_SHIELD, 10);
        shields.put(LEATHER_SHIELD, 15);
        shields.put(WOOD_SHIELD, 20);
        shields.put(BRONZE_SHIELD, 25);
        shields.put(IRON_SHIELD, 30);
        shields.put(GOLD_SHIELD, 40);
        shields.put(STEEL_SHIELD, 50);
        shields.put(KINGS_SHIELD, 75);
        shields.put(MASTER_SHIELD, 100);

        // shop prices
        shop.put(LEAVE, 0);
        // swords
        shop.put(STICK, 50);
        shop.put(CLUB, 100);
        shop.put(DAGGER, 150);
        shop.put(AXE, 200);
        shop.put(SPEAR, 250);
        shop.put(SHORT_SWORD, 300);
        shop.put(SWORD, 350);
        shop.put(LONG_SWORD, 400);
        shop.put(KINGS_SWORD, 500);
        shop.put(MASTER_SWORD, 650);
        // shields
        shop.put(WOOD_PLANK, 50);
        shop.put(GRASS_SHIELD, 100);
        shop.put(LEATHER_SHIELD, 150);
        shop.put(WOOD_SHIELD, 200);
        shop.put(BRONZE_SHIELD, 250);
        shop.put(IRON_SHIELD, 300);
        shop.put(GOLD_SHIELD, 350);
        shop.put(STEEL_SHIELD, 400);
        shop.put(KINGS_SHIELD, 500);
        shop.put(MASTER_SHIELD, 650);
        // hp recovery
        shop.put(HEALTH_RECOVERY_100, 20);
        // shop choices
        shopChoice.put(LEAVE, LEAVE_CHOICE);
        // swords
        shopChoice.put(STICK, STICK_CHOICE);
        shopChoice.put(CLUB, CLUB_CHOICE);
        shopChoice.put(DAGGER, DAGGER_CHOICE);
        shopChoice.put(AXE, AXE_CHOICE);
        shopChoice.put(SPEAR, SPEAR_CHOICE);
        shopChoice.put(SHORT_SWORD, SHORT_SWORD_CHOICE);
        shopChoice.put(SWORD, SWORD_CHOICE);
        shopChoice.put(LONG_SWORD, LONG_SWORD_CHOICE);
        shopChoice.put(KINGS_SWORD, KINGS_SWORD_CHOICE);
        shopChoice.put(MASTER_SWORD, MASTER_SWORD_CHOICE);
        // shields
        shopChoice.put(WOOD_PLANK, WOOD_PLANK_CHOICE);
        shopChoice.put(GRASS_SHIELD, GRASS_SHIELD_CHOICE);
        shopChoice.put(LEATHER_SHIELD, LEATHER_SHIELD_CHOICE);
        shopChoice.put(WOOD_SHIELD, WOOD_SHIELD_CHOICE);
        shopChoice.put(BRONZE_SHIELD, BRONZE_SHIELD_CHOICE);
        shopChoice.put(IRON_SHIELD, IRON_SHIELD_CHOICE);
        shopChoice.put(GOLD_SHIELD, GOLD_SHIELD_CHOICE);
        shopChoice.put(STEEL_SHIELD, STEEL_SHIELD_CHOICE);
        shopChoice.put(KINGS_SHIELD, KINGS_SHIELD_CHOICE);
        shopChoice.put(MASTER_SHIELD, MASTER_SHIELD_CHOICE);
        // hp recovery
        shopChoice.put(HEALTH_RECOVERY_100, HEALTH_RECOVERY_100_CHOICE);
        // current sword
        currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
        // current shield
        currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));

        System.out.printf(
                "WELCOME TO TEXT_DEMON_KING %nYOUR GOAL IS TO DEFEAT THE DEMON KING %nYOU WILL BE ABLE TO LEVEL UP AND REACH YOUR GOAL!%n");
        Inventory.Menu.menu(args);
    }

    class Inventory extends Enemies {
        static String currentGold = WALLET;

        static void currentEquip() {
            System.out.printf("%n---------------%nHealth: %s%n%s: %s%n%s: %s%nGold: %s%n---------------%n",
                    health.get(HERO_HEALTH), CURRENT_SWORD, currentSword.get(CURRENT_SWORD), CURRENT_SHIELD,
                    currentShield.get(CURRENT_SHIELD), wallet.get(currentGold));
            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));

        }

        class Shop extends Inventory {
            static Console console = System.console();
            static String options = "";
            static boolean loopCatch = true;
            static int choice = -1;

            static void goShop() {
                loopCatch = true;
                System.out.printf("%nWELCOME TO THE SHOP%n---------------%n");
                console.printf(
                        "ITEMS FOR SALE%n---------------%n" + "%s> %s PRICE: %s%n".repeat(21) + "%n---------------%n",
                        LEAVE, shopChoice.get(LEAVE), shop.get(LEAVE), STICK, shopChoice.get(STICK), shop.get(STICK),
                        CLUB, shopChoice.get(CLUB), shop.get(CLUB), DAGGER, shopChoice.get(DAGGER), shop.get(DAGGER),
                        AXE, shopChoice.get(AXE), shop.get(AXE), SPEAR, shopChoice.get(SPEAR), shop.get(SPEAR),
                        SHORT_SWORD, shopChoice.get(SHORT_SWORD), shop.get(SHORT_SWORD), SWORD, shopChoice.get(SWORD),
                        shop.get(SWORD), LONG_SWORD, shopChoice.get(LONG_SWORD), shop.get(LONG_SWORD), KINGS_SWORD,
                        shopChoice.get(KINGS_SWORD), shop.get(KINGS_SWORD), MASTER_SWORD, shopChoice.get(MASTER_SWORD),
                        shop.get(MASTER_SWORD), WOOD_PLANK, shopChoice.get(WOOD_PLANK), shop.get(WOOD_PLANK),
                        GRASS_SHIELD, shopChoice.get(GRASS_SHIELD), shop.get(GRASS_SHIELD), LEATHER_SHIELD,
                        shopChoice.get(LEATHER_SHIELD), shop.get(LEATHER_SHIELD), WOOD_SHIELD,
                        shopChoice.get(WOOD_SHIELD), shop.get(WOOD_SHIELD), IRON_SHIELD, shopChoice.get(IRON_SHIELD),
                        shop.get(IRON_SHIELD), GOLD_SHIELD, shopChoice.get(GOLD_SHIELD), shop.get(GOLD_SHIELD),
                        STEEL_SHIELD, shopChoice.get(STEEL_SHIELD), shop.get(STEEL_SHIELD), KINGS_SHIELD,
                        shopChoice.get(KINGS_SHIELD), shop.get(KINGS_SHIELD), MASTER_SHIELD,
                        shopChoice.get(MASTER_SHIELD), shop.get(MASTER_SHIELD), HEALTH_RECOVERY_100,
                        shopChoice.get(HEALTH_RECOVERY_100), shop.get(HEALTH_RECOVERY_100));
                while (loopCatch) {
                    options = console.readLine("%nWhat would you like to buy? (Use the numbers accordingly) ");
                    try {
                        choice = Integer.parseInt(options);
                    } catch (NumberFormatException nfe) {
                    }
                    if (!shopChoice.containsValue(choice)) {
                        System.out.printf("%nYou have to enter a number from 1-21%n");
                        loopCatch = true;
                    } else {
                        loopCatch = false;
                    }
                    if (choice == LEAVE_CHOICE) {
                        console.printf("%nLEFT SHOP%n");
                    } else if (choice == STICK_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(STICK)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(STICK));
                            currentSword.clear();
                            CURRENT_SWORD = STICK;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == CLUB_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(CLUB)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(CLUB));
                            currentSword.clear();
                            CURRENT_SWORD = CLUB;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == DAGGER_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(DAGGER)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(DAGGER));
                            currentSword.clear();
                            CURRENT_SWORD = DAGGER;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == AXE_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(AXE)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(AXE));
                            currentSword.clear();
                            CURRENT_SWORD = AXE;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == SPEAR_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(SPEAR)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(SPEAR));
                            currentSword.clear();
                            CURRENT_SWORD = SPEAR;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == SHORT_SWORD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(SHORT_SWORD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(SHORT_SWORD));
                            currentSword.clear();
                            CURRENT_SWORD = SHORT_SWORD;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == SWORD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(SWORD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(SWORD));
                            currentSword.clear();
                            CURRENT_SWORD = SWORD;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == LONG_SWORD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(LONG_SWORD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(LONG_SWORD));
                            currentSword.clear();
                            CURRENT_SWORD = LONG_SWORD;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == KINGS_SWORD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(KINGS_SWORD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(KINGS_SWORD));
                            currentSword.clear();
                            CURRENT_SWORD = KINGS_SWORD;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == MASTER_SWORD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(MASTER_SWORD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(MASTER_SWORD));
                            currentSword.clear();
                            CURRENT_SWORD = MASTER_SWORD;
                            currentSword.put(CURRENT_SWORD, swords.get(CURRENT_SWORD));
                            hitPoints.put(HERO_HIT, swords.get(CURRENT_SWORD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SWORD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == WOOD_PLANK_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(WOOD_PLANK)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(WOOD_PLANK));
                            currentShield.clear();
                            CURRENT_SHIELD = WOOD_PLANK;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == GRASS_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(GRASS_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(GRASS_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = GRASS_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == LEATHER_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(LEATHER_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(LEATHER_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = LEATHER_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == WOOD_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(WOOD_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(WOOD_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = WOOD_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == BRONZE_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(BRONZE_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(BRONZE_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = BRONZE_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == IRON_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(IRON_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(IRON_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = IRON_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == GOLD_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(GOLD_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(GOLD_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = GOLD_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == STEEL_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(STEEL_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(STEEL_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = STEEL_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == KINGS_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(KINGS_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(KINGS_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = KINGS_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == MASTER_SHIELD_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(MASTER_SHIELD)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(MASTER_SHIELD));
                            currentShield.clear();
                            CURRENT_SHIELD = MASTER_SHIELD;
                            currentShield.put(CURRENT_SHIELD, shields.get(CURRENT_SHIELD));
                            console.printf("%nOBTAINED: %s%nWALLET: %s%n", CURRENT_SHIELD, wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    } else if (choice == HEALTH_RECOVERY_100_CHOICE) {
                        if (wallet.get(WALLET) >= shop.get(HEALTH_RECOVERY_100)) {
                            wallet.put(WALLET, wallet.get(WALLET) - shop.get(HEALTH_RECOVERY_100));
                            health.put(HERO_HEALTH, health.get(HERO_HEALTH) + 100);
                            console.printf("%nOBTAINED: %sHP%nWALLET: %s%n", health.get(HERO_HEALTH),
                                    wallet.get(WALLET));
                        } else {
                            console.printf("%nNOT ENOUGH GOLD!!!%nWALLET: %s%n", wallet.get(WALLET));
                        }
                    }
                }
            }
        }

        class battleEnemy extends Shop {
            public static int optionSelected = 0;
            public static Random rand = new Random();

            public static int randInt(int min, int max) {
                int randomNum = rand.nextInt((max - min) + 1) + min;
                return randomNum;
            }

            static void goBattle(String[] args) {
                Enemies.Battle(args);
                Integer enemy = 0;
                Integer enemyDamage = 0;
                Integer heroDamage = 0;
                Integer reward = 0;
                String optionChoice = "";
                boolean loopCatch = true;

                if (enemyChoice == SLIME) {
                    enemy = health.get(SLIME_HEALTH);
                    reward = randInt(20, 50);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit SLIME for %s!!!%n%s: %s%n", heroDamage, SLIME_HEALTH, enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(SLIME_HIT) / 2), (hitPoints.get(SLIME_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("SLIME hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(SLIME_HIT) / 2),
                                            (hitPoints.get(SLIME_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("SLIME hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }

                if (enemyChoice == GOBLIN) {
                    enemy = health.get(GOBLIN_HEALTH);
                    reward = randInt(35, 75);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit GOBLIN for %s!!!%n%s: %s%n", heroDamage, GOBLIN_HEALTH, enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(GOBLIN_HIT) / 2), (hitPoints.get(GOBLIN_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("GOBLIN hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(GOBLIN_HIT) / 2),
                                            (hitPoints.get(GOBLIN_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("GOBLIN hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }

                if (enemyChoice == DARK_SLIME) {
                    enemy = health.get(DARK_SLIME_HEALTH);
                    reward = randInt(40, 100);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit DARK_SLIME for %s!!!%n%s: %s%n", heroDamage, DARK_SLIME_HEALTH,
                                    enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(DARK_SLIME_HIT) / 2),
                                        (hitPoints.get(DARK_SLIME_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("DARK_SLIME hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(DARK_SLIME_HIT) / 2),
                                            (hitPoints.get(DARK_SLIME_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("DARK_SLIME hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }
                if (enemyChoice == TROLL) {
                    enemy = health.get(TROLL_HEALTH);
                    reward = randInt(50, 120);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit TROLL for %s!!!%n%s: %s%n", heroDamage, TROLL_HEALTH, enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(TROLL_HIT) / 2), (hitPoints.get(TROLL_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("TROLL hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(TROLL_HIT) / 2),
                                            (hitPoints.get(TROLL_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("TROLL hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }
                if (enemyChoice == ORC) {
                    enemy = health.get(ORC_HEALTH);
                    reward = randInt(80, 150);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit ORC for %s!!!%n%s: %s%n", heroDamage, ORC_HEALTH, enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(ORC_HIT) / 2), (hitPoints.get(ORC_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("ORC hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(ORC_HIT) / 2), (hitPoints.get(ORC_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("ORC hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }
                if (enemyChoice == DEMON_GOBLIN) {
                    enemy = health.get(DEMON_GOBLIN_HEALTH);
                    reward = randInt(100, 200);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit DEMON_GOBLIN for %s!!!%n%s: %s%n", heroDamage, DEMON_GOBLIN_HEALTH,
                                    enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(DEMON_GOBLIN_HIT) / 2),
                                        (hitPoints.get(DEMON_GOBLIN_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("DEMON_GOBLIN hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(DEMON_GOBLIN_HIT) / 2),
                                            (hitPoints.get(DEMON_GOBLIN_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("DEMON_GOBLIN hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }
                if (enemyChoice == DEMON_TROLL) {
                    enemy = health.get(DEMON_TROLL_HEALTH);
                    reward = randInt(150, 250);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit DEMON_TROLL for %s!!!%n%s: %s%n", heroDamage, DEMON_TROLL_HEALTH,
                                    enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(DEMON_TROLL_HIT) / 2),
                                        (hitPoints.get(DEMON_TROLL_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("DEMON_TROLL hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(DEMON_TROLL_HIT) / 2),
                                            (hitPoints.get(DEMON_TROLL_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("DEMON_TROLL hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }
                if (enemyChoice == DEMON_ORC) {
                    enemy = health.get(DEMON_ORC_HEALTH);
                    reward = randInt(250, 350);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit DEMON_ORC for %s!!!%n%s: %s%n", heroDamage, DEMON_ORC_HEALTH,
                                    enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(DEMON_ORC_HIT) / 2),
                                        (hitPoints.get(DEMON_ORC_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                console.printf("DEMON_ORC hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(DEMON_ORC_HIT) / 2),
                                            (hitPoints.get(DEMON_ORC_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    console.printf("DEMON_ORC hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }
                if (enemyChoice == DEMON_KING) {
                    enemy = health.get(DEMON_KING_HEALTH);
                    reward = randInt(400, 600);
                    while (loopCatch) {
                        if (health.get(HERO_HEALTH) <= 0) {
                            console.printf("%nGAME OVER%n");
                            System.exit(0);
                        }
                        optionSelected = 0;
                        optionChoice = console.readLine("%nAttack: 1%nRunAway: 2%n");
                        try {
                            optionSelected = Integer.parseInt(optionChoice);

                        } catch (NumberFormatException nfe) {
                        }
                        if (optionSelected == 1) {
                            heroDamage = randInt((hitPoints.get(HERO_HIT) / 2), (hitPoints.get(HERO_HIT) + 5));
                            enemy -= heroDamage;
                            console.printf("You hit DEMON_KING for %s!!!%n%s: %s%n", heroDamage, DEMON_KING_HEALTH,
                                    enemy);
                            if (enemy > 0) {
                                enemyDamage = randInt((hitPoints.get(DEMON_KING_HIT) / 2),
                                        (hitPoints.get(DEMON_KING_HIT) + 5))
                                        - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                (currentShield.get(CURRENT_SHIELD)));
                                health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                if (enemyDamage <= 0) {
                                    enemyDamage = 0;
                                }
                                console.printf("DEMON_KING hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                        health.get(HERO_HEALTH));
                            } else {
                                wallet.put(WALLET, wallet.get(WALLET) + reward);
                                console.printf("REWARD: %s%nWALLET: %s%n", reward, wallet.get(WALLET));
                                console.printf(
                                        "%nYOU BEAT THE DEMON KING!!!!! CONGRATS!!!!%nYOU CAN CONTINUE IF YOU WANT%n");
                                loopCatch = false;
                            }

                        } else if (optionSelected == 2) {
                            console.printf("%nTRYING TO RUNAWAY%n");
                            if (5 > rand.nextInt(20)) {
                                if (enemy > 0) {
                                    enemyDamage = randInt((hitPoints.get(DEMON_KING_HIT) / 2),
                                            (hitPoints.get(DEMON_KING_HIT) + 5))
                                            - randInt((currentShield.get(CURRENT_SHIELD) / 2),
                                                    (currentShield.get(CURRENT_SHIELD)));
                                    health.put(HERO_HEALTH, health.get(HERO_HEALTH) - enemyDamage);
                                    if (enemyDamage <= 0) {
                                        enemyDamage = 0;
                                    }
                                    console.printf("DEMON_KING hit you for %s!!!%n%s: %s%n", enemyDamage, HERO_HEALTH,
                                            health.get(HERO_HEALTH));
                                }
                            } else {
                                console.printf("%nSuccessful in RUNNING AWAY%n");
                                loopCatch = false;
                            }
                        } else {
                            console.printf("%nPlease choose 1 or 2%n");
                        }
                    }
                }

            }
        }

        class Menu extends battleEnemy {
            public static int menuChoice = 0;

            public static void menu(String[] args) {
                boolean loopCatch = true;
                String choice = "";
                while (loopCatch) {
                    choice = console.readLine("%n1: FIGHT%n2: SHOP%n3: STATS%n4: QUIT%n");
                    try {
                        menuChoice = Integer.parseInt(choice);
                    } catch (NumberFormatException nfe) {
                    }
                    if (menuChoice < 0 && menuChoice < 5) {
                        console.printf("%nChoose a number from 1-4");
                        loopCatch = true;
                    } else if (menuChoice == 1) {
                        battleEnemy.goBattle(args);
                    } else if (menuChoice == 2) {
                        Shop.goShop();
                    } else if (menuChoice == 3) {
                        Inventory.currentEquip();
                    } else if (menuChoice == 4) {
                        console.printf("%nBYE");
                        loopCatch = false;
                    }
                }
            }

        }
    }
}