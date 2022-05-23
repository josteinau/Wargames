
import Battle.Army;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import units.*;
import util.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test if writing and reading from file works
 */

public class FileHandlerTest {
    FileHandler fh = new FileHandler();
    File humanFileTest = new File("humanFileTest.csv");
    File humanFileTestTxt = new File("humanFileTest2.txt");
    File deadHumanFileTest = new File("humanFileTest.csv");
    File deadHumanFileTestTxt = new File("humanFileTest2.txt");
    File humanFileTestNotExist = new File("lolol.csv");

    @Test
    public void testWriteToFileWithoutException() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        fh.writeUnits(hums,humanFileTest);
    }

    @Test
    public void testWriteToFileThatDoesNotExist() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        Assertions.assertThrows(IOException.class,() -> fh.writeUnits(hums,humanFileTestNotExist));
    }

    @Test
    public void testWriteToFileWithWrongFileFormat() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        Assertions.assertThrows(IOException.class,() -> fh.writeUnits(hums,humanFileTestTxt));
    }

    @Test
    public void readFromFile() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));
        fh.writeUnits(hums,humanFileTest);

        fh.readUnits(humanFileTest);
    }

    @Test
    public void readFromFileWithWrongFormat() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Aretha's", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        Assertions.assertThrows(IOException.class, () -> fh.readUnits(humanFileTestTxt));
    }

    @Test
    public void readFromFileThatDoesNotExist() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));

        Assertions.assertThrows(IOException.class, () -> fh.readUnits(humanFileTestNotExist));
    }

    @Test
    public void writeToDeadUnitsFile() throws IOException {
        List<Unit> hums = new ArrayList<>();
        Army Humans = new Army("Human army");
        hums.add(new CommanderUnit("Arthas", 100));
        hums.add(new InfantryUnit("Erik", 25));
        hums.add(new InfantryUnit("Per", 25));
        fh.writeDeadUnits(hums,deadHumanFileTest);
    }
}
