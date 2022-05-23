package units;


import Battle.Terrain;

/**
 * Class for a cavalry unit, which does melee damage. Cavalry units is a mounted force on horses.
 * Cavalry unit has High health, high armor and medium attack damage.
 */
public class CavalryUnit extends Unit {

    /**
     * Constructor for CavalryUnit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     * @param attack - attack value of unit
     * @param armor  - armor value of unit
     */
    public CavalryUnit(String name, int health, int attack, int armor) throws IllegalArgumentException{
        super(name, health, attack, armor);
    }

    /**
     * Constructor for cavalry unit with default values for attack and armor.
     * (C) indicates that this is a cavalry unit
     *
     * @param name   - name of the unit
     * @param health - health value of unit
     */
    public CavalryUnit(String name, int health) throws IllegalArgumentException{
        super(name, health, 20, 12);
    }

    /**
     * Returns the attack-bonus of the cavalry unit based on terrain-type.
     * Open fields are a big advantage for cavalry units!
     *
     * @return default attack-bonus + terrain-bonus.
     */
    @Override
    public int getAttackBonus() {
        int TerrainBonus = 0;
        if (this.getTerrainType() == Terrain.PLAINS) {
            TerrainBonus = 6;
        }
        return 3 + TerrainBonus;
    }

    /**
     * Returns the resist-bonus of the infantry unit based on terrain-type
     * Cavalry units has no resist-advantage in forests!
     *
     * @return default resist-bonus + terrain-bonus
     */
    @Override
    public int getResistBonus() {
        int TerrainBonus = 0;
        if(this.getTerrainType() == Terrain.FOREST){
            TerrainBonus = -5;
        }
        return 5 + TerrainBonus;
    }
}
