package com.mkproject.ProjectAPI.PapiPlugin;

import com.google.common.base.Charsets;
import com.mkproject.ProjectAPI.PapiCore.PapiCore;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;
import com.mkproject.ProjectAPI.PapiPlugin.Scheduler.PapiScheduler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * The type Papi Java Plugin.
 */
public abstract class PapiPlugin extends JavaPlugin {

    /* Bukkit Managers */

    /**
     * Gets the plugin manager for interfacing with plugins.
     *
     * @return a plugin manager for this Server instance
     */
    public PluginManager getPluginManager() {
        return this.getServer().getPluginManager();
    }

    /**
     * Gets the instance of the scoreboard manager.
     * This will only exist after the first world has loaded.
     *
     * @return the scoreboard manager or null if no worlds are loaded.
     */
    public ScoreboardManager getScoreboardManager() {
        return this.getServer().getScoreboardManager();
    }

    /**
     * Gets a services manager.
     *
     * @return a services manager
     */
    public ServicesManager getServicesManager() {
        return this.getServer().getServicesManager();
    }

    /* Papi Managers */

    private static PapiScheduler papiScheduler;

    public static PapiScheduler getPapiScheduler() {
        if (papiScheduler == null)
            papiScheduler = new PapiScheduler();
        return papiScheduler;
    }

    /* MySQL support */

    private PapiMySQL papiMySQL = null;
    private static PapiMySQL papiMySQLdefault = null;

    /**
     * Register new MySQL connection.
     *
     * @param hostname the hostname (default port: 3306)
     * @param database the database
     * @param username the username
     * @param password the password
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public void registerNewMySQL(String hostname, String database, String username, String password, boolean ssl) throws SQLException, ClassNotFoundException {
        this.papiMySQL = new PapiMySQL(hostname, database, username, password, ssl);
    }

    /**
     * Gets MySQL Controller.
     *
     * @return the PapiMySQL
     */
    public PapiMySQL getMySQL() {
        if (this.papiMySQL == null) {
            this.getLogger().warning("********** ERROR **********");
            this.getLogger().warning("You must connect to MySQL server first! Use 'registerNewMySQL(database, username, password)' in 'onEnbale()' method!");
            return null;
        }
        return this.papiMySQL;
    }

    public PapiMySQL getDefaultMySQL() {
        if (papiMySQLdefault == null) {
            PapiCore papiCorePlugin = PapiCore.getPlugin(PapiCore.class);

            if (papiCorePlugin.getMySQL() == null) {
                this.getLogger().warning("********** ERROR **********");
                this.getLogger().warning("You must connect to MySQL server first! Config database, username, password in PapiConfig!");
                return null;
            }
            papiMySQLdefault = papiCorePlugin.getMySQL();
        }
        return papiMySQLdefault;
    }

    /* YAML support */

    private final Map<String, File> configFiles = new HashMap<>();
    private final Map<String, FileConfiguration> newConfigs = new HashMap<>();

    private File registerConfigFile(String fileName) {
        File file = new File(this.getDataFolder(), fileName + ".yml");
        this.configFiles.put(fileName, file);
        return file;
    }

    /**
     * Gets custom config.
     *
     * @param fileName the file name
     * @return the config
     */
    public FileConfiguration getConfig(String fileName) {
        FileConfiguration fileConfig = this.newConfigs.get(fileName);
        if (fileConfig == null) {
            this.reloadConfig(fileName);
            return this.newConfigs.get(fileName);
        } else {
            return fileConfig;
        }
    }

    /**
     * Reload custom config.
     *
     * @param fileName the file name
     */
    public void reloadConfig(String fileName) {
        File file = this.configFiles.get(fileName);
        if (file == null) {
            file = this.registerConfigFile(fileName);
        }

        FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
        this.newConfigs.put(fileName, fileConfig);

        final InputStream defConfigStream = getResource(fileName + ".yml");
        if (defConfigStream == null) {
            return;
        }

        fileConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
    }

    /**
     * Save custom config.
     *
     * @param fileName the file name
     */
    public void saveConfig(String fileName) {
        File file = this.configFiles.get(fileName);
        if (file == null) {
            file = this.registerConfigFile(fileName);
        }

        try {
            getConfig().save(file);
        } catch (IOException ex) {
            this.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
        }
    }

    /**
     * Save default custom config.
     *
     * @param fileName the file name
     */
    public void saveDefaultConfig(String fileName) {
        File file = this.configFiles.get(fileName);
        if (file == null) {
            file = this.registerConfigFile(fileName);
        }

        if (file.exists()) {
            this.saveResource(fileName + ".yml", false);
        }
    }


}
