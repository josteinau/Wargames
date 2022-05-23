package util;

import Battle.Army;
import units.Unit;
import units.UnitFactory;
import units.UnitType;

import java.io.*;
import java.util.List;

/**
 * The FileHandler makes it possible to write and read Units to and from a file.
 * They are given in the following format:
 * Utype Unit-name(x) Unit-health. x represents a letter that indicates whtype of unit.
 */
public class FileHandler {
    final String PATH = "src" + File.separator + "main" + File.separator + "resources";
    private static final String NEWLINE = "\n";

    /**
     * This method writes units to a file, with Army-name followed by every utype, unit-name and current health.
     *
     * @param units the list you want to write to the file
     * @param file  the file you want to write to
     * @throws IOException if wrong file format, not exist or unable to write to the file.
     */
    public void writeUnits(List<Unit> units, File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            String armyName = file.getName().substring(0, file.getName().lastIndexOf("."));
            fileWriter.write(armyName + "-army" + NEWLINE);
            for (Unit unit : units) {
                if (unit.getHealth() > 0) { // as required. but not a fan of this
                    String line = unit.getClass().getName().substring(6) + " " + unit.getName() + " " + unit.getHealth();
                    fileWriter.write(line + NEWLINE);
                }
            }
        } catch (IOException e) {
            throw new IOException("unable to write unit file: " + e.getMessage());
        }
    }

    /**
     * Reads wanted file with a list of units written in writeUnits method
     *
     * @param file you want to read from
     * @return
     * @throws IOException              if it's not possible to read data from file or if writing to wrong fileformat.
     * @throws IllegalArgumentException if corrupted data
     */
    public Army readUnits(File file) throws IOException, IllegalArgumentException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine = reader.readLine();
            if (currentLine == null || currentLine.split(",").length != 1)
                throw new IllegalArgumentException("Army name not found");
            Army army = new Army(currentLine);

            while ((currentLine = reader.readLine()) != null) {
                String[] unitAttributes;
                unitAttributes = currentLine.split(" ");
                if (unitAttributes.length != 3) throw new IllegalArgumentException("file contains corrupted Units");

                int health;
                String name = unitAttributes[1];
                try {
                    health = Integer.parseInt(unitAttributes[2]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("file contains units with corrupted Health");
                }
                if (health <= 0) throw new IllegalArgumentException("Illegal health value");
                switch (unitAttributes[0]) {
                    case "CavalryUnit" -> army.addUnit(UnitFactory.createUnit(UnitType.CAVALRY_UNIT, name, health));
                    case "CommanderUnit" -> army.addUnit(UnitFactory.createUnit(UnitType.COMMANDER_UNIT, name, health));
                    case "InfantryUnit" -> army.addUnit(UnitFactory.createUnit(UnitType.INFANTRY_UNIT, name, health));
                    case "RangedUnit" -> army.addUnit(UnitFactory.createUnit(UnitType.RANGED_UNIT, name, health));
                }
            }
            return army;
        }
    }

    /**
     * Not required, but easier to find all dead units in own .csv file
     *
     * @param units list of all the dead units
     * @param file  a file made for dead units only.
     * @throws IOException if it's not possible to write data to file or if writing to wrong fileformat.
     */
    public void writeDeadUnits(List<Unit> units, File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }
        try (FileWriter fileWriter2 = new FileWriter(file)) {
            fileWriter2.write("✟RIP✟" + "\n");
            for (Unit unit : units) {
                if (unit.isDead()) {
                    String line = unit.getClass().getName().substring(6) + " " + unit.getName() + " " + unit.getHealth();
                    fileWriter2.write(line + NEWLINE);
                }
            }
        } catch (IOException e) {
            throw new IOException("unable to write unit file: " + e.getMessage());
        }
    }
}
