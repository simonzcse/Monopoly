/**
 * Name: Cheung King Hung
 * ID: 21237379
 * Session: 2
 */
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private final String name;
    private int money;
    private int position;
    private int lastMove;
    private boolean inPark;
    private boolean inJail;

    /**
     * Constructor
     * 
     * @param name The name of the player.
     */
    public Player(String name) {
        //TODO
        this.name = name;
        this.money = 10000;
        this.position = Gameboard.HOME_POSITON;
        this.lastMove = this.position;
        this.inPark = false;
        this.inJail = false;
    }

    /**
     * A player roll a dice and change its position
     */
    public void roll() {
        //TODO
        if (isInJail()){
            System.out.println(name + ", sorry you are in Jail. Skip one round.");
            return;
        }
        inPark = !isInPark() && inPark;
        int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        lastMove = randomNum;
        System.out.println(name + ", this is your turn. We roll for you");
        System.out.println("It is..." + randomNum);
        if (position + randomNum >= Gameboard.CELL_SIZE ) {
              money += 2000;
              position = position + randomNum - Gameboard.CELL_SIZE;
        } else {
               position += randomNum;
        }
    }
    /**
     * Return true if the player is in Park 
     *
     * @return true if the player is in Park
     */
    public boolean isInPark() { 
        //TODO
        return inPark;
    }
    /**
     * Set the player in a park. This will only be called when a player
     * move to the cell Car Park. 
     *
     * @param inPark true if the player is set in the park
     */
    public void setInPark(boolean inPark) { 
        //TODO
        if (inPark){
            this.inPark = true;
        }
     }
    /**
     * Return true if the player is in Jail. It should return false
     * if the player visits Jail (i.e., rolls a dice and moves to the cell Jail)
     *
     * @return true if the player is in Jail
     */
    public boolean isInJail() { 
        //TODO
        return inJail;
     }
    /**
     * Put the player into Jail directly without passing Home (i.e., no 2000)
     */
    public void putToJail() {
        //TODO
        position = Gameboard.JAIL_POSITION;
        inJail = true;
    }

    /**
     * Get the value of dice that the player has just rolled.
     *
     * @return the value of dice
     */
    public int getLastMove() { 
        //TODO
        return lastMove;
    }
    /**
     * Get the amount of money that the player has
     *
     * @return the amount of money the player has
     */
    public int getMoney() { 
        //TODO
        return money;
     }
     /**
      * Return the name of the player
      *
      * @return the name of the player
      */
    public String getName() { 
        //TODO
        return name;
     }
     /**
      * return the current position of the player
      * 
      * @return the position of the player
      */
    public int getPosition() { 
        //TODO
        return position;
     }
     /**
      * charge certain amount of dollar from the player.
      * 
      * @param money The amount being charged
      */
    public void charge(int money) { 
        //TODO
        this.money -= money;
     }
     //TODO add some other private methods if necessary
}
