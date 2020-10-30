package com.mkproject.ProjectAPI.PapiCore;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.ResultRow;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.ResultRowsList;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.ResultSQL;
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
        boolean consoleDebug = this.getConfig().getBoolean("MySQL.ConsoleDebug");

        try {
            this.registerNewMySQL(hostname, database, username, password, ssl);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        this.getMySQL().setConsoleDebug(true);

        //test
        Bukkit.getScheduler().runTask(this, () -> {
            PapiCore.getPlugin().getLogger().warning("!!!!!!!!!!!!!!!!!!!!!! TEST !!!!!!!!!!!!!!!!!!!!!!");
            ResultSQL rs = getMySQL().builder_v1_0()
                    .select()
                    .add("u", "realname")
                    .from()
                    .add("MKP_LoginManager_Users", "u")
                    .end().execute();

            if (rs.isError()) {
                PapiCore.getPlugin().getLogger().warning("ERROR ResultSQL==null");
            } else {
                ResultRowsList list = rs.getResultArrayList();
                if (list == null)
                    PapiCore.getPlugin().getLogger().warning("ERROR getArrayList()==null");
                else {
                    PapiCore.getPlugin().getLogger().warning("Size=" + list);
                    for (ResultRow row : list) {
                        row.getString(1);
                    }
                }
                rs.close();
            }
            try {
                int id = getMySQL().builder_v1_0().insertInto("MKP_LoginManager_Logs").columns("userid", "login_ip").valuesArray(new String[]{"888", null}).end().execute();
                PapiCore.getPlugin().getLogger().warning("dodano! id="+id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            PapiCore.getPlugin().getLogger().warning("OK?");
//                new BuilderInsert().insertInto("users").addColumns("username","createdAt").addValuesArray().end().getBeautyQuery();
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
