package fr.criosdu79.pluginsurvivalteam;
import fr.criosdu79.pluginsurvivalteam.commands.*;
import fr.criosdu79.pluginsurvivalteam.enums.Team;
import fr.criosdu79.pluginsurvivalteam.handler.ShopHandler;
import fr.criosdu79.pluginsurvivalteam.listeners.BlockBreaked;
import fr.criosdu79.pluginsurvivalteam.listeners.EntityKilled;
import fr.criosdu79.pluginsurvivalteam.listeners.PlayerDamage;
import fr.criosdu79.pluginsurvivalteam.listeners.PlayerHit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class SurvivalTeamPlugin extends JavaPlugin {

    private Map<Player, Team> players;

    @Override
    public void onEnable() {
        players = new HashMap<>();
        System.out.println("Survival Team Plugin a bien demare");
        getCommand("join").setExecutor(new CommandJoin(this));
        getCommand("team").setExecutor(new CommandTeam(this));
        getCommand("blockbreak").setExecutor(new CommandBlockBreak(this));
        getCommand("point").setExecutor(new CommandPoint(this));
        getCommand("shop").setExecutor(new CommandShop(this));
        loadConfig();
        registerListeners();
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        System.out.println("Survival Team Plugin vient de s'arrete");
    }

    public void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerDamage(this), this);
        pm.registerEvents(new PlayerHit(this), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreaked(this), this);
        this.getServer().getPluginManager().registerEvents(new EntityKilled(this), this);
        this.getServer().getPluginManager().registerEvents(new ShopHandler(this), this);
    }

    public Map<Player, Team> getPlayer(){
        return players;
    }
}
