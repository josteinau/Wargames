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

    // 4 methods to get specific units into a list. Printed as: XXXX units: [1,2,..,n]
    public List<Unit> getInfantryUnits(List<Unit> units) {
        List<Unit> infUnits = units.stream().filter(item -> item instanceof InfantryUnit).collect(Collectors.toList());
        System.out.println("Infantry units:");
        return infUnits;
    }
    public List<Unit> getCavalryUnits(List<Unit> units) {
        List<Unit> cavUnits = units.stream().filter(item -> item instanceof CavalryUnit).collect(Collectors.toList());
        System.out.println("Cavalry units:");
        return cavUnits;
    }
    public List<Unit> getRangedUnits(List<Unit> units) {
        List<Unit> ranUnits = units.stream().filter(item -> item instanceof RangedUnit).collect(Collectors.toList());
        System.out.println("Ranged units:");
        return ranUnits;
    }
    public List<Unit> getCommanderUnits(List<Unit> units) {
        List<Unit> comUnits = units.stream().filter(item -> item instanceof CommanderUnit).collect(Collectors.toList());
        System.out.println("Commander units:");
        return comUnits;
    }


}
