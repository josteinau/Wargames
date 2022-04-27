public class CommanderUnit extends CavalryUnit{

    // Carry +tier unit, + armor, + health, + attack
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name + " (*)", health, attack, armor);
    }

    // (*) = commander unit i print

    public CommanderUnit(String name, int health) {
        super(name, health, 25,15);
    }
}
