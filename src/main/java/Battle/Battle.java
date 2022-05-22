package Battle;

import units.Unit;
import util.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the battle class which represents a battle between two armies.
 * Armies consist of many unit types. These units fight until one army kills the other army.
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;
    File deadOrcsFile = new File("deadOrcs.csv");
    File deadHumansFile = new File("deadHumans.csv");
    FileHandler fh = new FileHandler();
    ArrayList<Unit> deadHumans = new ArrayList<Unit>();
    ArrayList<Unit> deadOrcs = new ArrayList<Unit>();

    /**
     * Constructor for a battle between two armies with a given terrain-type.
     *
     * @param armyOne     consists of different unit types
     * @param armyTwo     consists of different unit types
     * @param terrainType enum terrain-type
     */
    public Battle(Army armyOne, Army armyTwo, Terrain terrainType) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;

        for (Unit unit : armyOne.getAllUnits()) {
            unit.setTerrainType(terrainType);
        }
        for (Unit unit : armyTwo.getAllUnits()) {
            unit.setTerrainType(terrainType);
        }
    }

    /**
     * This is a method that simulates a battle between two armies. armyOne starts the battle by choosing a random unit from armyTwo
     * to attack a random unit from armyTwo. If a unit dies, it is added to a .csv file with current attributes and removed from the battle.
     * The battle continues until one of the armies is destroyed! Winner is announced by a println.
     *
     * @return a print-line of the winning army
     * @throws InterruptedException
     * @throws IOException
     */
    public Army simulate() throws InterruptedException, IOException {
        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            Unit randomUnitArmyOne = armyOne.getRandomUnit();
            Unit randomUnitArmyTwo = armyTwo.getRandomUnit();

            armyOne.getRandomUnit().attack(randomUnitArmyTwo);

            if (randomUnitArmyTwo.getHealth() <= 0) {
                deadHumans.add(randomUnitArmyTwo);
                armyTwo.remove(randomUnitArmyTwo);
            } else {
                if (armyTwo.hasUnits()) {
                    armyTwo.getRandomUnit().attack(randomUnitArmyOne);

                    if (randomUnitArmyOne.getHealth() <= 0) {
                        deadOrcs.add(randomUnitArmyOne);
                        armyOne.remove(randomUnitArmyOne);
                    }
                }
            }
            System.out.println(" ");
            Thread.sleep(250);
        }
        fh.writeDeadUnits(deadHumans, deadHumansFile);
        fh.writeDeadUnits(deadOrcs, deadOrcsFile);
        if (armyOne.hasUnits()) {
            System.out.println(armyOne.getName() + " wins!");
            return armyOne;
        } else {
            System.out.println(armyTwo.getName() + " wins!");

            return armyTwo;
        }
    }

    /**
     * A simple toString method
     *
     * @return armyOne vs armyTwo
     */
    @Override
    public String toString() {
        return "Battle:\n" + armyOne + " VS " + armyTwo;
    }
}
