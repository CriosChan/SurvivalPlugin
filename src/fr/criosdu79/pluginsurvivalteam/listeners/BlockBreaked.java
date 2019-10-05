package fr.criosdu79.pluginsurvivalteam.listeners;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreaked implements Listener {
    public SurvivalTeamPlugin plugin;

    public BlockBreaked(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();

        int AllPoint = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".point");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".point", AllPoint);

        int diamond_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".diamond_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".diamond_ore", diamond_ore);

        int coal_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".coal_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".coal_ore", coal_ore);

        int iron_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".iron_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".iron_ore", iron_ore);

        int gold_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".gold_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".gold_ore", gold_ore);

        int emerald_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".emerald_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".emerald_ore", emerald_ore);

        //Minage

        if (material.equals(Material.DIAMOND_ORE)) {
            if (diamond_ore <= 500) {
                diamond_ore += 1;
                plugin.getConfig().set("Users." + player.getUniqueId() + ".diamond_ore", diamond_ore);
                plugin.saveConfig();

                AllPoint += 25;
                player.sendMessage(ChatColor.GREEN + "Vous avez obtenu 25 points");
                plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
                plugin.saveConfig();
            }
        }

        if (material.equals(Material.COAL_ORE)) {
            if (coal_ore <= 1500) {
                coal_ore += 1;
                plugin.getConfig().set("Users." + player.getUniqueId() + ".coal_ore", coal_ore);
                plugin.saveConfig();

                AllPoint += 5;
                player.sendMessage(ChatColor.GREEN + "Vous avez obtenu 5 points");
                plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
                plugin.saveConfig();
            }
        }

        if (material.equals(Material.IRON_ORE)) {
            if (iron_ore <= 1500) {
                iron_ore += 1;
                plugin.getConfig().set("Users." + player.getUniqueId() + ".iron_ore", iron_ore);
                plugin.saveConfig();

                AllPoint += 13;
                player.sendMessage(ChatColor.GREEN + "Vous avez obtenu 13 points");
                plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
                plugin.saveConfig();
            }
        }

        if (material.equals(Material.GOLD_ORE)) {
            if (gold_ore <= 1500) {
                gold_ore += 1;
                plugin.getConfig().set("Users." + player.getUniqueId() + ".gold_ore", gold_ore);
                plugin.saveConfig();

                AllPoint += 20;
                player.sendMessage(ChatColor.GREEN + "Vous avez obtenu 20 points");
                plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
                plugin.saveConfig();
            }
        }
        if (material.equals(Material.EMERALD_ORE)) {
            if (emerald_ore <= 150) {
                emerald_ore += 1;
                plugin.getConfig().set("Users." + player.getUniqueId() + ".emerald_ore", emerald_ore);
                plugin.saveConfig();

                AllPoint += 30;
                player.sendMessage(ChatColor.GREEN + "Vous avez obtenu 30 points");
                plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
                plugin.saveConfig();
            }
        }
    }

    @EventHandler
    public void blockAdd(BlockPlaceEvent event) {
        Block block = event.getBlock();
        Material material = block.getType();
        Player player = event.getPlayer();

        int AllPoint = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".point");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".point", AllPoint);

        int diamond_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".diamond_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".diamond_ore", diamond_ore);

        int coal_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".coal_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".coal_ore", coal_ore);

        int iron_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".iron_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".iron_ore", iron_ore);

        int gold_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".gold_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".gold_ore", gold_ore);

        int emerald_ore = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".emerald_ore");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".emerald_ore", emerald_ore);

        if (material.equals(Material.DIAMOND_ORE)) {
            diamond_ore -= 1;
            plugin.getConfig().set("Users." + player.getUniqueId() + ".diamond_ore", diamond_ore);
            plugin.saveConfig();

            AllPoint -= 25;
            player.sendMessage(ChatColor.RED + "Vous avez perdu 25 points");
            plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }

        if (material.equals(Material.COAL_ORE)) {
            coal_ore -= 1;
            plugin.getConfig().set("Users." + player.getUniqueId() + ".coal_ore", coal_ore);
            plugin.saveConfig();

            AllPoint -= 5;
            player.sendMessage(ChatColor.RED + "Vous avez perdu 5 points");
            plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }

        if (material.equals(Material.IRON_ORE)) {

            iron_ore -= 1;
            plugin.getConfig().set("Users." + player.getUniqueId() + ".iron_ore", iron_ore);
            plugin.saveConfig();

            AllPoint -= 13;
            player.sendMessage(ChatColor.RED + "Vous avez perdu 13 points");
            plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();

        }

        if (material.equals(Material.GOLD_ORE)) {

            gold_ore -= 1;
            plugin.getConfig().set("Users." + player.getUniqueId() + ".gold_ore", gold_ore);
            plugin.saveConfig();

            AllPoint -= 20;
            player.sendMessage(ChatColor.RED + "Vous avez perdu 20 points");
            plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();

        }
        if (material.equals(Material.EMERALD_ORE)) {
            emerald_ore -= 1;
            plugin.getConfig().set("Users." + player.getUniqueId() + ".emerald_ore", emerald_ore);
            plugin.saveConfig();

            AllPoint -= 30;
            player.sendMessage(ChatColor.RED + "Vous avez perdu 30 points");
            plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
            plugin.saveConfig();
        }
    }
}