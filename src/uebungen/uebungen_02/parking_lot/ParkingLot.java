package uebungen.uebungen_02.parking_lot;

public class ParkingLot {
    private int availablePlaces;

    public ParkingLot(int places) {
        this.availablePlaces = places;
    }

    public synchronized void enter() {
        while (availablePlaces <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        availablePlaces--;
    }

    public synchronized void leave() {
        availablePlaces++;
        this.notifyAll();
    }
}
