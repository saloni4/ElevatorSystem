package Dispatcher;

import Schduler.ElevatorScheduler;
import controller.ElevatorController;
import enums.ElevatorDirection;

public class ExternalDispatcher {
    ElevatorScheduler elevatorScheduler;

    public ExternalDispatcher(ElevatorScheduler elevatorScheduler) {
        this.elevatorScheduler = elevatorScheduler;
    }

    public void submitExternalRequest(int floorNumber, ElevatorDirection elevatorDirection) {
       elevatorScheduler.assignElevator(floorNumber, elevatorDirection).submitRequest(floorNumber);
    }
}
