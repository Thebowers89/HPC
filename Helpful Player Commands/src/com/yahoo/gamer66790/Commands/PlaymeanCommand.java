package com.yahoo.gamer66790.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaymeanCommand implements CommandExecutor {

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
                Bukkit.broadcastMessage("Players can now kill each other. Good luck!");
                world.setPVP(true);
                return true;
            }
        }
        return false;
    }
}