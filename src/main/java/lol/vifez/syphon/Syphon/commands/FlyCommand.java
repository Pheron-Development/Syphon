package lol.vifez.syphon.Syphon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("fly")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players are able to use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("syphon.command.fly")) {
            player.sendMessage("&cYou do not have permission to use this command.");
            return true;
        }

        if (!player.getAllowFlight()) {
            player.setAllowFlight(true);
            player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &aFly mode enabled.");
        } else {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage("&bS&9y&bt&9h&bo&9n&7: &cFly mode disabled.");
        }
        return true;
    }
}