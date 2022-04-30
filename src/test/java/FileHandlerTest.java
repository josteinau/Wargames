import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerTest {


    // not 100% working.
    @Test
    public void testWriteUnits(){
        FileHandler fh = new FileHandler();
        try{
            List<Unit> units = new ArrayList<>();
            units.add(new CavalryUnit("Testunit",25));
            fh.writeUnits(units,new File("src/test/java/units.csv"));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testReadUnitsFromFile(){
        FileHandler fh = new FileHandler();
        try{
            List<Unit> units = fh.readUnits(new File("srcs/test/resources/units.csv"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
