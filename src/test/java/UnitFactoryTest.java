import org.junit.jupiter.api.Test;
import units.CommanderUnit;
import units.Unit;
import units.UnitFactory;
import units.UnitType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test some methods of the UnitFactory-class
 */

public class UnitFactoryTest {
    UnitFactory unitFactory = new UnitFactory();

    /**
     * Used more factory-tests in other test classes!
     */

    @Test
    public void createOneSoldierAndCheckIfEqualToUnitCreatedManually(){
        UnitType type = UnitType.COMMANDER_UNIT;
        String name = "Arthas";
        int health = 200;
        Unit manualUnit = new CommanderUnit("Arthas",200);
        Unit factoryUnit = unitFactory.createUnit(type,name,health);
        assertTrue(manualUnit instanceof CommanderUnit);
        assertEquals(manualUnit.getHealth(), factoryUnit.getHealth());
        assertEquals(manualUnit.getAttack(), factoryUnit.getAttack());
    }
    @Test
    public void create10Units(){
        List<Unit> manyRangedUnits = new ArrayList<Unit>();
        manyRangedUnits = unitFactory.createManyUnits(10, UnitType.RANGED_UNIT, "RangedTesting", 29);
        assertEquals(manyRangedUnits.size(), 10);
    }
}
