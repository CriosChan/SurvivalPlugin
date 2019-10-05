package fr.criosdu79.pluginsurvivalteam.listeners;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EntityKilled implements Listener {
    public SurvivalTeamPlugin plugin;

    public EntityKilled(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        LivingEntity entity = event.getEntity();

        int AllPoint = plugin.getConfig().getInt("Users." + entity.getKiller().getUniqueId() + ".point");
        plugin.getConfig().addDefault("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);

        // getType() is inherited from Entity
        if(entity.getType() == EntityType.PLAYER) {
            AllPoint += 150;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez tué un joueur, vous gagner 150 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }

        if(entity.getType() == EntityType.ENDER_DRAGON) {
            AllPoint += 10500;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez tué un l'ender Dragon, vous gagner 10500 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }

        if(entity.getType() == EntityType.WITHER) {
            AllPoint += 5000;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez tué un le wither, vous gagner 5000 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }

        if(entity.getType() == EntityType.PIG) {
            AllPoint += 12;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 12 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.COW) {
            AllPoint += 12;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 12 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.SHEEP) {
            AllPoint += 12;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 12 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.MUSHROOM_COW) {
            AllPoint += 24;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 24 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.IRON_GOLEM) {
            AllPoint += 100;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 100 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.PILLAGER) {
            AllPoint += 32;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 32 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.RAVAGER) {
            AllPoint += 100;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 100 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.SPIDER) {
            AllPoint += 26;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 26 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.CAVE_SPIDER) {
            AllPoint += 26;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 26 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.ZOMBIE) {
            AllPoint += 29;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 29 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.SKELETON) {
            AllPoint += 29;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 29 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.CREEPER) {
            AllPoint += 35;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 35 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.PIG_ZOMBIE) {
            AllPoint += 38;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 38 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
        if(entity.getType() == EntityType.ENDERMAN) {
            AllPoint += 38;

            entity.getKiller().sendMessage(ChatColor.YELLOW + "Vous avez gagné 38 points !");
            plugin.getConfig().set("Users." + entity.getKiller().getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
    }
    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        int AllPoint = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".point");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".point", AllPoint);

        AllPoint -= 300;

        player.sendMessage(ChatColor.RED + "Vous avez été tué vous perdez 300 points");
        plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
        plugin.saveConfig();
    }
}
