package Building;

import Dispatcher.ExternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class Building {

    List<Floor> floors;


    public Building(int totalFloors, ExternalDispatcher externalDispatcher) {
        floors=new ArrayList<>();
        for(int i=0;i<=totalFloors;i++){
            floors.add(new Floor(i,externalDispatcher));
        }
    }

    public Floor getFloor(int floor) {
        return floors.get(floor);
    }
}
