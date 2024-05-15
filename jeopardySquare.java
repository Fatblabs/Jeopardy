public class jeopardySquare
{
    private String theQuestion;
    private String theAnswer;
    private boolean isDone = false;
    private int pointValue;

    public jeopardySquare(String question, String answer, int pointValue) {
        theQuestion = question;
        theAnswer = answer;
        this.pointValue = pointValue;
    }
    public boolean isDone() {
        return isDone;
    }
    public String getQuestion() {
        return theQuestion;
    }
    public String getAnswer() {
        return theAnswer;
    }
    public int getPointValue() {
        return pointValue;
    }
    public void questionAnswered() {
        isDone = !isDone;
    }
    public void modifyQuestion(String newQuestion) {
        theQuestion = newQuestion;
    }
    public void modifyAnswer(String newAnswer) {
        theAnswer = newAnswer;
    }
}