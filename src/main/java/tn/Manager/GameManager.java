package tn.Manager;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tn.ConfigManager.ConfigManager;
import tn.SQL.SqlManager;
import tn.commands.Quiz;
import tn.main.main;

public class GameManager {


    private final String Prefix;
    private final PlayerManager playerManager;
    private final CategoryManager categoryManager;
    private final ConfigManager configManager;

    private SqlManager sqlManager;

    public GameManager(main main) {
        this.sqlManager = new SqlManager(main.getConfig());
        this.playerManager = new PlayerManager(this);
        this.categoryManager = new CategoryManager(this);
        this.configManager = new ConfigManager(this,main);
        this.Prefix = main.color(main.getConfig().getString("Prefix"));
    }


    public SqlManager getSqlManager() {
        return sqlManager;
    }

    public String getPrefix() {
        return Prefix;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public CategoryManager getCategoryManager() {
        return categoryManager;
    }


    public void startQuiz(Player p,String category){
        GameManager local = this;
        getPlayerManager().CreatePlayer(p.getUniqueId(),category);
        new BukkitRunnable(){
            int timer = 5;
            @Override
            public void run() {
                if(timer == 0){
                    p.sendTitle(main.color("&eQuiz Started!"),"",10,20,20);
                    new tn.Cooldown.Quiz(getConfigManager().getParmeters().getAnswer_Time(),local,getPlayerManager().getPlayer(p.getUniqueId())).runTaskTimer(main.getInstnace(),0,20);
                    cancel();
                }
                p.sendTitle(main.color("&eStarting Quiz in &b"+timer),main.color("&6Category: &b"+category),5,20,5);
                timer--;
            }
        }.runTaskTimer(main.getInstnace(),0,30);
        //start
    }
}
