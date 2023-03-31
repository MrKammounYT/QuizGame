package tn.Manager;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tn.Utils.QuizPlayer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {


    private GameManager manager;

    public PlayerManager(GameManager manager){
        this.manager = manager;
    }
    private final HashMap<UUID, QuizPlayer> players = new HashMap<UUID, QuizPlayer>();





    public QuizPlayer getPlayer(UUID uuid) {
        return players.get(uuid);
    }

    public void CreatePlayer(UUID uuid,String category){
        if(!players.containsKey(uuid)){
            players.put(uuid, new QuizPlayer(Bukkit.getPlayer(uuid),category,manager.getCategoryManager().getCategories().get(category)));
        }
    }
    public void deletePlayer(Player p){
        UUID uuid = p.getUniqueId();
        QuizPlayer quizPlayer = players.get(uuid);
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,4.0f,1.0f);
        p.sendMessage(manager.getConfigManager().getParmeters().getGame_over(quizPlayer.getCorrect_Questions(),quizPlayer.getCategoriesQuestions().size()));
        quizPlayer.getRunnable().cancel();
        manager.getSqlManager().getTable().addPoints(uuid.toString(),quizPlayer.getPoints());
        players.remove(uuid);
        }

    public boolean isPlaying(UUID uuid){
        return players.containsKey(uuid);
    }

}
