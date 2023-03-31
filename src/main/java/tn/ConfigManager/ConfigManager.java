package tn.ConfigManager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import tn.Config.Parmeters;
import tn.Manager.GameManager;
import tn.main.main;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final FileConfiguration config;
    private final Parmeters  Parmeters;


    private final File Category;//get path to category


    public ConfigManager(GameManager manager, main main){
        this.config = main.getConfig();
        this.Parmeters = new Parmeters(this);
        this.Category  = new File(main.getDataFolder(),"Category.yml");
        createCategoryFile();
        new LoadCategory(manager,YamlConfiguration.loadConfiguration(Category));

    }

    private void createCategoryFile(){
        if(!Category.exists()){
           main.getInstnace().saveResource("Category.yml",false);
        }
    }

    public tn.Config.Parmeters getParmeters() {
        return Parmeters;
    }


    public FileConfiguration getDefaultConfig() {
        return config;
    }
}
