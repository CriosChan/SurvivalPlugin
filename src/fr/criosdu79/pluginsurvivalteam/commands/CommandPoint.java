package fr.criosdu79.pluginsurvivalteam.commands;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPoint implements CommandExecutor {
    public SurvivalTeamPlugin plugin;

    public CommandPoint(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            int AllPoint = plugin.getConfig().getInt("Users." + p.getUniqueId() + ".point");
            p.sendMessage(ChatColor.YELLOW + "================" + ChatColor.GREEN + "Total"+ ChatColor.YELLOW + "===================");
            p.sendMessage(ChatColor.GREEN + "Vos points : " + AllPoint);
            p.sendMessage(ChatColor.YELLOW + "================" + ChatColor.GREEN + "Total"+ ChatColor.YELLOW + "===================");
        }
        return false;
    }
}
