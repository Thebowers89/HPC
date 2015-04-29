package com.yahoo.gamer66790.Commands;

import com.yahoo.gamer66790.HPCCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaymeanCommand implements CommandExecutor {

    HPCCore plugin;
    public PlaymeanCommand(HPCCore instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            if (cmd.getName().equalsIgnoreCase("playmean") && sender.isOp()) {
                if (world.getPVP()) {
                    player.sendMessage("PvP is already enabled.");
                    return true;
                }
                Bukkit.broadcastMessage(ChatColor.GOLD + plugin.getConfig().getString("Serverwide.pvp.enable") +  " in " + world.getName());
                world.setPVP(true);
                return true;
            }
        }
        return false;
    }
}