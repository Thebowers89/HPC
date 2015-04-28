package com.yahoo.gamer66790.Commands;

import com.yahoo.gamer66790.HPCCore;
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
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();

            if (cmd.getName().equalsIgnoreCase("playnice") && sender.isOp()) {
                if (!world.getPVP()) {
                    player.sendMessage("PvP is already disabled.");
                    return true;
                }
                world.setPVP(false);
                Bukkit.broadcastMessage(plugin.getConfig().getString("Serverwide.pvp.disable") + " in " + world.getName());
                return true;
            }
        }
        return false;
    }
}