

import org.w3c.dom.ranges.Range;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating the horde
        List<Unit> orcs = new ArrayList<Unit>();
        orcs.add(new CavalryUnit("Unit 1",25));
        orcs.add(new CavalryUnit("Unit 2",25));
        orcs.add(new CavalryUnit("Unit 3",25));
        Army Horde = new Army("Orcarmy", orcs);
        Horde.getAllUnits(orcs);

        // Creating the humans

        List<Unit> hoomans = new ArrayList<Unit>();
        hoomans.add(new CavalryUnit("Knut",25));
        hoomans.add(new CavalryUnit("Per",25));
        hoomans.add(new CavalryUnit("Jøss",25));
        hoomans.add(new RangedUnit("Rangeknut",25));
        Army Humans = new Army("The human army", hoomans);
        Humans.getAllUnits(hoomans);
        System.out.println(Humans.hasUnits(hoomans)); // expect true



        // Testing if attack method works.
        System.out.println("----------------"+"\n");
        System.out.println("Unit class tests:");

        CommanderUnit commanderElf = new CommanderUnit("Elf", 100);
        CavalryUnit cavUnit = new CavalryUnit("Orc", 250);
        System.out.println(cavUnit);
        System.out.println(commanderElf + "\n");
        commanderElf.attack(cavUnit);
        System.out.println("\n" + cavUnit);
        cavUnit.attack(commanderElf);

        // Testing infantry default attack 15 and armor
        InfantryUnit inf = new InfantryUnit("Goblin", 100);
        System.out.println("\n" + inf);



    }
}