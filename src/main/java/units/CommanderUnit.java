package units;

/**
 * Class for a commander unit, which can do ranged and melee damage. These are elite tier units!
 * Commander units has Very high health, very high armor and very high attack damage.
 */
public class CommanderUnit extends CavalryUnit {

    /**
     * Constructor for CommanderUnit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     * @param attack - attack value of unit
     * @param armor  - armor value of unit
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for commander unit with default values for attack and armor.
     * (*) indicates that this is a commander unit.
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     */
    public CommanderUnit(String name, int health) {
        super(name+ "(*)", health, 25,15);
    }
}
