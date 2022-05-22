package units;

import Battle.Terrain;

/**
 * Class for a ranged unit, which typically uses a bow and arrows!
 * Ranged units has low health, medium armor and high attack damage.
 */
public class RangedUnit extends Unit {
    private final int startHealth;


    /**
     * Constructor for RangedUnit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     * @param attack - attack value of unit
     * @param armor  - armor value of unit
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
        this.startHealth = health;
    }

    /**
     * Constructor for ranged unit with default values for attack and armor.
     * (R) indicates that this is a ranged unit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     */
    public RangedUnit(String name, int health) {
        super(name + "(R)", health, 15, 8);
        this.startHealth = health;
    }

    /**
     * Returns the attack-bonus of the ranged unit based on terrain-type.
     * Ranged units prefer to fight from a hill.
     *
     * @return default attack-bonus + terrain-bonus.
     */
    @Override
    public int getAttackBonus() {
        int TerrainBonus = 0;
        if (this.getTerrainType() == Terrain.HILL) {
            TerrainBonus = 5;
        }
        if (this.getTerrainType() == Terrain.FOREST) {
            TerrainBonus = -2;
        }
        return 3 + TerrainBonus;
    }

    /**
     * Returns the resist-bonus of the ranged unit, terrain does not matter for the ranged unit.
     * Resist-bonus after some received attacks.
     *
     * @return the current resist bonus.
     */
    @Override
    public int getResistBonus() {
        if (8 - (this.startHealth - this.getHealth()) <= 0) {
            return 1;
        } else {
            return 8 - (this.startHealth - this.getHealth());
        }
    }
}
