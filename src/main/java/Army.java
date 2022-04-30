import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Army {
    String name;
    List<Unit> units;

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

    // Fix remove function to return new array without deleted obj?
    public void remove() {
        List<Unit> newUsers = new ArrayList<Unit>();
        for (Unit unit : units)
        {
            if (unit.isDead())
            {
                newUsers.add(unit);
            }
        }
        units = newUsers;
        System.out.println("Removed");
    }

    // Checks if the units-list has any units.
    public boolean hasUnits() {
        List<Unit> u = new ArrayList<Unit>();
        if (units.isEmpty() || units == null) {
            return false;
        }
        return true;
    }

    // Prints all units to screen, ex: Horde.getAllUnits(orcs);
    public List<Unit> getAllUnits() {
        List<Unit> u = new ArrayList<Unit>();
        for (int i = 0; i < units.size(); i++) {
            System.out.println(units.get(i) + " ");
        }
        return u;
    }

    // Find random unit in the units-array. Tested and works!
    public Unit getRandomUnit() {
        List<Unit> units = getAllUnits();
        if(!units.isEmpty()){
            Random rand = new Random();
            int index = rand.nextInt(units.size());
            Unit randomUnit = units.get(index);
            return randomUnit;
        }
        return null;
    }

    // FIX THE TOSTRING METHOD ATM ITS PRINTING army.getName()+[[]
    public String toString() {
        String results = "+";
        for(Unit d : units) {
            results += d.toString(); //if you implement toString() for Dog then it will be added here
        }
        return name + " [" + results + "]";
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

    // 4 methods to get specific units into a list. In lambda and stream as required.
    // Printed as: XXXX units: [1,2,..,n] -> Returns [] if empty
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


    // Not required methods.

    // Returns the armys total healthpoints.
    public int getArmyHitpoints(List<Unit> units) {
        int sum = 0;
        for (Unit unit : units) {
            sum += unit.getHealth();
        }
        return sum;
        //int sumHealthpoints = units.stream().map(s -> s.getHealth()).reduce((a1,a2)a1+a2).get();
    }
    // get total damage
    // get total armor
    // get total resbonus etc...
    // Create default-values in constructors??

    // need to add checks for that the correct unitlist is chosen from correct army.


}
