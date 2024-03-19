import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private boolean visited;
    private Room north;
    private Room east;
    private Room west;
    private Room south;

    private ArrayList<Item> itemsInRoomArr = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.visited = false;
    }
    // Method to add enemy to room
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    // Method to remove enemy from room
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    // Method to get enemies in room
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }


    public void addItem(Item item) {
        itemsInRoomArr.add(item);
    }

    public void removeItem(Item item) {
        itemsInRoomArr.remove(item);
    }

    public void addFood(Food food) {
        itemsInRoomArr.add(food);
    }

    public void removeFood(Food food) {
        itemsInRoomArr.remove(food);
    }

    public ArrayList<Item> getItemsInRoomArr() {
        return itemsInRoomArr;
    }


    public void setItemsInRoomArr(ArrayList itemsInRoomArr) {
        this.itemsInRoomArr = itemsInRoomArr;
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
        return visited;
    }

    public void setVisited() {
        if (!visited) {
            visited = true;
        }
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





