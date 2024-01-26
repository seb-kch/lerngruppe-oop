package uebungen.uebungen_02.parking_lot.linked_list;

import java.util.LinkedList;
import java.util.Queue;

public class ParkingLotQueue {
    private int availablePlaces;
    private Queue<CarQueue> queue;
    public ParkingLotQueue(int places) {
        this.availablePlaces = places;
        this.queue = new LinkedList();
    }

    public synchronized void enter(CarQueue car) {
        this.queue.add(car);
        while (availablePlaces <= 0 || this.queue.peek() != car) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(car.getCarName() + " entered parking lot");
        this.queue.remove();
        availablePlaces--;
        this.notifyAll();
    }

    public synchronized void leave(CarQueue car) {
        availablePlaces++;
        System.out.println(car.getCarName() + " leaved parking lot");
        this.notifyAll();
    }

}
