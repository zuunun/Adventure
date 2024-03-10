import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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


    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

//    public void setInventory(ArrayList<Item> inventory) {
//        this.inventory = inventory;
//    }

    public void takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            currentRoom.removeItem(item);
            addItem(item);
            System.out.println("You took the " + item.getShortName() + ".");
        } else {
            System.out.println("There is nothing like " + itemName + " to take around here.");
        }
    }
    public void dropItem(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item != null) {
            removeItem(item);
            currentRoom.addItem(item);
            System.out.println("You dropped the " + item.getShortName() + ".");
        } else {
            System.out.println("You don't have anything like " + itemName + " in your inventory.");
        }
    }


    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public String look() {
        StringBuilder roomInfo = new StringBuilder();
        roomInfo.append("You are in: ").append(currentRoom.getName());
        roomInfo.append("\n").append(currentRoom.getDescription());
        return roomInfo.toString();
    }

    public String showInventory() {
        List<Item> roomItems = currentRoom.getItemsInRoom();

        if (roomItems.isEmpty()) {
            return "The room is empty.";
        } else {
            StringJoiner joiner = new StringJoiner(", ");
            for (Item item : roomItems) {
                joiner.add(item.getShortName());
            }
            return "Inventory: " + joiner.toString();
        }
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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








