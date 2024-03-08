import com.sun.source.util.TaskEvent;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    Scanner scanner = new Scanner(System.in);

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
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

    public boolean moveAround() {
        System.out.println("Choose direction (n/s/e/w): ");
        String direction = scanner.nextLine().toLowerCase();

        switch (direction) {
            case "n":
            case "north":
                if (currentRoom.getNorth() != null) {
                    setCurrentRoom(currentRoom.getNorth());
                    return true;
                } else {
                    return false;
                }
            case "s":
            case "south":
                if (currentRoom.getSouth() != null) {
                    setCurrentRoom(currentRoom.getSouth());
                    return true;
                } else {
                    return false;
                }
            case "e":
            case "east":
                if (currentRoom.getEast() != null) {
                    setCurrentRoom(currentRoom.getEast());
                    return true;
                } else {
                    return false;
                }
            case "w":
            case "west":
                if (currentRoom.getWest() != null) {
                    setCurrentRoom(currentRoom.getWest());
                    return true;
                } else {
                    return false;
                }
            default:
                System.out.println("Invalid direction!");
                return false;
        }
    }
}






