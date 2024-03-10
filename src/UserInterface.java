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
        System.out.println(adventure.getGamePlayer().look());
        System.out.println(adventure.getGamePlayer().showInventory());
        while (true) {
            System.out.print("Enter your command: ");
            String input = scanner.nextLine().toLowerCase();

            switch (input.split(" ")[0]) { // consider only the first word for switch-case
                case "look":
                    System.out.println(adventure.getGamePlayer().look());
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
                    System.out.print("Enter the item name to drop: ");
                    String itemToDrop = scanner.nextLine();
                    adventure.getGamePlayer().dropItem(itemToDrop);
                    break;
                case "take":
                    System.out.print("Enter the item name to take: ");
                    String itemToTake = scanner.nextLine();
                    adventure.getGamePlayer().takeItem(itemToTake);
                    break;
                case "exit":
                    System.out.println("Exiting the game. Goodbye!");
                    return;
                default:
                    if (!adventure.getGamePlayer().moveAround(input)) {
                        System.out.println("You can't move in that direction. Please try another one!");
                    } else {
                        System.out.println(adventure.getGamePlayer().look());
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


}








