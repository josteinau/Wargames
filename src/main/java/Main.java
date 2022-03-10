import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Army> armies = new ArrayList<Army>();




        // Testing if attack method works.
        System.out.println("Unit class tests:");
        CavalryUnit cavUnit = new CavalryUnit("Orc", 250);
        CommanderUnit commanderElf = new CommanderUnit("Elf", 100);
        System.out.println(cavUnit);
        System.out.println(commanderElf+"\n");
        commanderElf.attack(cavUnit);
        System.out.println("\n"+cavUnit);
        cavUnit.attack(commanderElf);
        System.out.println(commanderElf.getHealth());

        // Testing infantry default attack 15 and armor
        InfantryUnit inf = new InfantryUnit("Goblin", 100);
        System.out.println("\n"+inf);
        System.out.println(inf.getAttackBonus());


        // Ranged unit
        RangedUnit rang = new RangedUnit("Wood Elf", 50);
        System.out.println(rang);


    }
}