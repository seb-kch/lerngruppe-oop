package uebungen.uebungen_02.ring_buffer;

import generel.buffer.BufferKindObject;
import generel.buffer.Consumer;
import generel.buffer.Producer;

import java.util.Arrays;

public class RingBuffer<T> implements BufferKindObject<T> {

    private int rear, front = 0;
    private int length;
    private T[] storage;

    public RingBuffer(int length) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.storage = (T[]) new Object[length];
    }

    public synchronized void put(T value, Producer producer) {
        this.storage[rear] = value;
        this.rear = (this.rear + 1) % this.length;
        System.out.println(producer.getProducerName() + " puts value: " + value);
        this.notifyAll();
    }

    public synchronized T get(Consumer consumer) {
        while (this.storage.length == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Arrays.toString(this.storage));
        T value = this.storage[this.front];
        System.out.println(consumer.getConsumerName() + " gets value: " + value);
        this.front = (this.front + 1) % this.length;
        return value;
    }
}