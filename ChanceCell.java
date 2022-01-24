import java.util.concurrent.ThreadLocalRandom;

/**
 *  * Name: Cheung King Hung
 *  * ID: 21237379
 *  * Session: 2
 * Got one of the following chances randomly:
 * 1. Roll again
 * 2. +1000
 * 3. -1000
 * 4. Move to Jail directly without getting the 2000.
 */
public class ChanceCell extends FunctionCell {
    public ChanceCell(String name) {
        super(name);
    }

    @Override
    public void event(Player p, Cell[] cells) {
        while (true){
            int randomInt = ThreadLocalRandom.current().nextInt(1, 5);
            switch (randomInt) {
                case 1:
                    System.out.println(getName() + " result: Roll again!");
                    break;
                case 2:
                    System.out.println(getName() + " result: Gain $1000!");
                    p.charge(-1000);
                    return;
                case 3:
                    System.out.println(getName() + " result: Deduct $1000!");
                    p.charge(1000);
                    return;
                case 4:
                    System.out.println(getName() + " result: Go to Jail, now!");
                    p.putToJail();
                    return;
            }
        }
    }
}