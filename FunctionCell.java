/**
 * Name: Cheung King Hung
 * ID: 21237379
 * Session: 2
*/

public class FunctionCell extends Cell {
    //TODO add some other methods if necessary
    public FunctionCell(String name){
        super(name);
    }

    @Override
    public void event(Player p, Cell[] cells) {
        System.out.printf("You have arrived: %s\n", getName());
    }
}


