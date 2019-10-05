package fr.criosdu79.pluginsurvivalteam.listeners;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamage implements Listener {
    public SurvivalTeamPlugin plugin;

    public PlayerDamage(SurvivalTeamPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            if (plugin.getPlayer().containsKey(e.getDamager()) && plugin.getPlayer().containsKey(e.getEntity())){
                if (plugin.getPlayer().get(e.getDamager()) == plugin.getPlayer().get(e.getEntity())){
                    e.setCancelled(true);
                    e.getDamager().sendMessage(ChatColor.RED + "Vous ne pouvez pas frapper votre team !");
                }
            }
        }
    }
}
