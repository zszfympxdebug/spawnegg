package com.zszf.spawnegg;

import com.zszf.spawnegg.event.Events;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class BukkitPlugin extends JavaPlugin {

    public static JavaPlugin instance;
    public static Map<Player, Long> CDMAP;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ChatColor.RED + "Enabling spawnegg!");
        instance = this;
        getLogger().info(ChatColor.RED + "主类暴露！");
        Events events = new Events();
        events.loadEvent(this);
        getLogger().info(ChatColor.RED + "事件注册完毕！");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
