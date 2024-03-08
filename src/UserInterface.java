import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Adventure newAdventure = new Adventure();

    public void startGame() {
        playGame(newAdventure.getGamePlayer());
    }

    public void playGame(Player player) {
        System.out.println("Welcome to the game!");
        System.out.println("You wake up on a dirty floor. You're in room 1!");
        int userChoice = 0;

        while (userChoice != 7) {
            menu();
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    if (player.moveAround()) {
                        System.out.println(player.getCurrentRoom().getName());
                        System.out.println(player.getCurrentRoom().getVisited());
                        System.out.println(player.getCurrentRoom().getItemsInRoomArr());
                        if (!player.getInventory().isEmpty()) {
                            Item itemToAdd = player.getInventory().get(0);
                            player.getCurrentRoom().addItem(itemToAdd);
                            System.out.println("You have added " + itemToAdd.getLongName() + " to the room.");
                        } else {
                            System.out.println("You have no items to add to the room.");
                        }
                    } else {
                        System.out.println("You can not go in that direction!");
                    }
                    break;
                case 2:
                    System.out.println(player.look());
                    break;
                case 3:
                    help();
                    break;
                case 4:
                    showInventory(player);
                    break;
                case 5:
                    takeItem(player);
                    break;
                case 6:
                    dropItem(player);
                    break;
                case 7:
                    System.out.println("Exit game");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void help() {
        System.out.println("Type 1 to choose which direction you wish to go in: North, South, East, or West.");
        System.out.println("Type 2 to look around the room you're currently in.");
        System.out.println("Type 3 for help (like you just did)");
        System.out.println("Type 4 for inventory.");
        System.out.println("Type 5 to take an item.");
        System.out.println("Type 6 to drop an item.");
        System.out.println("Type 7 to exit the game.");
    }

    public void menu() {
        System.out.println("1. Choose direction");
        System.out.println("2. Look");
        System.out.println("3. Help");
        System.out.println("4. Inventory");
        System.out.println("5. Take item");
        System.out.println("6. Drop item");
        System.out.println("7. Exit game");
    }

    public void showInventory(Player player) {
        System.out.println("Inventory: ");
        for (Item item : player.getInventory()) {
            System.out.println(" " + item.getLongName());
        }
    }

    private void takeItem(Player player) {
        System.out.println("Enter the name of the item you want to take:");
        String itemName = scanner.nextLine().toLowerCase();
        newAdventure.getGameMap().takeItem(player, itemName);
    }

    private void dropItem(Player player) {
        System.out.println("Enter the name of the item you want to drop:");
        String itemName = scanner.nextLine().toLowerCase();
        newAdventure.getGameMap().dropItem(player, itemName);
    }
}








