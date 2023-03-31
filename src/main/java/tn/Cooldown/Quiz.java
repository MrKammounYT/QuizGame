package tn.Cooldown;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import tn.Manager.GameManager;
import tn.Utils.QuizPlayer;
import tn.main.main;

public class Quiz extends BukkitRunnable {


    int timer;
    private final QuizPlayer player;


    private final GameManager manager;



    public Quiz(int timer,GameManager gm, QuizPlayer player){
        this.timer = timer;
        this.manager = gm;
        this.player = player;
        player.setRunnable(this);
        player.getPlayer().sendMessage(manager.getPrefix()+ manager.getConfigManager().getParmeters().getQuestion(player.getCategoriesQuestions().get(player.getQuestion()).getQuestion(),timer));

    }

    @Override
    public void run() {
        player.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6Category: "+player.getCategory() +" §7▏ §eTimeLeft: §b"+timer));
        if(timer == 0){
            String answer = player.getCategoriesQuestions().get(player.getQuestion()).getAnswer();
            player.getPlayer().sendMessage(manager.getPrefix() + manager.getConfigManager().getParmeters().getTime_up(answer));
            player.getPlayer().playSound(player.getPlayer().getLocation(), Sound.ENTITY_VILLAGER_NO, 3.0f, 1.0f);
            player.addQuestion(1);
            if(!player.isLastQuestion()){
                new Quiz(manager.getConfigManager().getParmeters().getAnswer_Time(),manager,player).runTaskTimer(main.getInstnace(),0,20);
            }else{
                manager.getPlayerManager().deletePlayer(player.getPlayer());
            }
            cancel();
        }

        timer--;
    }
}
