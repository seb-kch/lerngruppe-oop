package generel.buffer;

public class Consumer<T> extends Thread {
    private String name;
    private BufferKindObject<T> buffer;

    public Consumer(String name, BufferKindObject<T> buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < Producer.N; i++) {
            T value = buffer.get(this);
        }
    }

    public String getConsumerName() {
        return name;
    }
}
