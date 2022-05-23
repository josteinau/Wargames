package units;

import java.util.ArrayList;
import java.util.List;

/**
 *  This is a factory of creating units.
 */
public class UnitFactory {

    /**
     * Method to create units based on unit-type, give them a name and health!
     * @param type of unit you want to create
     * @param name your unit!
     * @param health amount of the unit you want to create.
     * @return a new unit of your chosen type, name and health!
     * @throws IllegalArgumentException if somehow you chose a unit type that does not exist!
     */
    public static Unit createUnit(UnitType type, String name, int health) throws IllegalArgumentException {
        if (type == null)
            return null;
        switch (type) {
            case CAVALRY_UNIT:
                return new CavalryUnit(name, health);
            case INFANTRY_UNIT:
                return new InfantryUnit(name, health);
            case RANGED_UNIT:
                return new RangedUnit(name, health);
            case COMMANDER_UNIT:
                return new CommanderUnit(name, health);
            default:
                throw new IllegalArgumentException("Unknown unit-type: " + type);
        }
    }

    /**
     * Method to create lots of units quickly!
     * @param numOfUnits is the number of units you want to create
     * @param unitType is the type of units you want to create
     * @param name is the name of the units you want to create
     * @param health is the health points of the units you are creating
     * @return lots of units with given attributes.
     * @throws IllegalArgumentException if logic is not met
     */
    public List<Unit> createManyUnits(int numOfUnits, UnitType unitType, String name, int health) throws IllegalArgumentException {
        ArrayList<Unit> factoryUnits = new ArrayList<Unit>();
        try {
            for (int i = 0; i < numOfUnits; i++) {
                factoryUnits.add(createUnit(unitType, name, health));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException ("Unit type does not exist, giving error: " + e);
        }
        return factoryUnits;
    }
}
