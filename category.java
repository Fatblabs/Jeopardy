import java.util.*;
public class category {
    private jeopardySquare[] category;
    private String categoryName;

    public category(int numQuestions, String categoryName) {
        System.out.println("Category creation has been activated. You will begin creating questions");
        category = new jeopardySquare[numQuestions];
        this.categoryName = categoryName;
        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < category.length; i++) {
                System.out.println("Enter the question: ");
                String question = scan.nextLine();
                System.out.println("Enter the answer to this Question: ");
                String answer = scan.nextLine();
                System.out.println("Enter the point value (integers only): ");
                int pointVal = 0;
                try {
                    pointVal = scan.nextInt();
                }
                catch (InputMismatchException id) {
                    while (true) {
                        try {
                            pointVal = scan.nextInt();
                            break;
                        }
                        catch (InputMismatchException id2) {
                            System.out.println("\n" + "PLEASE PUT IN A PROPER VALUE (INTEGERS!!!). Like bro it's not that hard");
                            System.out.print("Exception ID: " + id);
                            scan.nextLine();
                        }
                    }
                }
                category[i] = new jeopardySquare(question, answer, pointVal);
                scan.nextLine();
            }
        }

    }
    public String getAnswer(int index) {
        return category[index].getAnswer();
    }
    public String getQuestion(int index) {
        return category[index].getQuestion();
    }
    public int getPointValue(int index) {
        return category[index].getPointValue();
    }
    public void questionAnswered(int index) {
        category[index].questionAnswered();
    }
    public boolean isDone(int index) {
        return category[index].isDone();
    }
    public void changeQuestion(int index, String newQuestion) {
        category[index].modifyQuestion(newQuestion);
    }
    public void changeAnswer(int index, String newAnswer) {
        category[index].modifyAnswer(newAnswer);
    }
    public String getCategory() {
        return categoryName;
    }
    public int catLength() {
        return category.length;
    }
    public String toString() {
        String returnString = "";
        for (int i = 0; i < category.length; i++) {
            returnString += category[i].getPointValue() + " ";
        }
        return returnString;
    }
}
