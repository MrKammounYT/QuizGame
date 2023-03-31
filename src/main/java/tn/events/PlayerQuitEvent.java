package tn.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tn.Manager.GameManager;

public class PlayerQuitEvent implements Listener {

    private GameManager manager;

    public PlayerQuitEvent(GameManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {

        if(manager.getPlayerManager().isPlaying(event.getPlayer().getUniqueId())){
            manager.getPlayerManager().deletePlayer(event.getPlayer());
        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        manager.getSqlManager().getTable().CreatePlayer(e.getPlayer().getUniqueId().toString());
    }


}
