import java.util.*;

public class JeopardyBoard {
    private category[] board;

    public JeopardyBoard(int NumberOfCategories) {
        try (Scanner scan = new Scanner(System.in)) {
            board = new category[NumberOfCategories];
            for (int i = 0; i < board.length; i++) {
                System.out.println(
                        "You are about to create a Column for the board. Please Enter the information when prompted ");
                System.out.println("Enter Number of questions: ");

                int numQuestions;
                try {
                    numQuestions = scan.nextInt();
                } catch (InputMismatchException id) {
                    while (true) {
                        try {
                            numQuestions = scan.nextInt();
                            break;
                        } catch (InputMismatchException id2) {
                            System.out.println("\n"
                                    + "You have entered something THAT WASN'T A NUMBER.... Please either type better or go back to school Enter Another Number:");
                            System.out.println("Exception ID: " + id2 + "\n");
                            scan.nextLine();
                        }
                    }
                }
                System.out.println("Enter category " + (i + 1) + " name: ");
                scan.nextLine();
                String categoryName = scan.nextLine();
                board[i] = new category(numQuestions, categoryName);
            }
        }
    }

    public void chooseQuestion() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Which category: ");
            String category = scan.nextLine();
            System.out.println("Point Value?");
            int pointValue = scan.nextInt();
            for (int i = 0; i < board.length; i++) {
                if (board[i].getCategory().equals(category)) {
                    for (int accessColumn = 0; accessColumn < board[i].catLength(); accessColumn++) {
                        if (board[i].getPointValue(accessColumn) == pointValue) {
                            if (!(board[i].isDone(accessColumn))) {
                                System.out.println("The question is: " + board[i].getQuestion(accessColumn));
                                System.out.print("Press Enter to reveal Answer: ");
                                scan.nextLine();
                                scan.nextLine();
                                System.out.println("The answer was: " + board[i].getAnswer(accessColumn));
                                board[i].questionAnswered(accessColumn);
                            } else {
                                System.out.println("Question has already been answered");
                            }
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Selection does not exist. Please make another selection");
    }

    public void modify() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the category NAME the corresponds to the question that you want to modify: ");
            String category = scan.nextLine();
            System.out.println("Enter the point value that corresponds to the question: ");
            int pointVal;
            try {
                pointVal = scan.nextInt();
            } catch (InputMismatchException id) {
                while (true) {
                    try {
                        pointVal = scan.nextInt();
                        break;
                    } catch (InputMismatchException id2) {
                        System.out.println("\n"
                                + "You have entered something THAT WASN'T A NUMBER.... Please either type better or go back to school Enter Another Number:");
                        System.out.println("Exception ID: " + id2 + "\n");
                        scan.nextLine();
                    }
                }
            }
            System.out.println("Modify \"question\", \"answer\" or \"both\"? : ");
            scan.nextLine();
            while (true) {
                String response = scan.nextLine();
                if (response.equals("question")) {
                    changeQuestion(category, pointVal);
                    break;
                } else if (response.equals("answer")) {
                    changeAnswer(category, pointVal);
                    break;
                } else if (response.equals("both")) {
                    changeAnswer(category, pointVal);
                    changeQuestion(category, pointVal);
                    break;
                } else {
                    System.out.println("Invalid response. Please enter \"question\", \"answer\", or \"both\" : ");
                }
            }
        }
    }

    public void changeAnswer(String category, int pointVal) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter new Answer: ");
            String newAnswer = scan.nextLine();
            for (int i = 0; i < board.length; i++) {
                if (board[i].getCategory().equals(category)) {
                    for (int accesColumn = 0; accesColumn < board[i].catLength(); accesColumn++) {
                        if (board[i].getPointValue(accesColumn) == pointVal) {
                            board[i].changeAnswer(accesColumn, newAnswer);
                            System.out.println("Succesfully Changed answer to Category " + category
                                    + "'s question with point value " + pointVal);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Attempt changeAnswer Entry does not exist");
    }

    public void changeQuestion(String category, int pointVal) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter new Question: ");
            String newQuestion = scan.nextLine();
            for (int i = 0; i < board.length; i++) {
                if (board[i].getCategory().equals(category)) {
                    for (int accesColumn = 0; accesColumn < board[i].catLength(); accesColumn++) {
                        if (board[i].getPointValue(accesColumn) == pointVal) {
                            board[i].changeQuestion(accesColumn, newQuestion);
                            System.out.println("Succesfully Changed question to Category " + category
                                    + "'s question with point value " + pointVal);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Attempt changeAnswer Entry does not exist");
    }

    public void printAllCategories() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(
                    "\n" + "Point Value Choices under " + board[i].getCategory() + ": " + board[i].toString() + "\n");
        }
    }
}
