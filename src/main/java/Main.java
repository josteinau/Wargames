public class Main {
    public static void main(String[] args) {


        // Testing if attack method works.
        CavalryUnit cavUnit = new CavalryUnit("Orc", 250);
        CommanderUnit cu2 = new CommanderUnit("Elf", 100);
        System.out.println(cavUnit+"\n");
        cu2.attack(cavUnit);
        System.out.println("\n"+cavUnit);

        // Testing infantry default attack 15 and armor
        InfantryUnit inf = new InfantryUnit("Gob", 100);
        System.out.println("\n"+inf);
        System.out.println(inf.getAttackBonus());


        // Ranged unit
        RangedUnit rang = new RangedUnit("Wood Elf", 50);
        System.out.println(rang.getResistBonus());


    }
}