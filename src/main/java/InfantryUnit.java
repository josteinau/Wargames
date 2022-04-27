public class InfantryUnit extends Unit {


    // Footsoldier

    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);

    }

    public int getAttackBonus() {
        return 2; // Melee bonus
    }

    public int getResistBonus() {
        return 1; // Melee resist bonus.
    }
}
