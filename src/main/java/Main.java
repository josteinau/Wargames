import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler();


        List<Unit> orcs = new ArrayList<Unit>();
        orcs.add(new CavalryUnit("Unit",25));
        orcs.add(new CavalryUnit("Unit22",25));
        orcs.add(new RangedUnit("Unit22",25));
        orcs.add(new CommanderUnit("Unit22",25));

        Army Horde = new Army("Orcarmy", orcs);
        System.out.println(Horde);
        File file = new File("Testing.csv");
        // Legg til army.getName() her som skrives inn i fila
        fh.writeUnits(orcs, file);
        fh.readUnits(file);
        }
}