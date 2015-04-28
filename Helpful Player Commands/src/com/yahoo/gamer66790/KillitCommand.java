package com.yahoo.gamer66790;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillitCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		Player player = (Player) sender;
		World world = player.getWorld();
		if (cmd.getName().equalsIgnoreCase("killit") && sender instanceof Player && player.hasPermission("HPC.kill") || cmd.getName().equalsIgnoreCase("killit") && sender instanceof Player && sender.isOp()) {
			if (world.hasStorm() == true) {
				
				Bukkit.broadcastMessage(player.getName() + " killed the rain.");
				world.setStorm(false);
				return true;
			}
			player.sendMessage("It is not raining");
			return true;
		}
		
		return false;
	}
}
