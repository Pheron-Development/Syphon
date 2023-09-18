package lol.vifez.syphon.Syphon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("speed")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players are able to use this command.");
            return true;
        }

        Player player = (Player) sender;

        // check permission for this command
        if (!player.hasPermission("syphon.command.speed")) {
            player.sendMessage("&cYou do not have permission to use this command.");
            return true;
        }

        if (args.length == 2) {
            String type = args[0];
            double value = Double.parseDouble(args[1]);

            if (type.equalsIgnoreCase("fly")) {
                if (value >= 1 && value <= 10) {
                    // Set fly speed directly, and normalize it for values above 1
                    player.setFlySpeed((float) (value > 1 ? 1 : value));
                    player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &bFly speed set to " + (value > 1 ? 1 : value));
                } else {
                    player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &bFly speed must be between 1 and 10.");
                }
            } else if (type.equalsIgnoreCase("walk")) {
                if (value >= 1 && value <= 10) {
                    // Set walk speed directly, and normalize it for values above 1
                    player.setWalkSpeed((float) (value > 1 ? 1 : value));
                    player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &bWalk speed set to " + (value > 1 ? 1 : value));
                } else {
                    player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &bWalk speed must be between 1 and 10.");
                }
            } else {
                player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &bUsage: /speed <fly:walk> <1-10>");
            }
        } else {
            player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &bUsage: /speed <fly:walk> <1-10>");
        }
        return true;
    }
}