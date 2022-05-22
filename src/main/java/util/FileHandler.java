package util;

import units.Unit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The FileHandler makes it possible to write and read Units to and from a file.
 * They are given in the following format:
 * Unit-type Unit-name(x) Unit-health. x represents a letter that indicates which type of unit.
 */
public class FileHandler {
    final String PATH = "src" + File.separator + "main" + File.separator + "resources";
    private static final String NEWLINE = "\n";

    /**
     * This method writes units to a file, with Army-name followed by every unit-type, unit-name and current health.
     *
     * @param units the list you want to write to the file
     * @param file  the file you want to write to
     * @throws IOException if wrong file format or unable to write to the file.
     */
    public void writeUnits(List<Unit> units, File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
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
            System.out.println("Alive units to file completed!"); // According to JavaDoc files are closed in Files.write
        } catch (IOException e) {
            throw new IOException("unable to write unit file: " + e.getMessage());
        }
    }

    /**
     * Reads wanted file with a list of units written in writeUnits method
     *
     * @param file you want to read from
     * @return a list of units
     * @throws IOException if it's not possible to read data from file or if writing to wrong fileformat.
     */
    public List<Unit> readUnits(File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        List<Unit> units = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                if (tokens.length != 3) {
                    throw new IOException("Line data '" + line + "' is invalid. " +
                            "Make sure each line is on the form 'units.Unit-type units.Unit-name units.Unit-health)'");
                }
            }
        } catch (IOException e) {
            throw new IOException(("Unable to read unit data from file '" + file.getName() + "':" + e.getMessage()));
        }
        return units;
    }

    /**
     * Not required, but easier to find all dead units in own .csv file
     *
     * @param units list of all the dead units
     * @param file  a file made for dead units only.
     * @throws IOException if it's not possible to write data from file or if writing to wrong fileformat.
     */
    public void writeDeadUnits(List<Unit> units, File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        try (FileWriter fileWriter2 = new FileWriter(file)) {
            fileWriter2.write("✟RIP✟" + "\n");
            for (Unit unit : units) {
                if (unit.isDead()) {
                    String line = unit.getClass().getName().substring(6) + " " + unit.getName() + " " + unit.getHealth();
                    fileWriter2.write(line + NEWLINE);
                }
            }
            System.out.println("Dead units to file completed!");
        } catch (IOException e) {
            throw new IOException("unable to write unit file: " + e.getMessage());
        }
    }
}
