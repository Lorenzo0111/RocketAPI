package me.Lorenzo0111.api;

import me.Lorenzo0111.api.Listeners.CommandListener;
import me.Lorenzo0111.api.Listeners.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LorenAPI extends JavaPlugin {

    private static LorenAPI instance;

    @Override
    public void onEnable() {
        getLogger().info("Enabling LorenAPI v" + this.getDescription().getVersion());
        instance = this;
        this.register();
    }

    @Override
    public void onDisable() {

    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
    }

    public void hook(JavaPlugin plugin) {
        this.getLogger().info("Hooked with " + plugin.getDescription().getName() );
    }

    public static LorenAPI getInstance() {
        return instance;
    }

}
