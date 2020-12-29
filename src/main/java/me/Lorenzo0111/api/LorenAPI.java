package me.Lorenzo0111.api;

import me.Lorenzo0111.api.Listeners.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LorenAPI extends JavaPlugin {

    private static LorenAPI instance;

    @Override
    public void onEnable() {
        getLogger().info("Enabling LorenAPI v" + this.getDescription().getVersion());
        instance = this;
        this.hook();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void hook() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

    public static LorenAPI getInstance() {
        return instance;
    }

}
