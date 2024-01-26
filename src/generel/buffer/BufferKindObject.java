package generel.buffer;

public interface BufferKindObject<T> {
    void put(T value, Producer producer);
    T get(Consumer consumer);

}
