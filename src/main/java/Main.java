import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler();
        final String PATH =  "src" + File.separator + "main" + File.separator + "resources";
        List<Unit> hums = new ArrayList<Unit>();
        List<Unit> orcs = new ArrayList<Unit>();
        Army Horde = new Army("Orcarmy", orcs);
        Horde.addUnit(new CavalryUnit("lol",3245));
        Horde.addUnit(new CavalryUnit("lol",3245));
        Horde.addUnit(new CavalryUnit("lol",3245));
        Horde.addUnit(new InfantryUnit("lol",3245));

        System.out.println(Horde.hasUnits());
        System.out.println("returning all units");
        System.out.println(Horde.getAllUnits());

        Horde.getInfantryUnits(orcs);
        System.out.println("end");

        /*Horde.getRandomUnit(orcs);

        System.out.println(Horde.getRandomUnit(orcs));
         */
        System.out.println("Tostring ehre");
        System.out.println(Horde.toString());






        Horde.addUnit(new CavalryUnit("lol",3245));
        orcs.add(new CavalryUnit("Unit22",25));
        hums.add(new RangedUnit("Unit22",25));

        hums.add(new CommanderUnit("LOLLO",25));


        File file = new File("Testing.csv");
        File humanFile = new File("humans.csv");
        // Legg til army.getName() her som skrives inn i fila
        fh.writeUnits(orcs, file);
        fh.writeUnits(hums,humanFile);
        }
}