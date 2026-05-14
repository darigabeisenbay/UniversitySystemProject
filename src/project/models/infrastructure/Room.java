package project.models.infrastructure;

public class Room {

    private int      id;
    private int      capacity;
    private RoomType type;

    public Room(int id, int capacity, RoomType type) {
        this.id       = id;
        this.capacity = capacity;
        this.type     = type;
    }

    public int      getId()       { return id; }
    public int      getCapacity() { return capacity; }
    public RoomType getType()     { return type; }

    @Override
    public String toString() {
        return "Room{id=" + id + ", capacity=" + capacity + ", type=" + type + "}";
    }
}