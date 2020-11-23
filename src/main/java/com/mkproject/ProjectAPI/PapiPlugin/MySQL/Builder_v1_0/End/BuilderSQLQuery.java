package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.QueryAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.ResultSQL;

import java.sql.SQLException;

public final class BuilderSQLQuery extends QueryAbstractController {

    public BuilderSQLQuery(String query, PapiMySQL papiMySQL) {
        super(query, papiMySQL);
    }

    public ResultSQL execute() {
        return this.getPapiMySQL().query(this.getQueryString());
    }
}
