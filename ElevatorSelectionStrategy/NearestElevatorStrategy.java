package ElevatorSelectionStrategy;

import controller.ElevatorController;
import enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy {
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int floorNumber, ElevatorDirection elevatorDirection) {
        ElevatorController best=null;
        int minDistance=Integer.MAX_VALUE;

        for(ElevatorController controller:controllers){
            int nextFloor=controller.getElevator().getNext_floor();
            ElevatorDirection elevatorDir=controller.getElevator().getMovingDirection();
            boolean isSameDir=((elevatorDir==elevatorDirection)&&
                    ((elevatorDir==ElevatorDirection.UP && nextFloor<=floorNumber)
                            ||(elevatorDir==ElevatorDirection.DOWN && nextFloor>=floorNumber)));

            int dist=Math.abs(nextFloor-floorNumber);
            if(isSameDir && dist<minDistance){
                minDistance=dist;
                best=controller;
            }
        }
        if(best==null) {
            for (ElevatorController controller : controllers) {
                if (controller.getElevator().getMovingDirection() == ElevatorDirection.IDLE) {
                    best = controller;
                    break;
                }
            }
        }
        if(best==null){
            best=controllers.get(0);
        }
        return best;
    }

}
