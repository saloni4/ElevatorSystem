package controller;

import Elevator.Elevator;
import enums.ElevatorDirection;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable {
    PriorityBlockingQueue<Integer> upMinQue;
    PriorityBlockingQueue<Integer> downMaxQue;
    Elevator elevator;

    public PriorityBlockingQueue<Integer> getUpMinQue() {
        return upMinQue;
    }

    public PriorityBlockingQueue<Integer> getDownMaxQue() {
        return downMaxQue;
    }

    public Elevator getElevator() {
        return elevator;
    }

    private final Object monitor = new Object();

    public ElevatorController(Elevator car) {
        this.elevator=car;
        upMinQue=new PriorityBlockingQueue<>(10);
        downMaxQue=new PriorityBlockingQueue<>(10,(a,b)->(b-a));
    }

    public void submitRequest(int floorNumber) {
        enqueueRequest(floorNumber);
    }

    private void enqueueRequest(int floorNumber) {
        System.out.println("Request for floor number "+ floorNumber + " excepted by elevator with id " + elevator.getId());

        if(floorNumber== elevator.getCurrent_floor()){
            return;
        }
        if(floorNumber>= elevator.getNext_floor()){
            if(!upMinQue.contains(floorNumber)){
                upMinQue.offer(floorNumber);
            }
        }
        else {
            if (!downMaxQue.contains(floorNumber)) {
                downMaxQue.offer(floorNumber);
            }
        }

        synchronized (monitor) {
            monitor.notify();   // wake elevator thread
        }

    }

    @Override
    public void run() {
        controlElevator();
    }

    private void controlElevator() {

        while (true) {

            //no request, go to sleep
            synchronized (monitor) {
                while (upMinQue.isEmpty() && downMaxQue.isEmpty()) {
                    try {
                        System.out.println("elevator:" + elevator.getId() + " is IDLE");
                        elevator.setMovingDirection(ElevatorDirection.IDLE);
                        monitor.wait(); // sleep until request arrives
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }


            while (!upMinQue.isEmpty()) {
                int floor = upMinQue.poll();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevator.getId() + " currentFloor: " + elevator.getCurrent_floor());
                elevator.moveElevator(floor);
            }


            while (!downMaxQue.isEmpty()) {
                int floor = downMaxQue.poll();
                System.out.println("Serving floor: " + floor + " by elevator:" + elevator.getId() + " currentFloor: " + elevator.getCurrent_floor());
                elevator.moveElevator(floor);
            }
        }

    }
}
