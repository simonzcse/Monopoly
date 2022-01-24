import java.util.Scanner;
/**
 * Name: Cheung King Hung
 * ID: 21237379
 * Session: 2
 */
public class PropertyCell extends Cell {
    protected int baseCost;
    protected Player owner = null;
    int house = 0;

    /**
     * Return the owner of the property
     * @return owner
     */
    public Player getOwner() { 
        //TODO
        return owner;
     }
     /**
      * Constructor
      */
    public PropertyCell(String name, int baseCost) {
        //TODO
        super(name);
        this.baseCost = baseCost;
    }
    /**
     * Return the cost of the property cell
     * @return the base cost of the property cell.
     */
    public int getCost() { 
        //TODO
        return baseCost;
    }
    /**
     * Return number of houses built on this property cell.
     * @return the number of houses.
     */
    public int getHouse() { 
        //TODO
        return house;
    }

    /**
     * Return a specific format of string. See the assignment webpage
     * for more details
     * @return the specific string of the property cell/
     */
    @Override
    public String toString() {
        //TODO
        if (owner == null) {
            return String.format("%s owned by - : %d", name, baseCost);
        }
        if (house == 0) {
            return String.format("%s owned by %s : %d", name, owner.getName(), baseCost);
        }
        return String.format("%s owned by %s : %d House: %d", name, owner.getName(), baseCost, house);
    }

    /**
     * Return the rent charged against this player. The formula for an ordinary cell is
     * baseCost * (1 + house * 0.5) rounding the nearest integer.
     *
     * @param p - The player who is charged. p is irrelevant in this case.
     * @return The rent.
     */
    public int getRent(Player p) {
        //TODO
        return owner == null || p == owner ? 0 : (int) Math.round (baseCost * (1.0 + house * 0.5));
    }

    //TODO add some other methods if necessary
    @Override
    public void event(Player p, Cell[] cells) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("You have landed on %s !\n" , getName());
        if (owner == p) {
            System.out.printf("Do you want to build a house for this land for $%d? (y/n)", Math.round(baseCost / 5.0));//building
            if (sc.next().equals("y")) {
                if (owner.getMoney() >= Math.round(baseCost / 5.0)) {
                    owner.charge((int) Math.round(baseCost / 5.0));
                    house++;
                    System.out.printf("You have %d house on this land now!\n", house);
                } else {
                    System.out.print("Sorry you don't have enough money\n");
                }
            }
        }
        else if (owner == null) {//buying
            System.out.printf("Do you want to buy this for $%d? (y/n): ", baseCost);
              if (sc.next().equals("y")) {
                if (p.getMoney() >= baseCost) {
                    p.charge(baseCost);
                    owner = p;
                    System.out.print("You have bought this land!\n");
                }
                else {
                     System.out.print("Sorry you don't have enough money\n");
                }
              }
        }
        else {
            if (owner.isInPark()) {
                System.out.printf("%s is in the Park. Free parking.\n", owner.getName());
            }else {
                int rent = getRent(p);//charge
                p.charge(rent);
                owner.charge(-rent);//add money
                System.out.printf("%s have paid %s $%d\n", p.getName(), owner.getName(), rent);
            }
        }
    }
}
