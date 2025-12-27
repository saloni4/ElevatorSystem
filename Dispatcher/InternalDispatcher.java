package Dispatcher;

import controller.ElevatorController;

public class InternalDispatcher {
    private static InternalDispatcher INSTANCE = new InternalDispatcher();

    public static InternalDispatcher getINSTANCE(){
        return INSTANCE;
    }

    public void submitInternalRequest(int destinationFloor, ElevatorController controller) {
        controller.submitRequest(destinationFloor);
    }

}
