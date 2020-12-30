package me.Lorenzo0111.api.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Command implements CommandExecutor {

    protected JavaPlugin plugin;

    /**
     * @param plugin API plugin
     * @param command command
     */
    public Command(JavaPlugin plugin, String command) {
        this.plugin = plugin;
        plugin.getCommand(command).setExecutor(this);
    }


    /**
     * @param sender Who executed the command
     * @param args Command argouments
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.execute(sender, args);
        return true;
    }

    public abstract void execute(CommandSender sender, String[] args);

    /**
     * @return if the sender is a player
     */
    public boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    /**
     * @return plugin
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

}
