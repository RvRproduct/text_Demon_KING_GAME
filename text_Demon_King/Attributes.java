import java.util.HashMap;
import java.util.Map;

public class Attributes {
    // health stats constants
    public static final String DEMON_KING_HEALTH = "demon king health";
    public static final String SLIME_HEALTH = "slime health";
    public static final String GOBLIN_HEALTH = "goblin health";
    public static final String DARK_SLIME_HEALTH = "dark slime";
    public static final String TROLL_HEALTH = "troll health";
    public static final String ORC_HEALTH = "orc health";
    public static final String DEMON_GOBLIN_HEALTH = "demon goblin health";
    public static final String DEMON_TROLL_HEALTH = "demon troll health";
    public static final String DEMON_ORC_HEALTH = "demon orc health";
    public static final String HERO_HEALTH = "hero health";
    // hit point stats constants around this number
    public static final String DEMON_KING_HIT = "demon king hit";
    public static final String SLIME_HIT = "slime hit";
    public static final String GOBLIN_HIT = "goblin hit";
    public static final String DARK_SLIME_HIT = "dark slime hit";
    public static final String TROLL_HIT = "troll hit";
    public static final String ORC_HIT = "orc hit";
    public static final String DEMON_GOBLIN_HIT = "demon goblin hit";
    public static final String DEMON_TROLL_HIT = "demon troll hit";
    public static final String DEMON_ORC_HIT = "demon orc hit";
    public static final String HERO_HIT = "hero hit";
    // gold
    public static final String WALLET = "wallet";
    // swords
    public static final String HANDS = "hands";
    public static final String STICK = "stick";
    public static final String CLUB = "club";
    public static final String DAGGER = "dagger";
    public static final String AXE = "axe";
    public static final String SPEAR = "spear";
    public static final String SHORT_SWORD = "short sword";
    public static final String SWORD = "sword";
    public static final String LONG_SWORD = "long sword";
    public static final String KINGS_SWORD = "kings sword";
    public static final String MASTER_SWORD = "master sword";
    // shields
    public static final String FEET = "feet";
    public static final String WOOD_PLANK = "wood plank";
    public static final String GRASS_SHIELD = "grass shield";
    public static final String LEATHER_SHIELD = "leather shield";
    public static final String WOOD_SHIELD = "wood shield";
    public static final String BRONZE_SHIELD = "bronze shield";
    public static final String IRON_SHIELD = "iron shield";
    public static final String GOLD_SHIELD = "gold shield";
    public static final String STEEL_SHIELD = "steel shield";
    public static final String KINGS_SHIELD = "kings shield";
    public static final String MASTER_SHIELD = "master shield";
    // special shop hp boost
    public static final String HEALTH_RECOVERY_100 = "recover 100 hp";
    // choice by num for the shop
    public static final String LEAVE = "leave shop";
    public static final Integer LEAVE_CHOICE = 0;
    // swords
    public static final Integer STICK_CHOICE = 1;
    public static final Integer CLUB_CHOICE = 2;
    public static final Integer DAGGER_CHOICE = 3;
    public static final Integer AXE_CHOICE = 4;
    public static final Integer SPEAR_CHOICE = 5;
    public static final Integer SHORT_SWORD_CHOICE = 6;
    public static final Integer SWORD_CHOICE = 7;
    public static final Integer LONG_SWORD_CHOICE = 8;
    public static final Integer KINGS_SWORD_CHOICE = 9;
    public static final Integer MASTER_SWORD_CHOICE = 10;
    // shields
    public static final Integer WOOD_PLANK_CHOICE = 11;
    public static final Integer GRASS_SHIELD_CHOICE = 12;
    public static final Integer LEATHER_SHIELD_CHOICE = 13;
    public static final Integer WOOD_SHIELD_CHOICE = 14;
    public static final Integer BRONZE_SHIELD_CHOICE = 15;
    public static final Integer IRON_SHIELD_CHOICE = 16;
    public static final Integer GOLD_SHIELD_CHOICE = 17;
    public static final Integer STEEL_SHIELD_CHOICE = 18;
    public static final Integer KINGS_SHIELD_CHOICE = 19;
    public static final Integer MASTER_SHIELD_CHOICE = 20;
    // special shop hp boost
    public static final Integer HEALTH_RECOVERY_100_CHOICE = 21;
    // Sword in Hand
    public static String CURRENT_SWORD = HANDS;
    // Shield in Hand
    public static String CURRENT_SHIELD = FEET;
    // mapping health to each object
    public static Map<String, Integer> health = new HashMap<>();
    // mapping hit points to each object
    public static Map<String, Integer> hitPoints = new HashMap<>();
    // mapping gold
    public static Map<String, Integer> wallet = new HashMap<>();
    // mapping swords
    public static Map<String, Integer> swords = new HashMap<>();
    // current sword
    public static Map<String, Integer> currentSword = new HashMap<>();
    // mapping shields
    public static Map<String, Integer> shields = new HashMap<>();
    // current shield
    public static Map<String, Integer> currentShield = new HashMap<>();
    // shop prices
    public static Map<String, Integer> shop = new HashMap<>();
    // shop choices
    public static Map<String, Integer> shopChoice = new HashMap<>();

}
