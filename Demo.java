import Building.Building;
import Dispatcher.ExternalDispatcher;
import Elevator.Elevator;
import ElevatorSelectionStrategy.NearestElevatorStrategy;
import Schduler.ElevatorScheduler;
import buttons.ExternalButton;
import buttons.InternalButton;
import controller.ElevatorController;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        try {

            //creating elevators and assigned controllers for these elevators
            Elevator car1 = new Elevator(1);
            ElevatorController controller1 = new ElevatorController(car1);
            Elevator car2 = new Elevator(2);
            ElevatorController controller2 = new ElevatorController(car2);

            //created internal button for both elevator
            InternalButton internalButton1 = new InternalButton(controller1);
            InternalButton internalButton2 = new InternalButton(controller2);

            //created elevator schduler, which will take list of controllers and strategy to use
            ElevatorScheduler elevatorScheduler = new ElevatorScheduler(
                    Arrays.asList(controller1, controller2),
                    new NearestElevatorStrategy()
            );

            //external Dispatcher
            ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorScheduler);

            Building building = new Building(5, externalDispatcher);

            //start elevators using controllers
            new Thread(controller1, "Elevator-1").start();
            new Thread(controller2, "Elevator-2").start();

            //submitting the requests
            building.getFloor(3).pressbuttonUp();
            Thread.sleep(5);

            building.getFloor(5).pressbuttonDown();
            Thread.sleep(5);

            internalButton1.pressButton(4); // user inside elevator 1 presses floor 4
            Thread.sleep(5);

            internalButton1.pressButton(5); // user inside elevator 1 presses floor 5
            Thread.sleep(5);

            building.getFloor(1).pressbuttonDown();
            Thread.sleep(5);

            building.getFloor(2).pressbuttonUp();
            Thread.sleep(5);

            internalButton1.pressButton(2);




        } catch (Exception e) {

        }
    }
}
