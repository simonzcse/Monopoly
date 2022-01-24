/**
 * Name: Cheung King Hung
 * ID: 21237379
 * Session: 2
 */
public class ParkCell extends FunctionCell {
    //TODO add some other methods if necessary
    public ParkCell(String name) {
        super(name);
    }
    public ParkCell() {
        super("Park");
    }

    @Override
    public void event(Player p, Cell[] cells) {
        System.out.println(p.getName() + " is in the park");
        p.setInPark(true);
    }
}

