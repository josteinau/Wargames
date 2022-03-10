import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {
    String name;
    List<Unit> units; // Feil? opprett i mainklassen ist

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

    public void addAll(List<Unit> units) {

    }

    public void remove(Unit unit) {
        units.remove(unit);
    }

    // Checks if the list units has any units.
    public boolean hasUnits() {
        if (units.isEmpty() || units == null) {
            return false;
        }
        return true;
    }

    // prints all units to screen, not tested.
    public void getAllUnits(List<Unit> units) {
        for (int i = 0; i < units.size(); i++) {
            System.out.println(units.get(i) + " ");
        }
    }

    // Find random unit in the units-array.
    public Unit getRandomElement() {
        Random rand = new Random();
        int index = rand.nextInt(units.size());
        Unit randomUnit = units.get(index);
        return randomUnit;
    }

    // Print army to screen, missing attributes...
    public String toString() { // Add more toString
        return "Army with name: " + name + "";
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
}
