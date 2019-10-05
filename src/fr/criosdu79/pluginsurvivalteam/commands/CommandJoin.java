package fr.criosdu79.pluginsurvivalteam.commands;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import fr.criosdu79.pluginsurvivalteam.enums.Team;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandJoin implements CommandExecutor {

    public SurvivalTeamPlugin plugin;

    public CommandJoin(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;
            if (strings.length >= 1) {
                String team = strings[0];
                if (team.equalsIgnoreCase("blue")) {
                    if (plugin.getPlayer().containsKey(p)) {
                        plugin.getPlayer().remove(p);
                    }
                    p.sendMessage(ChatColor.GRAY + "Vous avez rejoind l'equipe " + ChatColor.BLUE + team);
                    plugin.getPlayer().put(p, Team.valueOf(team.toUpperCase()));
                    plugin.getConfig().set("Users." + p.getUniqueId() + ".team", team);
                    plugin.saveConfig();
                    return false;
                }
                if (team.equalsIgnoreCase("red")) {
                    if (plugin.getPlayer().containsKey(p)) {
                        plugin.getPlayer().remove(p);
                    }
                    p.sendMessage(ChatColor.GRAY + "Vous avez rejoind l'equipe " + ChatColor.RED + team);
                    plugin.getPlayer().put(p, Team.valueOf(team.toUpperCase()));
                    plugin.getConfig().set("Users." + p.getUniqueId() + ".team", team);
                    plugin.saveConfig();
                    return false;
                }
                if (team.equalsIgnoreCase("green")) {
                    if (plugin.getPlayer().containsKey(p)) {
                        plugin.getPlayer().remove(p);
                    }
                    p.sendMessage(ChatColor.GRAY + "Vous avez rejoind l'equipe " + ChatColor.GREEN + team);
                    plugin.getPlayer().put(p, Team.valueOf(team.toUpperCase()));
                    plugin.getConfig().set("Users." + p.getUniqueId() + ".team", team);
                    plugin.saveConfig();
                    return false;
                }

            }
            p.sendMessage(ChatColor.GRAY + "/join [red, blue, green]");
        } else {
            commandSender.sendMessage(ChatColor.RED + "Vous ne pouvez pas utilise cette commande.");
        }
        return false;
    }
}
