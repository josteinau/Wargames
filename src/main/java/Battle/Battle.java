package Battle;

public class Battle {
    private Army armyOne;
    private Army armyTwo;


    public Battle(Army armyOne, Army armytwo){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }
    public String simulate(){
        while(armyOne.hasUnits() && armyTwo.hasUnits()){
            System.out.println("hasunits");

        }
        return "lol";

    }
    // getAllUnits().attack().getAllUnits() etc
    // Alternate attacks getRandomUnit(); in for loop until army.size() is 0 or army.getTotalHealth <= 0.
}
