import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileHandler fh = new FileHandler();
        UnitFactory uf = new UnitFactory();
        List<Unit> hums = new ArrayList<>();
        List<Unit> orcs = new ArrayList<>();

        File orcFile = new File("Orcs.csv");
        File humanFile = new File("Humans.csv");
        File deadOrcs = new File("deadOrcs.csv");
        File deadHumans = new File("deadHumans.csv");

        Army Horde = new Army("Orcarmy");
        Army Humans = new Army("Human army");

        // Adding premade army
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        orcs.add(new CommanderUnit("Thrall", 150));
        orcs.add(new InfantryUnit("Grom", 40));
        orcs.add(new InfantryUnit("Khal", 25));
        orcs.add(new RangedUnit("Gork", 25));


        // testing the factory by adding units to the orcs
        System.out.print("Enter name of unit to add. Commander/Cavalry/Infantry/Range\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String type = br.readLine();
        System.out.print("Enter the number of units to be added: \n");
        int units = Integer.parseInt(br.readLine());
        for (int i = 0; i < units; i++) {
            Unit p = uf.createUnit(type);
            orcs.add(p);
        }
        System.out.println(Horde.getName());
        System.out.println(hums);
        Thread.sleep(2000);
        System.out.println("VS");
        Thread.sleep(2000);
        System.out.println(Humans.getName());
        System.out.println(orcs);
        Thread.sleep(2000);


        // Battle simulated in main, as JAVAFX is not yet set up! Doing this before deadline 23th of may.
        System.out.println("Starting hitpoints for Horde: " + Horde.getArmyHitpoints(orcs));
        System.out.println("Starting hitpoints for Humans: " + Humans.getArmyHitpoints(hums));
        Thread.sleep(5000);

        while (Horde.getArmyHitpoints(orcs) > 0 && Horde.hasUnits(orcs) ||
                Humans.getArmyHitpoints(hums) > 0 && Humans.hasUnits(hums)) {
            if ((Horde.hasUnits(orcs) || Humans.hasUnits(hums))) {

                // each iteration check if any unit is dead, and remove them from battle.
                Army.getRandomUnit(orcs).attack(Army.getRandomUnit(hums));
                System.out.println("");
                Army.getRandomUnit(hums).attack(Army.getRandomUnit(orcs));
                // add busy wait
                Thread.sleep(1000);
                //Thread.sleep(5000);
                if (Horde.getDeadUnits(orcs) != null || Humans.getDeadUnits(hums) != null) {
                    Horde.getDeadUnits(orcs);
                    Humans.getDeadUnits(hums);
                }
                Horde.remove(orcs);
                Humans.remove(hums);
                // Exception in thread "main" java.lang.AssertionError because of bad loop.
                // Loop not properly working. but np its only testing before gui setup.

            } else {
                System.out.println("Announce winner");
                if (Horde.getArmyHitpoints(orcs) > Humans.getArmyHitpoints(hums)) {
                    System.out.println("Orc wins");
                } else {
                    System.out.println("Human wins");
                }
            }
        }
        fh.writeUnits(orcs, orcFile);
        fh.writeUnits(hums, humanFile);
        fh.writeDeadUnits(orcs, deadOrcs);
        fh.writeDeadUnits(hums, deadHumans);
    }
}
