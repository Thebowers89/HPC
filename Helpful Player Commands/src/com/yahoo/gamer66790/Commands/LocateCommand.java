package com.yahoo.gamer66790.Commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocateCommand implements CommandExecutor {
    @SuppressWarnings("deprication")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[]) {
            if (sender.isOp() || sender.hasPermission("HPC.locate")) {
                if (commandLabel.equalsIgnoreCase("locate")) {
                    if (args.length == 1) {
                        Player player = (Player) sender;
                        Player user = sender.getServer().getPlayer(args[0]);

                        Location userl = user.getLocation();

                        String userw = userl.getWorld().getName().toString();

                        Double userx = userl.getX();
                        int userxint = userx.intValue();
                        Double usery = userl.getY();
                        int useryint = usery.intValue();
                        Double userz = userl.getZ();
                        int userzint = userz.intValue();

                        player.sendMessage(ChatColor.GOLD + args[0] + ChatColor.WHITE + " is in the world: " + ChatColor.GREEN + userw + ChatColor.WHITE + "\n X: " + userxint + "\n Y: " + useryint + "\n Z: " + userzint);
                        return true;
                    }
                    sender.sendMessage(ChatColor.RED + "You did this wrong.");
                    return true;
                }

            }

        return false;
    }


}
