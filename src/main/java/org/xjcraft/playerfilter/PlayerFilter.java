package org.xjcraft.playerfilter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Pattern;

public final class PlayerFilter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void login(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        boolean matches = Pattern.matches("[a-zA-z0-9_]{3,16}", player.getName());
        if (!matches){
            player.kickPlayer("不允许的玩家名！");
        }
//        if (player.getName().startsWith("$")
//                || player.getName().length() < 3
//                || player.getName().contains(" ")) {
//
//        }
    }
}
