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

    public void attack(Unit opponent){
        if(attack + this.getAttackBonus()>= this.health + this.getResistBonus()){ // 0 hp
            System.out.println(this.name + " died"); // boolean isDead()?
        } else{
            this.health = (this.health + this.getResistBonus()) - (attack + this.getAttackBonus());
            System.out.println("Remaining life for " + this.name + " equals " + this.health);
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
