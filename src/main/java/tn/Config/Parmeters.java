package tn.Config;

import tn.ConfigManager.ConfigManager;
import tn.main.main;

public class Parmeters {

    private final String question;
    private final String time_up;
    private final String correct_Answer;

    private final String wrong_Answer;

    private final String game_over;

    private final int time;


    public Parmeters(ConfigManager configManager) {

        this.question = main.color(configManager.getDefaultConfig().getString("Messages.Question"));
        this.time_up = main.color(configManager.getDefaultConfig().getString("Messages.time-up"));
        this.correct_Answer = main.color(configManager.getDefaultConfig().getString("Messages.correct-answer"));
        this.wrong_Answer = main.color(configManager.getDefaultConfig().getString("Messages.wrong-answer"));
        this.time = configManager.getDefaultConfig().getInt("answer-time");
        this.game_over = main.color(configManager.getDefaultConfig().getString("Messages.game-over"));

    }


    public String getGame_over(int correctAnswer,int totalQuestion) {
        return game_over.replace("[correct_answers]",""+correctAnswer).replace("[total_questions]",""+totalQuestion).replace("&","§");
    }

    public int getAnswer_Time() {
        return time;
    }

    public String getCorrect_Answer() {
        return correct_Answer;
    }

    public String getTime_up(String answer) {
        return time_up.replace("[answer]", answer);
    }

    public String getWrong_Answer() {
        return wrong_Answer;
    }

    public String getQuestion(String question,int time) {
        return question.replace("[Question]",question).replace("[time]",""+time);
    }
}
