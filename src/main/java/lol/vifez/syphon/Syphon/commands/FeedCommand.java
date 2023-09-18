package lol.vifez.syphon.Syphon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("feed")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players are able to use this command.");
            return true;
        }

        Player player = (Player) sender;

        // check perms for this command
        if (!player.hasPermission("syphon.command.feed")) {
            player.sendMessage("&cYou do not have permission to use this command.");
            return true;
        }

        player.setFoodLevel(20);
        return true;
    }
}