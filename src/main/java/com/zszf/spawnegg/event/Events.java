package com.zszf.spawnegg.event;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Events {
    public void loadEvent(JavaPlugin instance) {
        Bukkit.getPluginManager().registerEvents(new ToEgg(), instance);
    }
}
