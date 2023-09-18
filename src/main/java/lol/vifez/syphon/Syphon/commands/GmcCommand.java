package lol.vifez.syphon.Syphon.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

public class GmcCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("gmc")) {
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players are able to use this command.");
            return true;
        }

        Player player = (Player) sender;

        // check permission for this commadn
        if (!player.hasPermission("syphon.command.gmc")) {
            player.sendMessage("&cYou do not have permission to use this command.");
            return true;
        }

        player.setGameMode(GameMode.CREATIVE);
        return true;
    }
}