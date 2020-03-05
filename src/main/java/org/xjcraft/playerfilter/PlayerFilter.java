package org.xjcraft.playerfilter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.xjcraft.CommonPlugin;
import org.xjcraft.playerfilter.config.Config;

import java.util.regex.Pattern;

public final class PlayerFilter extends CommonPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfigs();
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void login(PlayerJoinEvent event) {
        if (!Config.config.getNameBlocker()) return;
        Player player = event.getPlayer();
        boolean matches = Pattern.matches(Config.config.getNameRegex(), player.getName());
        if (!matches) {
            player.kickPlayer("不允许的玩家名！");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void blockFML(PlayerLoginEvent event) {
        if (!Config.config.getModBlocker()) return;
        if (event.getHostname().contains("FML") && !event.getPlayer().isOp()) {
            this.getLogger().info(String.format("%s tried to connect with modded client:%s", event.getPlayer().getName(),event.getHostname()));
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Config.config.getModMessage());
        }
    }
}
