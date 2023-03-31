package tn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tn.Manager.GameManager;
import tn.Utils.QuizPlayer;
import tn.main.main;

public class Quiz implements CommandExecutor {


    private final GameManager gameManager;

    public Quiz(GameManager gameManager){
        this.gameManager = gameManager;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))return  true;

        Player player =(Player) sender;
        if(!player.hasPermission("quiz.play")){
            player.sendMessage(gameManager.getPrefix() +main.color("you dont have permission to use this command."));
            return true;
        }
        if(args.length == 2){
            String cmd = args[0];
            if(cmd.equalsIgnoreCase("start")){
                String category = args[1];
                if(gameManager.getPlayerManager().isPlaying(player.getUniqueId())){
                    player.sendMessage(gameManager.getPrefix() + main.color("&cYou already in a quiz"));
                    return true;
                }
                if(!gameManager.getCategoryManager().getCategories().containsKey(category)){
                    player.sendMessage(gameManager.getPrefix() + main.color("&cThis is an invalid category "+gameManager.getCategoryManager().getCategories().keySet()));
                    return  true;
                }
                gameManager.startQuiz(player,category);
            }

        }else if(args.length == 1){
            String cmd = args[0];
            if(cmd.equalsIgnoreCase("stop")){
                if(!gameManager.getPlayerManager().isPlaying(player.getUniqueId())){
                    player.sendMessage(gameManager.getPrefix() + main.color("&cYou need to be in a quiz to use this command"));
                    return true;
                }
                gameManager.getPlayerManager().deletePlayer(player);
            }
            else if(cmd.equalsIgnoreCase("points")){
                player.sendMessage(gameManager.getPrefix() + main.color("&aYour Total Points are: &e"+gameManager.getSqlManager().getTable().getPoints(player.getUniqueId().toString())));
                return true;
            }
        }


        return true;
    }
}
