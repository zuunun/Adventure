import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private boolean visited;
    private Room north;
    private Room east;
    private Room west;
    private Room south;
    private ArrayList<Item> itemsInRoom = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.visited = false;
    }

    public void addItem(Item item) {
        itemsInRoom.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoom.remove(item);
    }

    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public Item findItem(String itemName) {
        for (Item item : itemsInRoom) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


    public void setItemsInRoom(ArrayList itemsInRoomA) {
        this.itemsInRoom = itemsInRoom;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public boolean getVisited() {
        if (!visited) {
            visited = true;
            return true;
        } else {
            System.out.println("I've already been in this room");
            return false;
        }
    }

    public void resetVisited() {
        this.visited = false;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void String(boolean visited) {
        this.visited = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }


}





