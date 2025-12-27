package Building;

import Dispatcher.ExternalDispatcher;
import buttons.ExternalButton;
import enums.ElevatorDirection;

public class Floor {
    int floorNumber;
    ExternalButton upButton;
    ExternalButton downButton;


    public Floor(int floorNumber, ExternalDispatcher externalDispatcher) {
        this.floorNumber = floorNumber;
        this.upButton = new ExternalButton(externalDispatcher);
        this.downButton = new ExternalButton(externalDispatcher);
    }

    public void pressbuttonUp(){
        upButton.pressButton(floorNumber, ElevatorDirection.UP);
    }

    public void pressbuttonDown(){
        downButton.pressButton(floorNumber, ElevatorDirection.DOWN);
    }
}
