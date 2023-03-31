package tn.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tn.Cooldown.Quiz;
import tn.Manager.GameManager;
import tn.Utils.QuizPlayer;
import tn.main.main;

public class QuestionAnswerEvent implements Listener {


    private GameManager manager;

    public QuestionAnswerEvent(GameManager manager){
        this.manager = manager;
    }

    @EventHandler
    public void onQuestionAnswer(AsyncPlayerChatEvent e){
        if(manager.getPlayerManager().isPlaying(e.getPlayer().getUniqueId())){
            e.setCancelled(true);
            Player p = e.getPlayer();
            QuizPlayer quizPlayer=manager.getPlayerManager().getPlayer(p.getUniqueId());
            if(quizPlayer.getCategoriesQuestions().get(quizPlayer.getQuestion()).getAnswer().equalsIgnoreCase(e.getMessage())){
                p.sendMessage(manager.getPrefix() + manager.getConfigManager().getParmeters().getCorrect_Answer());
                quizPlayer.getRunnable().cancel();
                quizPlayer.addcorrectanswer(1);
                quizPlayer.addPoints(1);
                quizPlayer.addQuestion(1);
                if(!quizPlayer.isLastQuestion()){
                    new Quiz(manager.getConfigManager().getParmeters().getAnswer_Time(),manager,quizPlayer).runTaskTimer(main.getInstnace(),0,20);
                }else{
                    manager.getPlayerManager().deletePlayer(p);
                }

            }else{
                p.sendMessage(manager.getPrefix()  + manager.getConfigManager().getParmeters().getWrong_Answer());
            }
        }
    }

}
