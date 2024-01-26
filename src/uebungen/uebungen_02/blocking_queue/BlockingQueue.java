package uebungen.uebungen_02.blocking_queue;

import generel.buffer.BufferKindObject;
import generel.buffer.Consumer;
import generel.buffer.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue implements BufferKindObject<Integer> {

    private int maxLength;
    private int currentLength;
    private Queue<Integer> queue;

    public BlockingQueue(int length) throws IllegalArgumentException {
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new LinkedList<>();
        this.maxLength = length;
        System.out.println(this.currentLength + " "+this.queue.isEmpty());
    }

    public synchronized void put(Integer value, Producer producer) {
        while (this.currentLength == this.maxLength) {
            try {
                System.out.println(producer.getProducerName() + " waits..");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.queue.add(value);
        this.currentLength++;
        System.out.println(producer.getProducerName() + " puts value: " + value + "... currentLength: "+ this.currentLength);
        this.notifyAll();
    }

    public synchronized Integer get(Consumer consumer) {
        while (this.currentLength <= 0 || this.queue.isEmpty()) {
            try {
                System.out.println(consumer.getConsumerName() + " waits..");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int value = this.queue.remove();
        this.currentLength--;
        System.out.println(consumer.getConsumerName() + " gets value: " + value + "... currentLength: "+ this.currentLength);
        this.notifyAll();
        return value;
    }
}
