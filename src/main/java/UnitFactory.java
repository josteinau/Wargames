import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnitFactory {

    public Unit createUnit(String type) {
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
            case "Cavalry":
                return new CavalryUnit("StandardCavalryUnit", 25);
            case "Infantry":
                return new InfantryUnit("StandardInfantryUnit", 25);
            case "Range":
                return new RangedUnit("StandardRange", 25);
            case "Commander":
                return new CommanderUnit("StandardCommander", 100);
            default:
                throw new IllegalArgumentException("Unknown unit-type: " + type);
        }
    }

    // Creates n number of standard-units of a chosen type
    public void chooseUnitsFromFactory(List<Unit> units) throws IOException {
        List<Unit> factoryUnits = new ArrayList<Unit>();
        System.out.print("Enter name of unit to add. Commander/Cavalry/Infantry/Range ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String type = br.readLine();
        System.out.print("Enter the number of units to be added: ");
        int numUnits = Integer.parseInt(br.readLine());
        for (int i = 0; i < numUnits; i++) {
            Unit p = createUnit(type);
            factoryUnits.add(p);
        }
    }
}
