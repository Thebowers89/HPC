package com.yahoo.gamer66790.Commands;

import com.yahoo.gamer66790.HPCCore;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PocCommand implements CommandExecutor {

	HPCCore plugin;
	public PocCommand(HPCCore instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
		if (sender instanceof Player) {
            Player player = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("poc")) {
				if (sender.isOp() || sender.hasPermission("HPC.poc")) {
					if (player.getGameMode() == GameMode.CREATIVE) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage(ChatColor.GREEN + "You now have the POWER OF SURVIVAL!");
						return true;
					}
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.GOLD + "You now have the POWER OF CREATION!");
					return true;
				}
				return false;
			}
			player.sendMessage("Permission, you do not have.");
		}
		return false;
	}
	
}