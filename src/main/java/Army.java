import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Army {
    String name;
    ArrayList<Unit> units; // Feil? opprett i mainklassen ist

    public Army(String name) {
        this.name = name;
    }

    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = new ArrayList<Unit>();
    }

    public String getName() {
        return name;
    }

    public void addUnit(Unit newUnit) {
        units.add(newUnit);
    }

    public void addAll(List<Unit> newUnit) {
        for (int i = 0; i < units.size(); i++) {
            addUnit(newUnit.get(i));
        }
    }

    public void remove(Unit unit) {
        units.remove(unit);
    }

    // Checks if the list units has any units.
    public boolean hasUnits(List<Unit> units) {
        if (units.isEmpty() || units == null) {
            return false;
        }
        return true;
    }

    // prints all units to screen, working!
    public void getAllUnits(List<Unit> units) {
        for (int i = 0; i < units.size(); i++) {
            System.out.println(units.get(i) + " ");
        }
    }

    // Find random unit in the units-array. Tested and works!
    public Unit getRandomElement(List<Unit> units) {
        Random rand = new Random();
        int index = rand.nextInt(units.size());
        Unit randomUnit = units.get(index);
        return randomUnit;
    }

    // Print army to screen, missing attributes...
    public String toString() { // Add more toString
        return name + "[" + super.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Army otherArmy = (Army) obj;
        return this.name.equals(otherArmy.name);
    }

    public List<Unit> getInfantryUnits() {
        List<Unit> infUnit = units.stream().filter(item -> item instanceof InfantryUnit).collect(Collectors.toList());
        System.out.println("Called! + " + units.stream().filter(item -> item instanceof InfantryUnit).collect(Collectors.toList()));
        return infUnit;
    }
    // contains.obj

}
