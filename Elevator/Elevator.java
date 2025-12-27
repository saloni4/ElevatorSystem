package Elevator;

import enums.ElevatorDirection;

public class Elevator {
    int id;
    int current_floor;
    int next_floor;
    Door door;
    ElevatorDirection movingDirection;


    public Elevator(int id) {
        this.id = id;
        current_floor=0;
        movingDirection=ElevatorDirection.IDLE;
        door=new Door();
    }

    public void moveElevator(int destinationFloor){
        this.next_floor=destinationFloor;
        if(this.current_floor==destinationFloor){
            door.openDoor(this.id);
            return;
        }

        int start=this.current_floor;
        if(next_floor>=current_floor){
            movingDirection=ElevatorDirection.UP;
            display();
            for(int i=current_floor+1;i<=next_floor;i++){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                setCurrent_floor(i);
                display();
            }
        }
        else{
            movingDirection=ElevatorDirection.DOWN;
            display();
            for(int i=current_floor-1;i>=next_floor;i--){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                setCurrent_floor(i);
                display();
            }
        }

    }

    public void display(){
        System.out.println("elevator with id "+id +" currently at floor "+current_floor+" moving in direction"+ this.getMovingDirection());
    }

    public int getId() {
        return id;
    }

    public int getCurrent_floor() {
        return current_floor;
    }

    public int getNext_floor() {
        return next_floor;
    }

    public ElevatorDirection getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(ElevatorDirection movingDirection) {
        this.movingDirection = movingDirection;
    }

    public void setCurrent_floor(int current_floor) {
        this.current_floor = current_floor;
    }
}
