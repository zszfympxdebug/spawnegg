package com.zszf.spawnegg.event;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ToEgg implements Listener {
    @EventHandler
    public void egg(PlayerInteractAtEntityEvent e) {
        ItemStack is = e.getPlayer().getInventory().getItemInMainHand();
        if (is.getType() == Material.SHEARS) {
            e.setCancelled(true);
            EntityType et = e.getRightClicked().getType();
            Material egg;
            if(e.getRightClicked().getType()!= EntityType.PLAYER){
                try {
                    String egg_name = (et.name() + "_SPAWN_EGG").toUpperCase();
                    egg = Material.getMaterial(egg_name);
                } catch (Exception ex) {
                    e.getPlayer().sendMessage("未成功获取生物蛋");
                    return;
                }
                if (egg != null) {
                    e.getRightClicked().getWorld().dropItem(e.getRightClicked().getLocation(), new ItemStack(egg));
                    e.getRightClicked().remove();
                    e.getPlayer().sendMessage("成功将生物蛋割了下来");
                } else {
                    e.getPlayer().sendMessage("未成功获取生物蛋");
                }
            }else{
                e.getRightClicked().remove();
                e.getRightClicked().getWorld().dropItem(e.getRightClicked().getLocation(), new ItemStack(Material.PIG_SPAWN_EGG));
            }
        }
    }
}
