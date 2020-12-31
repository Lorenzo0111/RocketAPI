package me.Lorenzo0111.api.Configuration;

import com.google.common.base.Charsets;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class Configuration {

    protected YamlConfiguration configuration;
    protected File file;
    protected String fileName;
    protected JavaPlugin plugin;

    public Configuration(String fileName, JavaPlugin plugin) {
        this.fileName = fileName;
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), fileName + ".yml");

        this.createFile();
    }

    public void createFile() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        if (!file.exists()) {
            plugin.getLogger().info("Generating " + fileName + ".yml file from RocketAPI");
            file.getParentFile().mkdirs();
            plugin.saveResource(fileName + ".yml", false);
        }

        configuration = new YamlConfiguration();

        try {
            configuration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        configuration = YamlConfiguration.loadConfiguration(file);

        final InputStream defConfigStream = plugin.getResource(fileName + ".yml");
        if (defConfigStream == null) {
            return;
        }

        configuration.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }

    public Object get(String path) {
        return configuration.get(path);
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return configuration;
    }

}
