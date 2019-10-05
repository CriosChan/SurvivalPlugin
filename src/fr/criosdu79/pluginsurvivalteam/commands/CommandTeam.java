package fr.criosdu79.pluginsurvivalteam.commands;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandTeam implements CommandExecutor {
    public SurvivalTeamPlugin plugin;

    public CommandTeam(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            String team1 = plugin.getConfig().getString("Users." + p.getUniqueId() + ".team");
            if (team1.intern() == "blue") {
                p.sendMessage(ChatColor.GRAY + "Vous êtes dans l'équipe " + ChatColor.BLUE + "bleu");
            }
            if (team1.intern() == "red") {
                p.sendMessage(ChatColor.GRAY + "Vous êtes dans l'équipe " + ChatColor.RED + "rouge");
            }
            if (team1.intern() == "green") {
                p.sendMessage(ChatColor.GRAY + "Vous êtes dans l'équipe " + ChatColor.GREEN + "verte");
            }
        }
        return false;
    }
}
