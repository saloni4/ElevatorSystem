package ElevatorSelectionStrategy;

import controller.ElevatorController;
import enums.ElevatorDirection;

import java.util.List;

public interface ElevatorStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int floorNumber, ElevatorDirection elevatorDirection);
}
