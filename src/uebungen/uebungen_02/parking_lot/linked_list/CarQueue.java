package uebungen.uebungen_02.parking_lot.linked_list;

public class CarQueue extends Thread {
    private String name;
    private ParkingLotQueue parkingLot;

    public CarQueue(String name, ParkingLotQueue parkingLot) {
        this.name = name;
        this.parkingLot = parkingLot;
    }

    public String getCarName() {
        return this.name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            this.parkingLot.enter(this);

            this.parkingLot.leave(this);

        }
    }
}
