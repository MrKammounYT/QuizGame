package tn.ConfigManager;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import tn.Manager.GameManager;
import tn.Utils.Question;

import java.util.ArrayList;

public class LoadCategory {


    private final FileConfiguration config;
    private final GameManager manager;

    public LoadCategory(GameManager manager,FileConfiguration category){
        this.config = category;
        this.manager = manager;
        load();
    }

    public void load(){
        ConsoleCommandSender sender = Bukkit.getConsoleSender();
        if(config.getConfigurationSection("Category") == null){
            sender.sendMessage("§7Please Setup your Category.yml config");
            return ;
        }
        for(String category: config.getConfigurationSection("Category").getKeys(false)){
            ArrayList<Question> list = new ArrayList<Question>();
            for(String questions: config.getConfigurationSection("Category." +category + ".questions").getKeys(false)){
                String key = "Category." + category+".questions."+questions;
                    list.add(new
                            Question(config.getString(key+".question"), config.getString(key+".answer")));

            }
            manager.getCategoryManager().createCategory(category.toString(),list);
            sender.sendMessage("Loaded " + list.size() + " Questions in category " +category);
        }
    }



}
