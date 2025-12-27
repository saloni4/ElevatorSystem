package buttons;

import Dispatcher.ExternalDispatcher;
import enums.ElevatorDirection;

public class ExternalButton {
    ExternalDispatcher dispatcher;

    public ExternalButton(ExternalDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void pressButton(int floorNumber, ElevatorDirection elevatorDirection) {
        dispatcher.submitExternalRequest(floorNumber, elevatorDirection);
    }
}
