package fr.criosdu79.pluginsurvivalteam.listeners;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerHit implements Listener {
    public SurvivalTeamPlugin plugin;

    public PlayerHit(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Projectile && e.getEntity() instanceof Player) {
            Projectile a = (Projectile)e.getDamager();
            if (a.getShooter() instanceof Player){
                Player shooter = (Player)a.getShooter();
                if (plugin.getPlayer().containsKey(shooter) && plugin.getPlayer().containsKey(e.getEntity())){
                    if(plugin.getPlayer().get(shooter) == plugin.getPlayer().get(e.getEntity())){
                        e.setCancelled(true);
                        shooter.sendMessage(ChatColor.RED + "Vous ne pouvez pas frapper votre team !");
                    }
                }
            }
        }
    }
}
