package com.yahoo.gamer66790;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
	
	HPCCore plugin;
	public FeedCommand(HPCCore instance) {
		plugin = instance;
	}
	
	public HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		
		if (cmd.getName().equalsIgnoreCase("feed") && sender instanceof Player && sender.isOp() || cmd.getName().equalsIgnoreCase("feed") && sender instanceof Player && sender.hasPermission("HPC.feed")) {
			 Player player = (Player) sender;
			
			 int cooldownTime = plugin.getConfig().getInt("Command.Cooldown-time");
			 
			 if (cooldown.containsKey(player.getUniqueId())) {
				 long secondsLeft = ((cooldown.get(player.getUniqueId()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
				 if (secondsLeft > 0) {
					 
					 player.sendMessage(ChatColor.RED + "Uhh, no sir.");
					 
					 return true;
				 }
				 cooldown.remove(player.getUniqueId());
				 
			 }
			 
			 player.setFoodLevel(20);
			 player.setSaturation(20f);
			 player.sendMessage(ChatColor.GREEN + "Your hunger has been satisfied... For Now.");
			 
			 cooldown.put(player.getUniqueId(), System.currentTimeMillis());
			 
			 return true;
		}
		
		return false;
	}

}

