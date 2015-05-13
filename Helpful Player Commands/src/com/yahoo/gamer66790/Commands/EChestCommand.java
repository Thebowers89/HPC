package com.yahoo.gamer66790.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
        if(commandLabel.equalsIgnoreCase("echest") && sender instanceof Player && sender.hasPermission("HPC.echest") || commandLabel.equalsIgnoreCase("echest") && sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            Inventory eci = player.getEnderChest();

            player.openInventory(eci);

            return true;
        }

        return false;
    }

}
