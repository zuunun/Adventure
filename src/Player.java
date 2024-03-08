import com.sun.source.util.TaskEvent;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private Room previousRoom;
    private final ArrayList<Item> inventory;
    private Scanner scanner;

    public Player(Room firstRoom) {
        currentRoom = firstRoom;
        inventory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void takeItem(Item item) {
        inventory.add(item);
        currentRoom.removeItem(item);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
        currentRoom.addItem(item);
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public String showInventory() {
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        } else {
            StringBuilder inventoryString = new StringBuilder("Inventory: ");
            for (Item item : inventory) {
                inventoryString.append(item.getShortName()).append(", ");
            }
            // Remove the trailing comma and space
            inventoryString.setLength(inventoryString.length() - 2);
            return inventoryString.toString();
        }
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String look() {
        String roomInfo = "You are in: " + currentRoom.getName() + "\n" + currentRoom.getDescription() + "\n";
        return roomInfo;
    }

    public boolean moveAround(String direction) {
        switch (direction) {
            case "north", "n":
                return goNorth();
            case "west", "w":
                return goWest();
            case "east", "e":
                return goEast();
            case "south", "s":
                return goSouth();
            default:
                return false;
        }
    }

    public boolean goNorth() {
        Room northRoom = this.currentRoom.getNorth();
        if (northRoom != null) {
            this.currentRoom = northRoom;
            return true; // moved north
        } else {
            System.out.println("No room to the north");
            return false;
        }
    }

    public boolean goWest() {
        Room westRoom = this.currentRoom.getWest();
        if (westRoom != null) {
            this.currentRoom = westRoom;
            return true; // moved west
        } else {
            System.out.println("No room to the west");
            return false;
        }
    }

    public boolean goEast() {
        Room eastRoom = this.currentRoom.getEast();
        if (eastRoom != null) {
            this.currentRoom = eastRoom;
            return true; // moved east
        } else {
            System.out.println("No room to the east");
            return false;
        }
    }

    public boolean goSouth() {
        Room southRoom = this.currentRoom.getSouth();
        if (southRoom != null) {
            this.currentRoom = southRoom;
            return true; // moved east
        } else {
            System.out.println("No room to the south");
            return false;
        }
    }
}








