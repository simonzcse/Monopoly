/**
 * If the owner owns only one train station, the rent is 500
 * If the owner owns two of them, the rent is 1000
 * If the owner owns three of them, the rent is 2000
 * If the owner owns four of them, the rent is 4000
 */

import java.lang.reflect.Array;

/**
 * Name: Cheung King Hung
 * ID: 21237379
 * Session: 2
 */
public class TrainStationPropertyCell extends PropertyCell {
    public static final int TRAIN_STATION_COST = 500;
    public static final TrainStationPropertyCell[] TRAIN_STATION_ARRAY = {
            new TrainStationPropertyCell("Kowloon"),
            new TrainStationPropertyCell("Mongkok"),
            new TrainStationPropertyCell("Central"),
            new TrainStationPropertyCell("Shatin")
    };
    //TODO add some other methods if necessary

    public TrainStationPropertyCell(String location, int baseCost) {
        super(location, baseCost);
    }
    public TrainStationPropertyCell(String location) {
        super(location, TRAIN_STATION_COST);
    }

    @Override
    public int getRent(Player p) {
        if (owner == null || p == owner){
            return 0;// owner no need to charge
        }else {
            int numberOfPlayerOwnsTrainStation = 0;
            for (TrainStationPropertyCell cell: TRAIN_STATION_ARRAY) {
                numberOfPlayerOwnsTrainStation += cell.getOwner() == p ? 1 : 0;
            }
                switch (numberOfPlayerOwnsTrainStation) {
                    case 1:
                        return 500;
                    case 2:
                        return 1000;
                    case 3:
                        return 2000;
                    case 4:
                        return 4000;
                    default:
                        return 0;
                }
            }
    }
}
