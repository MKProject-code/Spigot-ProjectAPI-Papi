package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;

public class QueryAbstractController {

    private final String query;
    private final PapiMySQL papiMySQL;

    public QueryAbstractController(String query, PapiMySQL papiMySQL) {
        this.query = query;
        this.papiMySQL = papiMySQL;
    }

    public String getQueryString() {
        return this.query + ";";
    }

    public String getBeautyQueryString(){
        return BuilderUtils.formatBeautyQuery(this.query);
    }

    protected PapiMySQL getPapiMySQL() {
        return this.papiMySQL;
    }
}
