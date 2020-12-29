package me.Lorenzo0111.api;

import me.Lorenzo0111.api.Listeners.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LorenAPI extends JavaPlugin {

    public LorenAPI() {

    }

    @Override
    public void onEnable() {


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void hook() {
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

}
