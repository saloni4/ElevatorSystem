package ElevatorSelectionStrategy;

import controller.ElevatorController;
import enums.ElevatorDirection;

import java.util.List;

public class LeastBusyStrategy implements ElevatorStrategy{
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int floorNumber, ElevatorDirection elevatorDirection) {
        ElevatorController best = null;
        int minLoad = Integer.MAX_VALUE;

        for (ElevatorController controller : controllers) {
            int load = controller.getDownMaxQue().size() +
                    controller.getUpMinQue().size();

            if (load < minLoad) {
                minLoad = load;
                best = controller;
            }
        }
        return best;

    }
}
