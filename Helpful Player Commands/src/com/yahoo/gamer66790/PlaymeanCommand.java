package com.yahoo.gamer66790;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaymeanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		Player player = (Player) sender;
		World world = player.getWorld();
		if (cmd.getName().equalsIgnoreCase("playmean") && sender instanceof Player && sender.isOp()) {
			if (world.getPVP() == true) {
				
				player.sendMessage("PvP is already enabled.");
				
				return true;
			}
			Bukkit.broadcastMessage("Players can now kill each other. Good luck!");
			world.setPVP(true);
			
			return true;
		}
		
		return false;
	}

}
