
import Battle.Terrain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import units.*;

public class UnitTest {
    CavalryUnit cavalryUnit;
    CommanderUnit commanderUnit;
    InfantryUnit infantryUnit;
    RangedUnit rangedUnit;
    UnitFactory unitFactory;

    @BeforeEach
    void createUnits() {
        unitFactory = new UnitFactory();
        cavalryUnit = (CavalryUnit) unitFactory.createUnit(UnitType.CAVALRY_UNIT, "CavalryTest", 25);
        commanderUnit = (CommanderUnit) unitFactory.createUnit(UnitType.COMMANDER_UNIT, "CommanderTest", 100);
        infantryUnit = (InfantryUnit) unitFactory.createUnit(UnitType.INFANTRY_UNIT, "InfantryTest", 25);
        rangedUnit = (RangedUnit) unitFactory.createUnit(UnitType.RANGED_UNIT, "RangedTest", 29);
    }

    @Test
    public void getName() {
        Assertions.assertEquals("CavalryTest", cavalryUnit.getName());
        Assertions.assertEquals("CommanderTest", commanderUnit.getName());
        Assertions.assertEquals("InfantryTest", infantryUnit.getName());
        Assertions.assertEquals("RangedTest", rangedUnit.getName());
    }

    @Test
    public void getHealth() {
        Assertions.assertEquals(25, cavalryUnit.getHealth());
        Assertions.assertEquals(100, commanderUnit.getHealth());
        Assertions.assertEquals(25, infantryUnit.getHealth());
        Assertions.assertEquals(29, rangedUnit.getHealth());
    }

    @Test
    public void getAttack() {
        Assertions.assertEquals(20, cavalryUnit.getAttack());
        Assertions.assertEquals(25, commanderUnit.getAttack());
        Assertions.assertEquals(15, infantryUnit.getAttack());
        Assertions.assertEquals(15, rangedUnit.getAttack());
    }

    @Test
    public void getArmor() {
        Assertions.assertEquals(12, cavalryUnit.getArmor());
        Assertions.assertEquals(15, commanderUnit.getArmor());
        Assertions.assertEquals(10, infantryUnit.getArmor());
        Assertions.assertEquals(8, rangedUnit.getArmor());
    }
    @Test
    public void getResistBonus(){
        Assertions.assertEquals(5,cavalryUnit.getResistBonus());
    }
    @Test
    public void getAttackBonus(){
        Assertions.assertEquals(3,cavalryUnit.getAttackBonus());
    }
    @Test
    public void getResistBonusTerrain(){
        cavalryUnit.setTerrainType(Terrain.FOREST);
        Assertions.assertEquals(0,cavalryUnit.getResistBonus());
    }
    @Test
    public void getAttackBonusTerrain(){
        cavalryUnit.setTerrainType(Terrain.PLAINS);
        Assertions.assertEquals(9,cavalryUnit.getAttackBonus());
        cavalryUnit.setTerrainType(Terrain.HILL);
        Assertions.assertEquals(3,cavalryUnit.getAttackBonus());
    }
    @Test
    /**
     * Will not cast exception on null name because i added (I) etc for each unit type, if i remove this it will work.
     * But i would rather have the indicator of the unit and fail this test. Removing the indicator from the constructors will "fix" the test.
     * Update - removed indicators for now.
     */
    public void testExceptionsOnIllegalArguments(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> unitFactory.createUnit(UnitType.INFANTRY_UNIT,"Names",-2));
        Assertions.assertThrows(IllegalArgumentException.class,() -> infantryUnit.setName(""));
        Assertions.assertThrows(IllegalArgumentException.class,() -> unitFactory.createUnit(UnitType.INFANTRY_UNIT,"",10));
    }
    @Test
    public void attack(){
        Assertions.assertEquals(100,commanderUnit.getHealth());
        cavalryUnit.attack(commanderUnit);
        Assertions.assertEquals(92,commanderUnit.getHealth());
        commanderUnit.attack(cavalryUnit);
        Assertions.assertEquals(false,cavalryUnit.isDead());
    }
}
