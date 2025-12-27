package buttons;

import Dispatcher.InternalDispatcher;
import controller.ElevatorController;

public class InternalButton {
    ElevatorController elevatorController;

    public InternalButton(ElevatorController controller) {
       this.elevatorController=controller;
    }

    public void pressButton(int i) {
        InternalDispatcher.getINSTANCE()
                .submitInternalRequest(i, elevatorController);

    }
}
