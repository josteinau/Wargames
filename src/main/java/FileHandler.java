import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* The FileHandler makes it possible to write and read Units to and from a file.
They are given in the following format:
Unit-type Unit-name(x) Unit-health. x represents a letter that indicates which type of unit.
 */
public class FileHandler {
    final String PATH =  "src" + File.separator + "main" + File.separator + "resources";
    private static final String NEWLINE = "\n";
    Scanner scan = new Scanner(System.in);
    List<Army> army;

    // Writes a list of units to a .csv file.
    public void writeUnits(List<Unit> units, File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            String armyName = file.getName().substring(0, file.getName().lastIndexOf("."));
            fileWriter.write(armyName + "-army" + "\n");
            for (Unit unit : units) {
                if (unit.getHealth() > 0) { // as required. but not a fan of this
                    String line = unit.getClass().getName() + " " + unit.getName() + " " + unit.getHealth();
                    fileWriter.write(line + NEWLINE);
                }
            }
            System.out.println("Units to file completed!"); // According to JavaDoc files are closed in Files.write
        } catch (IOException e) {
            throw new IOException("unable to write unit file: " + e.getMessage());
        }
    }


    // Reads unit from .csv file.
    // Unable to fix the army class properly. get error when trying to read file at firstline.
    // Unable to add the units to the readable file.
    public List<Unit> readUnits(File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        List<Unit> units = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                if (tokens.length != 3) {
                    throw new IOException("Line data '" + line + "' is invalid. " +
                            "Make sure each line is on the form 'Unit-type Unit-name Unit-health)'");
                }
                int hp;
                try {
                    hp = Integer.parseInt(tokens[2]);
                } catch (NumberFormatException e) {
                    throw new IOException("hp must be integer(" + e.getMessage() + ")");
                }
                String obj = units.getClass().getName();
                obj = tokens[0];
                String name = tokens[1];
                // Unit unit = new Unit(obj, name, hp);
                //add.(unit)
                //
            }
        } catch (IOException e) {
            throw new IOException(("Unable to read unit data from file '" + file.getName() + "':" + e.getMessage()));
        }
        return units;
    }

    // Not required, but easier to find all dead units in own .csv file
    public void writeDeadUnits(List<Unit> units, File file) throws IOException {
        if (!file.getName().endsWith(".csv")) {
            throw new IOException("Wrong file format, only filename.csv allowed!");
        }
        try (FileWriter fileWriter2 = new FileWriter(file)) {
            fileWriter2.write("✟RIP✟" + "\n");
            for (Unit unit : units) {
                if (unit.isDead()) {
                    String line = unit.getClass().getName() + " " + unit.getName() + " " + unit.getHealth();
                    fileWriter2.write(line + NEWLINE);
                }
            }
            System.out.println("Dead units to file completed!");
        } catch (IOException e) {
            throw new IOException("unable to write unit file: " + e.getMessage());
        }
    }

    // Simple write to file method. Not 100% yet. Gonna use BUFFEREDREADER!  -> Method not needed for now.
    public void writeToFile(File file) {
        Scanner scan = new Scanner(System.in);
        FileWriter fileWriter = null;
        try {
            // Add BUFFEREDREADER here.
            fileWriter = new FileWriter(file);
            String input = scan.nextLine();
            fileWriter.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    scan.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
