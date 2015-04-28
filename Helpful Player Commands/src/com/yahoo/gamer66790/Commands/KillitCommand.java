package com.yahoo.gamer66790.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            if (cmd.getName().equalsIgnoreCase("killit")) {
                if (player.hasPermission("HPC.killall")) {
                    if (world.hasStorm()) {
                        Bukkit.broadcastMessage(player.getName() + " killed the rain in " + world.getName());
                        world.setStorm(false);
                        return true;
                    }
                    player.sendMessage("It is not raining");
                    return true;
                }
            }
        }

        return false;
    }
}