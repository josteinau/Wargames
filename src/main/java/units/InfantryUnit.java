package units;

import Battle.Terrain;

/**
 * Class for a simple foot-soldier, which only does melee damage.
 * Infantry unit has medium health, high armor and decent attack damage.
 */
public class InfantryUnit extends Unit {

    /**
     * Constructor for InfantryUnit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     * @param attack - attack value of unit
     * @param armor  - armor value of unit
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Constructor for infantry unit with default values for attack and armor.
     * (I) indicates that this is a infantry unit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     */
    public InfantryUnit(String name, int health) {
        super(name + "(I)", health, 15, 10);
    }

    /**
     * Returns the attack-bonus of the infantry unit based on terrain-type.
     * Fighting in forests is a big advantage for infantry units!
     *
     * @return default attack-bonus + terrain-bonus.
     */
    @Override
    public int getAttackBonus() {
        int TerrainBonus = 0;
        if (this.getTerrainType() == Terrain.FOREST) {
            TerrainBonus = 5;
        }
        return 2 + TerrainBonus;
    }

    /**
     * Returns the resist-bonus of the infantry unit based on terrain-type
     *
     * @return default resist-bonus + terrain-bonus
     */
    @Override
    public int getResistBonus() {
        int TerrainBonus = 0;
        if (this.getTerrainType() == Terrain.FOREST) {
            TerrainBonus = 4;
        }
        return 2 + TerrainBonus;
    }
}
