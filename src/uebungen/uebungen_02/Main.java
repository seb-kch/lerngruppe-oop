package uebungen.uebungen_02;

import generel.Aufgabe;
import generel.buffer.BufferKindObject;
import generel.buffer.Consumer;
import generel.buffer.Producer;
import uebungen.uebungen_02.blocking_queue.BlockingQueue;
import uebungen.uebungen_02.parking_lot.Car;
import uebungen.uebungen_02.parking_lot.ParkingLot;
import uebungen.uebungen_02.parking_lot.linked_list.CarQueue;
import uebungen.uebungen_02.parking_lot.linked_list.ParkingLotQueue;
import uebungen.uebungen_02.ring_buffer.RingBuffer;

public class Main {
    static Aufgabe a2_1_1 = new Aufgabe("2.1.1", () -> {
        ParkingLot pL = new ParkingLot(1);
        for (int i = 0; i < 10; i++) {
            Car c = new Car("c" + i, pL);
            c.start();
        }
        /**
         * Die Autos haben keine erkennbare Reihenfolge.
         */
    });

    static Aufgabe a2_1_2 = new Aufgabe("2.1.2", () -> {
        ParkingLotQueue pL = new ParkingLotQueue(1);
        new CarQueue("c1", pL).start();
        new CarQueue("c2", pL).start();
        new CarQueue("c3", pL).start();
    });

    static Aufgabe a2_2 = new Aufgabe("2.2", () -> {
        // TODO
    });
    static Aufgabe a2_3 = new Aufgabe("2.3", () -> {
        BufferKindObject bq = new BlockingQueue(5);
        (new Producer("p1", bq)).start();
        (new Producer("p2", bq)).start();
        (new Producer("p3", bq)).start();
        (new Producer("p4", bq)).start();

        (new Consumer("c1", bq)).start();
        (new Consumer("c2", bq)).start();
    });

    static Aufgabe a2_4 = new Aufgabe("2.3", () -> {
        BufferKindObject rb = new RingBuffer(5);
//        Producer p1 = new Producer("p1", rb);
//        Producer p2 = new Producer("p2", rb);
//
//        Consumer c1 = new Consumer("c1", rb);
//        Consumer c2 = new Consumer("c2", rb);
        (new Producer("p1", rb)).start();
        (new Producer("p2", rb)).start();
        (new Consumer("c1", rb)).start();
        (new Consumer("c2", rb)).start();

    });

    public static void main(String[] args) {
//        a2_1_1.execute();
//        a2_1_2.execute();
//        a2_2.execute();
//        a2_3.execute();
        a2_4.execute();
    }
}
