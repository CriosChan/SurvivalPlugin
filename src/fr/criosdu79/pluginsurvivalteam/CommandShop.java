package fr.criosdu79.pluginsurvivalteam;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandShop implements CommandExecutor {

    public SurvivalTeamPlugin plugin;

    public CommandShop(SurvivalTeamPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        Inventory inv = Bukkit.createInventory(null, 27, "Shop");

        inv.setItem(11, getItem(Material.WHEAT, ChatColor.GREEN + "Vendre 1 blé"));

        p.openInventory(inv);
        return false;
    }



    public ItemStack getItem(Material material, String customName){
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if(customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }
}
