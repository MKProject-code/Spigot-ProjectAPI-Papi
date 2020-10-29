package com.mkproject.ProjectAPI.PapiCore;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Builder;
import com.mkproject.ProjectAPI.PapiPlugin.PapiPlugin;
import org.bukkit.Bukkit;

import java.sql.SQLException;

/**
 * The type Papi.
 */
public final class PapiCore extends PapiPlugin {

    private static PapiCore plugin;

    public static PapiCore getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.saveDefaultConfig();

        String hostname = this.getConfig().getString("MySQL.Hostname");
        String database = this.getConfig().getString("MySQL.Database");
        String username = this.getConfig().getString("MySQL.Username");
        String password = this.getConfig().getString("MySQL.Password");
        boolean ssl = this.getConfig().getBoolean("MySQL.SSL");

        try {
            this.registerNewMySQL(hostname, database, username, password, ssl);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        this.getLogger().warning("TESTTTTTTTTTTTTTTTTT ENABLED @@@@@@@@@@@@@@");
        System.out.println("TEST ENABLE *********************");

        //test
        Bukkit.getScheduler().runTask(this, new Runnable() {
            @Override
            public void run() {
                PapiCore.getPlugin().getLogger().warning("!!!!!!!!!!!!!!!!!!!!!! TEST !!!!!!!!!!!!!!!!!!!!!!");
                PapiCore.getPlugin().getLogger().warning(new Builder()
                        .select()
                            .add("u", "username")
                            .addAvg("p","id","numer")
                            .addCount("u","id","ilosc")
                        .from()
                            .add("users", "u")
                            .add("products","p")
                        .innerJoin("orders","o")
                            .on("o","id","=","1")
                        .where("u", "username", "=", "1")
                            .and("p","productName","LIKE","%2%")
                        .orderBy()
                            .addDesc("u","id")
                            .addAsc("u","registerAt")
                        .end().getBeautyQuery());
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
