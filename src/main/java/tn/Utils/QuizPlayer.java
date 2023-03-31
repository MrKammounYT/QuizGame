package tn.Utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tn.Cooldown.Quiz;

import java.util.ArrayList;

public class QuizPlayer {


    private Player player;

    private int Question;

    private int points;

    private String Category;

    private Quiz quizRunnable;

    private int Correct_Question;

    private ArrayList<Question> CategoriesQuestions;


    public QuizPlayer(Player player, String Category,ArrayList<Question> categoriesQuestions){
        this.player = player;
        this.Question =0;
        this.Category = Category;
        this.points = 0;
        this.CategoriesQuestions = categoriesQuestions;
    }


    public int getCorrect_Questions() {
        return Correct_Question;
    }

    public void addcorrectanswer(int i){
        Correct_Question += i;
    }

    public boolean isLastQuestion(){
        return CategoriesQuestions.size() == Question;
    }
    public void addQuestion(int questionNumber){
        this.Question += questionNumber;
    }
    public void setRunnable(Quiz bukkitRunnable){
        this.quizRunnable = bukkitRunnable;
    }

    public Quiz getRunnable(){
        return quizRunnable;
    }

    public ArrayList<tn.Utils.Question> getCategoriesQuestions() {
        return CategoriesQuestions;
    }

    public String getCategory() {
        return Category;
    }

    public Player getPlayer() {
        return player;
    }

    public int getQuestion() {
        return Question;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
