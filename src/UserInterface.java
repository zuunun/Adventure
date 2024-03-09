import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {
    private final Scanner scanner;
    private final Adventure adventure;

    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        adventure = new Adventure();
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game! Type 'help' for further instructions!");
        System.out.println(look());
        while (true) {
            System.out.print("Enter your command: ");
            String input = scanner.nextLine().toLowerCase();

            switch (input.split(" ")[0]) { // consider only the first word for switch-case
                case "look":
                    System.out.println(look());
                    break;
                case "inventory":
                case "inv":
                case "invent":
                    System.out.println(adventure.getGamePlayer().showInventory());
                    break;
                case "help":
                    help();
                    break;
                case "drop":
                    handleItemAction(input);
                    break;
                case "take":
                    handleItemAction(input);
                    break;
                case "exit":
                    System.out.println("Exiting the game. Goodbye!");
                    return;
                default:
                    if (!adventure.getGamePlayer().moveAround(input)) {
                        System.out.println("You can't move in that direction. Please try another one!");
                    } else {
                        System.out.println(look());
                    }
                    break;
            }
        }
    }

    private void help() {
        System.out.println("help is on its way...");
        System.out.println("type 'north' to go north");
        System.out.println("type 'west' will make you go west");
        System.out.println("type 'east' will make you go east");
        System.out.println("type 'south' to go south");
        System.out.println("type 'exit' to exit the game");
        System.out.println("type 'look' to give you a description of the room you are in");
    }

    private String look() {
        Room currentRoom = adventure.getGamePlayer().getCurrentRoom();
        StringBuilder roomInfo = new StringBuilder("You are in: " + currentRoom.getName() + "\n" +
                currentRoom.getDescription() + "\n");

        List<Item> itemsInRoom = currentRoom.getItemsInRoomArr();
        if (!itemsInRoom.isEmpty()) {
            roomInfo.append("Items in the room: ")
                    .append(itemsInRoom.stream().map(Item::getShortName).collect(Collectors.joining(", ")))
                    .append("\n");
        } else {
            roomInfo.append("There are no items in the room.\n");
        }

        return roomInfo.toString();
    }

    private void handleItemAction(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("You must specify an item to " + parts[0] + ".");
            return;
        }
        String action = parts[0].toLowerCase();
        String itemName = parts[1].toLowerCase();

        if ("drop".equals(action)) {
            adventure.getGamePlayer().drop(itemName);
        } else if ("take".equals(action)) {
            adventure.getGamePlayer().take(itemName);
        }
    }

    private void dropItem(String itemName, Adventure adventure) {
        Player player = adventure.getGamePlayer();
        Item item = player.findItemInInventory(itemName);

        if (item != null) {
            adventure.getGamePlayer().drop("");
            //player.drop(item);
            adventure.getGamePlayer().getCurrentRoom().addItem(item);
            System.out.println("You dropped " + item.getShortName());
        } else {
            System.out.println("You don't have that item in your inventory");
        }
    }

    private void takeItem(String itemName, Adventure adventure) {
        Player player = adventure.getGamePlayer();
        Item item = adventure.getGamePlayer().getCurrentRoom().findItem(itemName);

        if (item != null) {
            adventure.getGamePlayer().take("");
            //player.take(item);
            adventure.getGamePlayer().getCurrentRoom().removeItem(item);
            System.out.println("You took " + item.getShortName());
        } else {
            System.out.println("There is no such item in this room");
        }
    }

    private String extractName(String input) {
        return input.replace("drop", "").replace("take", "").trim().toLowerCase();
    }
}








