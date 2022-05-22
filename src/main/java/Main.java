import Battle.Army;
import Battle.Battle;
import jdk.swing.interop.SwingInterOpUtils;
import units.*;
import util.FileHandler;
import Battle.Terrain;

import java.io.File;
import java.io.IOException;
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


        Army Horde = new Army("Orcarmy");
        Army Humans = new Army("Human army");

        Army testOrc = new Army("Horde",orcs);
        Army testHums = new Army("Humans",hums);

        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        // Adding premade army
        orcs.add(new CommanderUnit("Thrall", 150));
        orcs.add(new InfantryUnit("Grom", 40));
        orcs.add(new InfantryUnit("Khal", 25));
        orcs.add(new RangedUnit("Gork", 25));
        fh.writeUnits(orcs, orcFile);
        fh.writeUnits(hums, humanFile);

        Battle bts = new Battle(testOrc,testHums,Terrain.FOREST);

        Thread.sleep(144);

        bts.simulate();

        fh.writeUnits(orcs, orcFile);
        fh.writeUnits(hums, humanFile);


    }
}
