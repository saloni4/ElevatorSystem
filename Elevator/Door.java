package Elevator;

import enums.DoorState;

public class Door {
    DoorState doorState;


    public Door() {
        this.doorState = DoorState.CLOSE;
    }

    public void openDoor(int id){
        doorState=DoorState.OPEN;
        System.out.println("Opening the gate of elevator number : " + id);
    }

    public void closeDoor(int id){
        doorState=DoorState.CLOSE;
        System.out.println("Closing the gate of elevator number : " + id);

    }
}
