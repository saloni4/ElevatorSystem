package ElevatorSelectionStrategy;

import controller.ElevatorController;
import enums.ElevatorDirection;

import java.util.List;

public interface ElevatorStrategy {
    void selectElevator(List<ElevatorController> controllers, int floorNumber, ElevatorDirection elevatorDirection);
}
