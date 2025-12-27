package Schduler;

import ElevatorSelectionStrategy.ElevatorStrategy;
import controller.ElevatorController;
import enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {

    private final List<ElevatorController> controllers;
    private ElevatorStrategy elevatorStrategy;

    public ElevatorScheduler(List<ElevatorController> controllers, ElevatorStrategy elevatorStrategy) {
        this.controllers = controllers;
        this.elevatorStrategy = elevatorStrategy;
    }

    public void setElevatorStrategy(ElevatorStrategy elevatorStrategy) {
        this.elevatorStrategy = elevatorStrategy;
    }

    public ElevatorController assignElevator(int floorNumber, ElevatorDirection elevatorDirection) {
        return elevatorStrategy.selectElevator(controllers,floorNumber,elevatorDirection );
    }
}
