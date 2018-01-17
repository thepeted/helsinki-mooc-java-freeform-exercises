package mooc.airport;

public class Airplane {
    private String id;
    private int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " (" + capacity + " ppl)";
    }
}
