/**
 * Name: Cheung King Hung
 * ID: 21237379
 * Session: 2
 */
class GotoJailCell extends FunctionCell {
    //TODO add some other methods if necessary

    public GotoJailCell() {
        super("Go to Jail");
    }
    public GotoJailCell(String name) {
        super(name);
    }

    @Override
    public void event(Player p, Cell[] cells) {
        System.out.println(p.getName() + " go to Jail!");
        p.putToJail();
    }
}
