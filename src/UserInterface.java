import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Adventure adventure;

    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        adventure = new Adventure();
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.println(adventure.getGamePlayer().look());
        boolean gameIsRunning = true;

        while (gameIsRunning) {
            System.out.print("Enter your command: ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "look":
                    System.out.println(adventure.getGamePlayer().look());
                    break;
                case "inventory", "inv", "invent":
                    System.out.println(adventure.getGamePlayer().showInventory());
                    break;
                case "exit":
                    gameIsRunning = false;
                    System.out.println("Exiting the game. Goodbye!");
                    break;
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

}








