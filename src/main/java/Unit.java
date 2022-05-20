import java.io.Serializable;

/** This is a class for units.
 * A unit has a name, health, attack damage and armor points.
 * The unit class is the superclass to CavalryUnit, CommanderUnit, InfantryUnit and RangedUnit-classes.
 * The unit can attack an opponent, which can result in death for the defending unit or the attacking unit.
 */

public abstract class Unit implements Serializable {
    String name;
    int health;
    int attack;
    int armor;

    /**
     * Constructor that creates a unit instance
     * @param name - name of the unit
     * @param health - health value of unit
     * @param attack - attack value of unit
     * @param armor - armor value of unit
     * @throws IllegalArgumentException if required criteria are not met
     */
    // Units has (X) after name in the subclasses to indicate which type of unit.
    public Unit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        if(name.isBlank() || name.isEmpty()){
            throw new IllegalArgumentException("Unit name cannot be null");
        }
        if(health <= 0){
            throw new IllegalArgumentException("Unit health cannot be null");
        }
        if(attack <= 0){
            throw new IllegalArgumentException("Unit attack cannot be null");
        }
        if(armor <= 0){
            throw new IllegalArgumentException("Unit armor cannot be null");
        }
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Method for attacking a opponent. Sets the opponent's health after each attack.
     * Added some println, it is easier to keep track of every step of a battle,
     * even-though println is a big no-no!
     * @param opponent is the unit being attacked. attacker.attack(opponent)
     */
    public void attack(Unit opponent) {
        if(!opponent.isDead()) {
            int hit = this.attack + this.getAttackBonus();
            int defence = opponent.getArmor() + opponent.getResistBonus();
            if (hit >= opponent.health + defence) { // 0 hp
                System.out.println(this.name + " attacks " + opponent.name + " for " + hit + " damage.");
                System.out.println(opponent.name + " died"); // ADD THIS TO MAIN class when done!!
                opponent.health = 0;
            } else {
                int newHealth = (opponent.health + opponent.getArmor()) - hit;
                System.out.println(this.name + " attacks " + opponent.name + " for " + hit + " damage." +
                        "\nRemaining life for " + opponent.name + " equals " + newHealth);
                opponent.setHealth(newHealth);
            }
        }
    }

    /**
     * Method to get name of unit!
     * @return name of unit as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Gives the unit a new name!
     * @param name value is current name of unit.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the current health of unit.
     * @return health as integer value.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the current health value to a new int value
     * @param health value is current value of unit.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the attack value of unit
     * @return attack of unit as int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Sets the current attack value to a new int value
     * @param attack value is current value of unit.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Returns the armor value of unit
     * @return armor as integer value.
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets the current armor value to a new int value
     * @param armor value is current value of unit.
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Method to get the current attackbonus of a unit
     * @return abstract value, check other classes!
     */
    public abstract int getAttackBonus();

    /**
     * Method to get the current resistbonus of a unit
     * @return abstract value, check other classes!
     */
    public abstract int getResistBonus();

    /**
     * Method to check if unit is dead or not.
     * @return true if unit has 0 or below health, returns false otherwise.
     */
    public boolean isDead() {
        if (health <= 0) return true;
        else {
            return false;
        }
    }

    /**
     * Method to present the unit in representable string of all the attributes
     * @return String with all the values of unit.
     */

    public String toString() {
        return name + " [Hitpoints=" + health + " Attack=" + attack + "+(" + this.getAttackBonus() + ")" + " Armor=" + armor + "+(" + this.getResistBonus() + ")" + "]";
    }
}
