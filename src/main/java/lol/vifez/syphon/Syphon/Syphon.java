package lol.vifez.syphon.Syphon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.GameMode;
import org.bukkit.command.ConsoleCommandSender;

public class Syphon extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // commands reg
        getCommand("gms").setExecutor(this);
        getCommand("gmc").setExecutor(this);
        getCommand("heal").setExecutor(this);
        getCommand("feed").setExecutor(this);
        getCommand("fly").setExecutor(this);

        // Startup message
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Syphon" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA + " Commands loaded.");
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use these commands.");
            return true;
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("gms")) {
            if (player.hasPermission("syphon.command.gms")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.AQUA + "Syphon: " + ChatColor.GREEN + "Gamemode Survival enabled");
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
        } else if (cmd.getName().equalsIgnoreCase("gmc")) {
            if (player.hasPermission("syphon.command.gmc")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.AQUA + "Syphon: " + ChatColor.GREEN + "Gamemode Creative enabled");
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
        } else if (cmd.getName().equalsIgnoreCase("heal")) {
            if (player.hasPermission("syphon.command.heal")) {
                player.setHealth(20);
                player.sendMessage(ChatColor.AQUA + "Syphon: " + ChatColor.RED + "You have been healed");
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
        } else if (cmd.getName().equalsIgnoreCase("feed")) {
            if (player.hasPermission("syphon.command.feed")) {
                player.setFoodLevel(20);
                player.sendMessage(ChatColor.AQUA + "Syphon: " + ChatColor.RED + "You have been fed");
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
        } else if (cmd.getName().equalsIgnoreCase("fly")) {
            if (player.hasPermission("syphon.command.fly")) {
                if (!player.getAllowFlight()) {
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.AQUA + "Syphon: " + ChatColor.GREEN + "Fly mode enabled");
                } else {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(ChatColor.AQUA + "Syphon: " + ChatColor.RED + "Fly mode disabled");
                }
            } else {
                player.sendMessage("You do not have permission to use this command.");
            }
        } else if (cmd.getName().equalsIgnoreCase("syphon")) {
            if (sender instanceof Player) {
                Player player1 = (Player) sender;

                String message = ChatColor.translateAlternateColorCodes('&',
                        "&7&l-------------------------------------\n" +
                                "&3&lSyphon &7(v1.0)\n" +
                                "&3Commands:\n" +
                                "&f- &f/gmc\n" +
                                "&f- &f/gms\n" +
                                "&f- &f/heal\n" +
                                "&f- &f/fly\n" +
                                "&f- &f/feed\n" +
                                "&3&lAuthor: \n&bVifez @ kiradev.xyz\n" +
                                "&7&oMake a suggestion by dming Vifez discord" +
                                "&7-------------------------------------");

                player.sendMessage(message);
            } else {
                sender.sendMessage("Only players can use this command.");
            }
            return true;
        }

        return false;
    }
}