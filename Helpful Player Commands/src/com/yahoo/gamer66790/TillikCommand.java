package com.yahoo.gamer66790;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TillikCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		Player player = (Player) sender;
		World world = player.getWorld();
		if (cmd.getName().equalsIgnoreCase("tillik") && sender instanceof Player && sender.isOp()) {
			if (world.hasStorm() == true) {
				
				player.sendMessage(ChatColor.RED + "It is already Raining.");
				return true;
			}
			
			Bukkit.broadcastMessage("Someone has decided our world isn't getting enough rain.");
			world.setStorm(true);
			return true;
		}
		
		return false;
	}

}
