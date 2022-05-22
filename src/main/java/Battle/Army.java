package Battle;

import units.*;

import java.util.*;
import java.util.stream.Collectors;

public class Army {
    String armyName;
    List<Unit> units;
    Terrain terrain;

    public Army(String name) throws IllegalArgumentException {
        if(name.isBlank()) throw new IllegalArgumentException("Battle.Army-name cannot be null");
        if(name.contains(",") || name.contains(".")) throw new IllegalArgumentException("Battle.Army-name cannot contain , or .");
        this.armyName = name;
        this.units = new ArrayList<>();
    }

    public Army(String name, ArrayList<Unit> unit) {
        this.armyName = name;
        this.units = unit;
    }

    public String getName() {
        return armyName;
    }

    public void addUnit(Unit newUnit) {
        units.add(newUnit);
    }

    public void addAll(List<Unit> newUnit) {
        for (int i = 0; i < units.size(); i++) {
            addUnit(newUnit.get(i));
        }
    }

    // Removes unit from battle.
    public void remove(List<Unit> units) {
        Iterator<Unit> iter = units.iterator();
        while (iter.hasNext()) {
            Unit unit = iter.next();
            if (unit.isDead()) {
                iter.remove();
            }
        }
    }

    // Checks if the units-list has any units. fjernet list List<units.Unit> units i arg
    public boolean hasUnits() {
        if ((units.isEmpty() || units == null)) {
            return false;
        }
        return true;
    }

    // Prints all units to screen, ex: Horde.getAllUnits(orcs); List<units.Unit> units
    public List<Unit> getAllUnits(List<Unit> units) {
        List<Unit> u = new ArrayList<Unit>();
        for (int i = 0; i < units.size(); i++) {
            System.out.println(units.get(i) + " ");
        }
        return u;
    }

    // Optional to getRandomElement
    public static <T> T getRandomUnit(Collection<T> coll) {
        int num = (int) (Math.random() * coll.size());
        for (T t : coll) if (--num < 0) return t;
        throw new AssertionError();
    }

    /**
     *Prints the army with name of army + all the unit objects in the army List.
     */
    public String toString(List<Unit> units) {
        String results = "";
        for (Unit d : units) {
            results += d.toString() + ", "; //if you implement toString() for Dog then it will be added here
        }
        return armyName + " [" + results + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Army otherArmy = (Army) obj;
        return this.armyName.equals(otherArmy.armyName);
    }

    // 4 methods to get specific units into a list. In lambda and stream as required.
    // Printed as: XXXX units: [1,2,..,n] -> Returns [] if empty
    public List<Unit> getInfantryUnits(List<Unit> units) { //List<units.Unit> units
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
    // Experimenting with different approaches!

    // Finds all dead units after battle. Returns them to a List.
    public List<Unit> getDeadUnits(List<Unit> units) {
        List<Unit> deadUnits = units.stream().filter(unit -> unit.isDead()).collect(Collectors.toList());
        return deadUnits;
    }

    // Returns total army health
    public int getArmyHitpoints(List<Unit> units) {
        int sum = 0;
        for (Unit unit : units) {
            sum += unit.getHealth();
        }
        return sum;
    }

    // Returns total army damage
    public int getArmyDamage(List<Unit> units) {
        int sum = 0;
        for (Unit unit : units) {
            sum += unit.getAttack() + unit.getAttackBonus();
        }
        return sum;
    }

    // Returns total army armor
    public int getArmyArmor(List<Unit> units) {
        Integer sum = units.stream().map(u -> u.getArmor()).reduce(0, (a, b) -> a + b);
        return sum;
    }

    // get total resbonus etc...
    // Method to calculate which is the favourite in terms of damage/armor/hp

    // need to add checks for that the correct unitlist is chosen from correct army.
}
