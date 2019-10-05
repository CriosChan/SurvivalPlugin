package fr.criosdu79.pluginsurvivalteam.commands;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBlockBreak implements CommandExecutor {

    public SurvivalTeamPlugin plugin;

    public CommandBlockBreak(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            int diamond_ore = plugin.getConfig().getInt("Users." + p.getUniqueId() + ".diamond_ore");
            int coal_ore = plugin.getConfig().getInt("Users." + p.getUniqueId() + ".coal_ore");
            int iron_ore = plugin.getConfig().getInt("Users." + p.getUniqueId() + ".iron_ore");
            int gold_ore = plugin.getConfig().getInt("Users." + p.getUniqueId() + ".gold_ore");
            int emerald_ore = plugin.getConfig().getInt("Users." + p.getUniqueId() + ".emerald_ore");
            p.sendMessage(ChatColor.YELLOW + "================" + ChatColor.RED + "Minage"+ ChatColor.YELLOW + "===================");
            p.sendMessage(ChatColor.GREEN + "Charbon : " + coal_ore + "/1500");
            p.sendMessage(ChatColor.GREEN + "Fer : " + iron_ore + "/1500");
            p.sendMessage(ChatColor.GREEN + "Or : " + gold_ore + "/1500");
            p.sendMessage(ChatColor.GREEN + "Diamants : " + diamond_ore + "/500");
            p.sendMessage(ChatColor.GREEN + "Emerauds : " + emerald_ore + "/150");
            p.sendMessage(ChatColor.YELLOW + "================" + ChatColor.RED + "Minage"+ ChatColor.YELLOW + "===================");
        }
        return false;
    }
}
