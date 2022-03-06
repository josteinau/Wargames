public class Unit {
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
        System.out.println(opponent + " attacking ");
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String toString() {
        return "Unit\n" + "Name: " + name + "\n" + "Hitpoints: " + health + "\n" + "Attack: " + attack + "\n" + "Armor: " + armor;
    }
}
