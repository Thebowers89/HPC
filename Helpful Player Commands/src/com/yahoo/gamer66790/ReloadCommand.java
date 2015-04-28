package com.yahoo.gamer66790;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;


public class ReloadCommand implements CommandExecutor {

    HPCCore plugin;
    public ReloadCommand(HPCCore instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("HPC.reload") || sender.isOp()) {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "HPC Reloaded.");
                return true;
            }
        }
        plugin.reloadConfig();
        Bukkit.getLogger().log(Level.INFO, ChatColor.GREEN + "HPC Config Reloaded.");
        return true;
    }

}
