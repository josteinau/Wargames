public abstract class Unit {
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

    public void attack(Unit opponent) {
        int hit = this.attack + this.getAttackBonus(); // Total attack dmg.
        int defence = opponent.getArmor() + opponent.getResistBonus(); // opponent defence
        if (this.attack + this.getAttackBonus() >= opponent.health + opponent.getResistBonus()) { // 0 hp
            System.out.println(opponent.name + " died"); // boolean isDead()? if isDead remove.unit
        } else {
            int newHealth = (opponent.health + defence) - hit; // Defender/opponent hp after attack. !!!! INCLUDING ARMOR 'AS' HP
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

    public boolean isDead() {
        if (health + armor <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return name + " [Hitpoints=" + health + " Attack=" + attack + "+(" + this.getAttackBonus() + ")" + " Armor=" + armor + "+(" + this.getResistBonus() + ")" + "]";
    }
}
