package buttons;

import controller.ElevatorController;

public class InternalButton {
    ElevatorController elevatorController;

    public InternalButton(ElevatorController controller) {
       this.elevatorController=controller;
    }
}
