public class CavalryUnit extends Unit{

    public CavalryUnit(String name, int health, int attack, int armor){
        super(name,health,attack, armor);
    }
    public CavalryUnit(String name, int health){
        super(name,health,20, 12);
    }

    @Override
    public int getAttackBonus() {
        int bonusDamage = 0;
        int numOfAttacks;
        for(numOfAttacks = 1; numOfAttacks < 15; numOfAttacks++){
            if(numOfAttacks==1){
                bonusDamage = 4+2; //charge damage + initial damage.
            }else{
                bonusDamage = 2;
            }
            numOfAttacks++;
        }
        return bonusDamage;
    }

    @Override
    public int getResistBonus() {
        return 1;
    }
}
