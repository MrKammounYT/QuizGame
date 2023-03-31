package tn.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import tn.Manager.GameManager;
import tn.commands.Quiz;
import tn.events.PlayerQuitEvent;
import tn.events.QuestionAnswerEvent;

public final class main extends JavaPlugin {


    private static main instnace;

    private GameManager manager;
    @Override
    public void onEnable() {
        super.onEnable();
        instnace = this;
        saveDefaultConfig();
        getLogger().info("Quiz Game Plugin is enabled");
        getLogger().info("Coded by MrKammounYT");
        this.manager = new GameManager(this);
        getCommand("Quiz").setExecutor(new Quiz(manager));
        Bukkit.getPluginManager().registerEvents(new QuestionAnswerEvent(manager) , this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent(manager), this);


    }

    public static main getInstnace() {
        return instnace;
    }

    public static String color(String f){
        return ChatColor.translateAlternateColorCodes('&', f);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
