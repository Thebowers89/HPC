package com.yahoo.gamer66790;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayniceCommand implements CommandExecutor {
	
	HPCCore plugin;
	public PlayniceCommand(HPCCore instance) {
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if (cmd.getName().equalsIgnoreCase("playnice") && sender instanceof Player && sender.isOp()) {
			if (world.getPVP() == false) {
				
				player.sendMessage("PvP is already disabled.");
				return true;
			}
			world.setPVP(false);
			Bukkit.broadcastMessage(plugin.getConfig().getString("Serverwide.pvp.disable") + " in " + world.getName());
			
			return true;
		}
		
		return false;
	}

}