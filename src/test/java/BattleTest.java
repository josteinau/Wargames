import Battle.Army;
import Battle.Battle;
import Battle.Terrain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import units.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A Class to test some of the methods in the battle-class
 */

public class BattleTest {
    CavalryUnit cavalryUnit;
    CommanderUnit commanderUnit;
    InfantryUnit infantryUnit;
    RangedUnit rangedUnit;
    UnitFactory unitFactory;
    List<Unit> manyRangedUnits = new ArrayList<Unit>();
    List<Unit> manyInfantryUnits = new ArrayList<Unit>();
    List<Unit> manyCommanderUnits = new ArrayList<Unit>();

    List<units.Unit> orcs = new ArrayList<Unit>();
    List<units.Unit> hoomans = new ArrayList<Unit>();
    Army armyOne = new Army("Orc", orcs);
    Army armyTwo = new Army("Humans", hoomans);


    @BeforeEach
    void createUnits() {
        unitFactory = new UnitFactory();
        cavalryUnit = (CavalryUnit) unitFactory.createUnit(UnitType.CAVALRY_UNIT, "CavalryTest", 25);
        commanderUnit = (CommanderUnit) unitFactory.createUnit(UnitType.COMMANDER_UNIT, "CommanderTest", 100);
        infantryUnit = (InfantryUnit) unitFactory.createUnit(UnitType.INFANTRY_UNIT, "InfantryTest", 25);
        rangedUnit = (RangedUnit) unitFactory.createUnit(UnitType.RANGED_UNIT, "RangedTest", 29);

        manyRangedUnits = unitFactory.createManyUnits(10, UnitType.RANGED_UNIT, "RangedTesting", 29);
        manyInfantryUnits = unitFactory.createManyUnits(7, UnitType.INFANTRY_UNIT, "InfTesting", 34);
        manyCommanderUnits = unitFactory.createManyUnits(8, UnitType.COMMANDER_UNIT, "ComTesting", 340);

    }

    @Test
    void simulateBattleCheckWinnerInBattleWhereArmyOneWillBeWinner() throws IOException, InterruptedException {
        orcs.addAll(manyCommanderUnits);
        hoomans.addAll(manyInfantryUnits);
        Battle bt = new Battle(armyOne, armyTwo, Terrain.FOREST);
        bt.simulate();
        assertTrue(armyOne.getSize() > 4);
        assertFalse(armyTwo.getSize() > 0);
    }
}
