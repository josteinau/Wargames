import java.io.Serializable;

/* This is a class for units.
 * A unit has a name, health, attack damage and armor points.
 * The unit class is the superclass to CavalryUnit, CommanderUnit, InfantryUnit and RangedUnit-classes.
 * The unit can attack an opponent, which can result in death for the defending unit or the attacking unit.
 */

public abstract class Unit implements Serializable {
    String name;
    int health;
    int attack;
    int armor;
    static int numberOfAttacks;

    // Units has (X) after name in the subclasses to indicate which type of unit.
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    // Attacking method which returns opponents health after being attacked.
    // Using println alot because its easier to keep track of battle.
    public void attack(Unit opponent) {
        int hit = this.attack + this.getAttackBonus(); // Total attack damage
        int defence = opponent.getArmor() + opponent.getResistBonus(); // opponent defence
        if (hit >= opponent.health + defence) { // 0 hp
            System.out.println(this.name + " attacks " + opponent.name + " for " + hit + " damage.");
            System.out.println(opponent.name + " died");
            opponent.health = 0;
        } else {
            int newHealth = (opponent.health + opponent.getArmor()) - hit; // Defender/opponent hp after attack. !!!! INCLUDING ARMOR 'AS' HP
            System.out.println(this.name + " attacks " + opponent.name + " for " + hit + " damage." +
                    "\nRemaining life for " + opponent.name + " equals " + newHealth);
            opponent.setHealth(newHealth);
            numberOfAttacks++;
        }
    }

    public int numOfattacks() {
        return numberOfAttacks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public abstract int getAttackBonus();

    public abstract int getResistBonus();

    // End required



    // Ideas:
    /* public String generateRandomName(String randomName){
    if(orc){
    array[randomOrcNames]
    if(human){
    array[otherRandomNames]
    return randomName
     */
    /*
    Reduce armor for each hit, armor gets more and more broken. If not the commander-units are OP!
     */

    public boolean isDead() {
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return name + " [Hitpoints=" + health + " Attack=" + attack + "+(" + this.getAttackBonus() + ")" + " Armor=" + armor + "+(" + this.getResistBonus() + ")" + "]";
    }
}
