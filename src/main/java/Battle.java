import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Battle {
    private List<Army> armyOne;
    private List<Army> armyTwo = new ArrayList<>();


    public Battle(){
        this.armyOne = new ArrayList<>();
        this.armyTwo = new ArrayList<>();
    }
    public void armyBattle(List<Army> armyOne, List<Army> armyTwo){

    }
    // getAllUnits().attack().getAllUnits() etc
    // Alternate attacks getRandomUnit(); in for loop until army.size() is 0 or army.getTotalHealth <= 0.
}
