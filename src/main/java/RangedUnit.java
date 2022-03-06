public class RangedUnit extends Unit{

    public RangedUnit(String name, int health, int attack, int armor){
        super(name,health,attack,armor);
    }

    public RangedUnit(String name, int health){
        super(name,health,15,8);
    }
    @Override
    public int getAttackBonus() {
        return 3; // Ranged unit
    }

    @Override
    public int getResistBonus() {
        int damage = 0;
        for(int numOfAttacks = 1; numOfAttacks<15; numOfAttacks++){
            if(numOfAttacks==1){
                damage = 6;
            }if(numOfAttacks==2){
                damage = 4;
            }else{
                damage = 2;
            }
            numOfAttacks++;
        }
        return damage;
    }
}
