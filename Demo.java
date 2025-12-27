import Elevator.Elevator;
import buttons.InternalButton;
import controller.ElevatorController;

public class Demo {

    public static void main(String[] args) {
        try {
            Elevator car1 = new Elevator(1);
            ElevatorController controller1 = new ElevatorController(car1);
            Elevator car2 = new Elevator(2);
            ElevatorController controller2 = new ElevatorController(car2);

            InternalButton internalButton1 = new InternalButton(controller1);
            InternalButton internalButton2 = new InternalButton(controller2);




        } catch (Exception e) {

        }
    }
}
