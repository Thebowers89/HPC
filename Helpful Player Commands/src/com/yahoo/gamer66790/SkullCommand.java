package com.yahoo.gamer66790;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		Player player = (Player) sender;
		Inventory pi = player.getInventory();
		
		if (cmd.getName().equalsIgnoreCase("skull") && sender instanceof Player && sender.isOp() || sender.hasPermission("HPC.skull")) {
			if (args.length == 1) {
				
				ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
				SkullMeta sMeta = (SkullMeta) skull.getItemMeta();
				sMeta.setOwner(args[0]);
				skull.setItemMeta(sMeta);
				
				pi.addItem(skull);
				
				return true;
			}
			player.sendMessage(ChatColor.RED + "Proper Syntax: \n" + ChatColor.GREEN + "/skull <Player Name>");
			return true;
		}
		
		return false;
	}

}
