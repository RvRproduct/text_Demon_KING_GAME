import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Enemies extends Attributes {
    public static final Integer SLIME = 1;
    public static final Integer GOBLIN = 2;
    public static final Integer DARK_SLIME = 3;
    public static final Integer TROLL = 4;
    public static final Integer ORC = 5;
    public static final Integer DEMON_GOBLIN = 6;
    public static final Integer DEMON_TROLL = 7;
    public static final Integer DEMON_ORC = 8;
    public static final Integer DEMON_KING = 9;
    public static List<Integer> enemiesChoice = new ArrayList<Integer>();
    public static int enemyChoice = 0;

    public static void Battle(String[] args) {
        Console console = System.console();
        String battle = "";
        boolean loopCatch = true;

        enemiesChoice.add(SLIME);
        enemiesChoice.add(GOBLIN);
        enemiesChoice.add(DARK_SLIME);
        enemiesChoice.add(TROLL);
        enemiesChoice.add(ORC);
        enemiesChoice.add(DEMON_GOBLIN);
        enemiesChoice.add(DEMON_TROLL);
        enemiesChoice.add(DEMON_ORC);
        enemiesChoice.add(DEMON_KING);
        console.printf(
                "ENIMIES%n---------------%nSLIME %s%nGOBLIN %s%nDARK_SLIME %s%nTROLL %s%nORC %s%nDEMON_GOBLIN %s%nDEMON_TROLL %s%nDEMON_ORC %s%nDEMON_KING %s%n---------------%n",
                SLIME, GOBLIN, DARK_SLIME, TROLL, ORC, DEMON_GOBLIN, DEMON_TROLL, DEMON_ORC, DEMON_KING);
        while (loopCatch) {
            battle = console.readLine("Choose an Enemy to fight: ");
            try {
                enemyChoice = Integer.parseInt(battle);
            } catch (NumberFormatException nfe) {
            }
            if (!enemiesChoice.contains(enemyChoice)) {
                System.out.printf("%nYou have to enter a number from 1-9%n");
                loopCatch = true;
            } else {
                loopCatch = false;
            }
        }

    }
}
