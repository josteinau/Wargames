public class Main {
    public static void main(String[] args) {


        // Testing if attack method works.
        CavalryUnit cavUnit = new CavalryUnit("Orc", 250);
        CommanderUnit cu2 = new CommanderUnit("Elf", 100);
        cu2.attack(cavUnit);
        System.out.println(cavUnit);

    }
}