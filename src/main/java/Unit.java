public abstract class Unit {
    String name;
    int health;
    int attack;
    int armor;


    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public void attack(Unit opponent) {
        int hit = this.attack + this.getAttackBonus();
        int defence = opponent.getArmor() + opponent.getResistBonus();
        int newHealth;
        if (this.attack + this.getAttackBonus() >= opponent.health + opponent.getResistBonus()) { // 0 hp
            System.out.println(opponent.name + " died"); // boolean isDead()?
        } else {
            newHealth = (opponent.health + defence) - hit;
            System.out.println(this.name + " attacks " + opponent.name +  " for " + hit + " damage." +
                    "\nRemaining life for " + opponent.name + " equals " + newHealth );
            opponent.setHealth(opponent.health);
        }
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

    public String toString() {
        return "Unit\n" + "Name: " + name + "\n" + "Hitpoints: " + health + "\n" + "Attack: " + attack + "\n" + "Armor: " + armor;
    }
}
