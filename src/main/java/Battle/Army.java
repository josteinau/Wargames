package Battle;

import units.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This class represents an army. The army has a name and has a List of different unit-types.
 */
public class Army {
    String armyName;
    private List<Unit> units;

    /**
     * Checks if army-name is valid!
     *
     * @param name of the army
     * @throws IllegalArgumentException if the army is null or uses , or .
     */
    public Army(String name) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Army-name cannot be null");
        if (name.contains(",") || name.contains("."))
            throw new IllegalArgumentException("Army-name cannot contain , or .");
        this.armyName = name;
        this.units = new ArrayList<>();
    }

    /**
     * Constructor for the army
     *
     * @param name name of the army
     * @param unit list of different units
     */
    public Army(String name, List<Unit> unit) {
        this.armyName = name;
        this.units = unit;
    }

    /**
     * method to get the name of the army.
     *
     * @return the army-name
     */
    public String getName() {
        return armyName;
    }

    /**
     * Method to add a unit to units-list in army.
     *
     * @param newUnit the new unit added.
     */
    public void addUnit(Unit newUnit) {
        units.add(newUnit);
    }

    /**
     * Method to add all new units
     *
     * @param newUnit list of new units.
     */
    public void addAll(List<Unit> newUnit) {
        for(Unit unit : units){
            this.addUnit(unit);
        }
    }

    /**
     * Method to remove a unit from army, used to remove units from battle.
     *
     * @param removeUnit the unit removed.
     */
    public void remove(Unit removeUnit) {
        Iterator<Unit> iter = units.iterator();
        while (iter.hasNext()) {
            Unit unit = iter.next();
            if (unit.isDead()) {
                iter.remove();
            }
        }
    }

    /**
     * Method to check if the army has any units
     *
     * @return false if its empty or null, return true if else.
     */
    public boolean hasUnits() {
        if ((units.isEmpty() || units == null)) {
            return false;
        }
        return true;
    }

    /**
     * A method for getting the whole size of army
     * @return the size of the army as integer
     */
    public int getSize() {
        return units.size();
    }


    /**
     * method to get all units of army
     *
     * @return list of units
     */
    public List<Unit> getAllUnits() {
        return units;
    }

    /**
     * Method to find a random unit in the army.
     *
     * @return a random index(unit) from the list.
     */
    public Unit getRandomUnit() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(units.size());
        return units.get(randomIndex);
    }

    /**
     * A method to print the whole army to screen
     *
     * @param units list of units in the army
     * @return army with name of army + all the unit objects in the army List.
     */
    public String toString(List<Unit> units) {
        String results = "";
        for (Unit d : units) {
            results += d.toString() + ", "; //if you implement toString() for Dog then it will be added here
        }
        return armyName + " [" + results + "]";
    }

    /**
     * A method to check if a object is equal to another object
     *
     * @param obj
     * @return true if equal, false if not equal.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Army otherArmy = (Army) obj;
        return this.armyName.equals(otherArmy.armyName);
    }

    /**
     * A method to get all the infantry units of a units list.
     *
     * @param units list of different unit types.
     * @return infantry units of wanted list, [] if empty
     */
    public List<Unit> getInfantryUnits(List<Unit> units) {
        List<Unit> infUnits = units.stream().filter(item -> item instanceof InfantryUnit).collect(Collectors.toList());
        return infUnits;
    }

    /**
     * A method to get all the cavalry units of a units list.
     *
     * @param units list of different unit types.
     * @return cavalry units of wanted list, [] if empty
     */
    public List<Unit> getCavalryUnits(List<Unit> units) {
        List<Unit> cavUnits = units.stream().filter(item -> item instanceof CavalryUnit).collect(Collectors.toList());
        return cavUnits;
    }

    /**
     * A method to get all the ranged units of a units list.
     *
     * @param units list of different unit types.
     * @return ranged units of wanted list, [] if empty
     */
    public List<Unit> getRangedUnits(List<Unit> units) {
        List<Unit> ranUnits = units.stream().filter(item -> item instanceof RangedUnit).collect(Collectors.toList());
        return ranUnits;
    }

    /**
     * A method to get all the commander units of a units list.
     *
     * @param units list of different unit types.
     * @return commander units of wanted list, [] if empty
     */
    public List<Unit> getCommanderUnits(List<Unit> units) {
        List<Unit> comUnits = units.stream().filter(item -> item instanceof CommanderUnit).collect(Collectors.toList());
        return comUnits;
    }

    /**
     * A method to get all the dead units of a units-list
     *
     * @param units list you want to check
     * @return a list of dead units
     */
    public List<Unit> getDeadUnits(List<Unit> units) {
        List<Unit> deadUnits = units.stream().filter(unit -> unit.isDead()).collect(Collectors.toList());
        return deadUnits;
    }

    /**
     * A method to get an army's total health point at any point. Easier to see who is the favourite in terms of hp before or under the battle.
     *
     * @param units list of different unit types
     * @return integer of total army-health.
     */
    public int getArmyHitpoints(List<Unit> units) {
        int sum = 0;
        for (Unit unit : units) {
            sum += unit.getHealth();
        }
        return sum;
    }

    /**
     * A method to get an army's total damage at any point. May be easier indicate who is the favourite to win the fight.
     *
     * @param units list of different unit types
     * @return integer value with army total damage.
     */
    public int getArmyDamage(List<Unit> units) {
        int sum = 0;
        for (Unit unit : units) {
            sum += unit.getAttack() + unit.getAttackBonus();
        }
        return sum;
    }

    /**
     * A method to get an army's total armor at any point. May be easier indicate who is the favourite to win the fight.
     *
     * @param units list of different unit types
     * @return integer value with army total armor.
     */
    public int getArmyArmor(List<Unit> units) {
        Integer sum = units.stream().map(u -> u.getArmor()).reduce(0, (a, b) -> a + b);
        return sum;
    }
}
