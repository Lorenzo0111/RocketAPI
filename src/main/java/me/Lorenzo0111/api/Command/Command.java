package me.Lorenzo0111.api.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public abstract class Command implements CommandExecutor {

    protected JavaPlugin plugin;

    /**
     * @param plugin API plugin
     * @param command command
     */
    public Command(JavaPlugin plugin, String command) {
        this.plugin = plugin;

        PluginCommand pluginCommand = plugin.getCommand(command);

        if (pluginCommand == null) {
            plugin.getLogger().severe("Error from RocketAPI: The command " + command + " does not exist in the plugin.yml. Please add it or the command won't work." );
            return;
        }

        pluginCommand.setExecutor(this);
    }


    /**
     * @param sender Who executed the command
     * @param args Command argouments
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

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
