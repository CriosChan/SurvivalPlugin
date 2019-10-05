package fr.criosdu79.pluginsurvivalteam.handler;

import fr.criosdu79.pluginsurvivalteam.SurvivalTeamPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopHandler implements Listener {

    public SurvivalTeamPlugin plugin;

    public ShopHandler(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        int AllPoint = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".point");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".point", AllPoint);

        int Blé = plugin.getConfig().getInt("Users." + player.getUniqueId() + ".wheat");
        plugin.getConfig().addDefault("Users." + player.getUniqueId() + ".wheat", Blé);

        if(event.getView().getTitle().equalsIgnoreCase("Shop")){
            if(event.getCurrentItem().getType().equals(Material.WHEAT)){
                if(player.getInventory().contains(Material.WHEAT, 1)) {
                    if (Blé <= 2000) {
                        ItemStack wheat = new ItemStack(Material.WHEAT, 1);
                        player.getInventory().removeItem(wheat);

                        Blé += 1;
                        AllPoint += 5;

                        player.sendMessage(ChatColor.YELLOW + "Vous avez gagné 5 points");
                        plugin.getConfig().set("Users." + player.getUniqueId() + ".point", AllPoint);
                        plugin.getConfig().set("Users." + player.getUniqueId() + ".wheat", Blé);
                        plugin.saveConfig();
                    }
                }
            } event.setCancelled(true);
        }
    }
}
