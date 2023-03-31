package tn.Utils;

public class Question {


    private final String answer;
    private final String question;

    public Question(String question,String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
