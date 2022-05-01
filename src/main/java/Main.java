import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler();
        final String PATH =  "src" + File.separator + "main" + File.separator + "resources";

        System.out.println("HUMAN VS ORCS!");

        List<Unit> hums = new ArrayList<Unit>();
        List<Unit> orcs = new ArrayList<Unit>();
        Army Horde = new Army("Orcarmy", orcs);
        Army Humans = new Army("Human army", hums);

        orcs.add(new InfantryUnit("Orc 1",25));
        orcs.add(new InfantryUnit("Orc 2",25));
        orcs.add(new InfantryUnit("Orc 3",25));


        hums.add(new CommanderUnit("Arthas",100));


        System.out.println(Horde.getArmyHitpoints(orcs));
        System.out.println(Humans.getArmyHitpoints(hums));
        while(Horde.getArmyHitpoints(orcs) > 0 && Humans.getArmyHitpoints(hums) > 0){

            // each iteration check if any unit is dead, and remove them from battle.
            Army.getRandomUnit(orcs).attack(Army.getRandomUnit(hums));
            Army.getRandomUnit(hums).attack(Army.getRandomUnit(orcs));
            System.out.println(Horde.getArmyHitpoints(orcs));
            System.out.println(Humans.getArmyHitpoints(hums));
            Horde.remove();
            Humans.remove();


        }

        /*
        public void battle() {
            for (int i = 0; i < orcs.size(); i++){



 if(Army.hasUnits) Continue else stop.
            }
        }

         */





        /*Horde.getRandomUnit(orcs);

        System.out.println(Horde.getRandomUnit(orcs));
         */







        // Alive and dead units after battle.
        File file = new File("Orcs.csv");
        File humanFile = new File("Humans.csv");
        File deadOrcs = new File("deadOrcs.csv");
        File deadHumans = new File("deadHumans.csv");
        // Legg til army.getName() her som skrives inn i fila
        fh.writeUnits(orcs, file);
        fh.writeUnits(hums,humanFile);
        fh.writeDeadUnits(orcs, deadOrcs);
        fh.writeDeadUnits(hums, deadHumans);
        }
}