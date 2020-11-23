package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.QueryAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;

import java.sql.SQLException;

public final class BuilderSQLUpdate extends QueryAbstractController {

    public BuilderSQLUpdate(String query, PapiMySQL papiMySQL) {
        super(query, papiMySQL);
    }

    public int execute() throws SQLException {
        return this.getPapiMySQL().update(this.getQueryString());
    }
}
