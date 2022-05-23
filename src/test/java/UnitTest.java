
import Battle.Terrain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
        Assertions.assertEquals("CavalryTest(C)", cavalryUnit.getName());
        Assertions.assertEquals("CommanderTest(*)", commanderUnit.getName());
        Assertions.assertEquals("InfantryTest(I)", infantryUnit.getName());
        Assertions.assertEquals("RangedTest(R)", rangedUnit.getName());
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
}
