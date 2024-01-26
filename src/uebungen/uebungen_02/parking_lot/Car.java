package uebungen.uebungen_02.parking_lot;

public class Car extends Thread {
    private String name;
    private ParkingLot parkingLot;

    public Car(String name, ParkingLot parkingLot) {
        this.name = name;
        this.parkingLot = parkingLot;
    }

    public String getCarName() {
        return this.name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            this.parkingLot.enter();
            System.out.println(name + " entered parking lot");
            this.parkingLot.leave();
            System.out.println(name + " leaved parking lot");
        }
    }
}
