import java.util.*;

public class Game {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter \"newGame \" to start game, or \"stop\" to quit: ");
                String method = "";
                method = scan.nextLine();

                if (method.equals("newGame")) {
                    System.out.println("Enter the number of categories: ");
                    int numCategories;
                    try {
                        numCategories = scan.nextInt();
                    } 
                    catch (InputMismatchException id) {
                        while (true) {
                            try {
                                numCategories = scan.nextInt();
                                break;
                            } 
                            catch (InputMismatchException id2) {
                                System.out.println("\n" + "You have entered something THAT WASN'T A NUMBER.... Please either type better or go back to school Enter Another Number:");
                                System.out.println("Exception ID: " + id2 + "\n");
                                scan.nextLine();
                            }
                        }
                    }
                    JeopardyBoard board = new JeopardyBoard(numCategories);
                    scan.nextLine();
                    while (true) {
                        System.out.println(
                                "\nWhat do you want to do next? \n Options: \n -seeAll \n -chooseQ \n -stopGame \n -modify");
                        String choice = scan.nextLine();
                        if (choice.equals("stopGame")) {
                            break;
                        } else if (choice.equals("seeAll")) {
                            board.printAllCategories();
                        } else if (choice.equals("chooseQ")) {
                            board.chooseQuestion();
                        } else if (choice.equals("modify")) {
                            board.modify();
                        } else {
                            System.out.println("Invalid response. Please try again");
                        }
                    }
                } else if (method.equals("stop")) {
                    break;
                } else {
                    System.out.println("Invalid response. Please enter a valid response");
                }
            }
        }
    }
}
