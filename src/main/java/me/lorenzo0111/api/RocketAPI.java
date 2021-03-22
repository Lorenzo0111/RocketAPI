package me.lorenzo0111.api;

import me.lorenzo0111.api.listeners.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class RocketAPI extends JavaPlugin {

    private static RocketAPI instance;

    @Override
    public void onEnable() {
        getLogger().info("Enabling RocketAPI v" + this.getDescription().getVersion());
        instance = this;
        this.register();
    }

    public void register() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

    public void hook(JavaPlugin plugin) {
        this.getLogger().info("Hooked with " + plugin.getDescription().getName() );
    }

    public static RocketAPI getInstance() {
        return instance;
    }

}
