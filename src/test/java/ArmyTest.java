import Battle.Army;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import units.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ArmyTest {
    CavalryUnit cavalryUnit;
    CommanderUnit commanderUnit;
    InfantryUnit infantryUnit;
    RangedUnit rangedUnit;
    UnitFactory unitFactory;
    List<Unit> manyRangedUnits = new ArrayList<Unit>();
    List<Unit> manyInfantryUnits = new ArrayList<Unit>();
    List<Unit> manyCommanderUnits = new ArrayList<Unit>();

    @BeforeEach
    void createUnits() {
        unitFactory = new UnitFactory();
        cavalryUnit = (CavalryUnit) unitFactory.createUnit(UnitType.CAVALRY_UNIT, "CavalryTest", 25);
        commanderUnit = (CommanderUnit) unitFactory.createUnit(UnitType.COMMANDER_UNIT, "CommanderTest", 100);
        infantryUnit = (InfantryUnit) unitFactory.createUnit(UnitType.INFANTRY_UNIT, "InfantryTest", 25);
        rangedUnit = (RangedUnit) unitFactory.createUnit(UnitType.RANGED_UNIT, "RangedTest", 29);

        manyRangedUnits = unitFactory.createManyUnits(10, UnitType.RANGED_UNIT, "RangedTesting", 29);
        manyInfantryUnits = unitFactory.createManyUnits(7, UnitType.INFANTRY_UNIT, "INFTesting", 34);
        manyCommanderUnits = unitFactory.createManyUnits(4, UnitType.COMMANDER_UNIT, "COmmTesting", 340);
    }

    @Test
    public void testCreateArmyInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Army(""));
        assertThrows(IllegalArgumentException.class, () -> new Army("."));
    }

    @Test
    public void addUnitToArmyCheckSizeAfterAdding() {
        List<units.Unit> orcs = new ArrayList<Unit>();
        Army army = new Army("The orcish Horde", orcs);
        army.addUnit(infantryUnit);
        army.addUnit(infantryUnit);
        army.addUnit(rangedUnit);
        assertEquals(army.getSize(), 3);
    }

    @Test
    public void addManyUnitsToArmyAndCheckSize() {
        List<units.Unit> orcs = new ArrayList<Unit>();
        Army army = new Army("The orcish Horde", orcs);
        army.addUnit(infantryUnit);
        army.addUnit(infantryUnit);
        army.addUnit(rangedUnit);
        assertEquals(army.getSize(), 3);

        List<Unit> newOrcs = new ArrayList<Unit>();
        newOrcs.add(new InfantryUnit("Testing", 25));
        newOrcs.add(new InfantryUnit("Testing", 25));
        newOrcs.add(new InfantryUnit("Testing", 25));
        orcs.addAll(newOrcs);
        assertEquals(army.getSize(), 6);

        orcs.addAll(manyRangedUnits);
        assertEquals(army.getSize(), 16);
    }

    @Test
    public void removeRandomUnitFromArmy() {
        List<units.Unit> orcs = new ArrayList<Unit>();
        Army army = new Army("The orcish Horde", orcs);
        army.addUnit(infantryUnit);
        army.addUnit(infantryUnit);
        assertEquals(army.getSize(), 2);
        orcs.remove(army.getRandomUnit());
        assertEquals(army.getSize(), 1);
    }

    @Test
    public void getAllInfantryUnitsFromMixedUnitsList() {
        List<units.Unit> orcs = new ArrayList<Unit>();
        Army army = new Army("The orcish Horde", orcs);
        orcs.addAll(manyInfantryUnits);
        orcs.addAll(manyCommanderUnits);
        orcs.addAll(manyRangedUnits);
        assertEquals(army.getInfantryUnits(orcs).size(), 7);
    }

    @Test
    public void getAllCommanderUnitsFromMixedUnitsList() {
        List<units.Unit> orcs = new ArrayList<Unit>();
        Army army = new Army("The orcish Horde", orcs);
        orcs.addAll(manyInfantryUnits);
        orcs.addAll(manyCommanderUnits);
        orcs.addAll(manyRangedUnits);
        assertEquals(army.getCommanderUnits(orcs).size(), 4);
    }

    @Test
    public void getArmyHitpoints() {
        List<units.Unit> orcs = new ArrayList<Unit>();
        Army army = new Army("The orcish Horde", orcs);
        orcs.addAll(manyInfantryUnits);
        orcs.addAll(manyCommanderUnits);
        orcs.addAll(manyRangedUnits);
        assertEquals(army.getArmyHitpoints(orcs), 1888);
    }
}
