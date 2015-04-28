package com.yahoo.gamer66790;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TTSCommand implements CommandExecutor {

	HPCCore plugin;
	public TTSCommand(HPCCore instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {

		Player player = (Player) sender;

		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("tts") || cmd.getName().equalsIgnoreCase("tothesky")) {
				if (sender.isOp() || sender.hasPermission("HPC.flight")) {
					if (player.getAllowFlight() == true){

						player.setAllowFlight(false);
						player.sendMessage(ChatColor.GREEN + "To the Ground.");
						return true;
					}
					player.setAllowFlight(true);
					player.sendMessage(ChatColor.GOLD + "To the Sky!");

					return true;
				}
				player.sendMessage("Permission, you do not have.");
			}

		}
		return false;
	}
}