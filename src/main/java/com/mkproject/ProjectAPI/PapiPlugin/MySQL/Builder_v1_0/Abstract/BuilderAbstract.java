package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build.BuilderSQLQuery;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build.BuilderSQLUpdate;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert.BuilderInsert;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Select.BuilderSelect;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;

public abstract class BuilderAbstractController {

    protected final PapiMySQL papiMySQL;
    protected String query = "";

    protected BuilderAbstractController(PapiMySQL papiMySQL) {
        this.papiMySQL = papiMySQL;
    }

    public void addSql(String sql) {
//        if (this.query.equals("")) this.query += " ( " + sql;
//        else
        this.query += (sql.indexOf(",") == 0 ? "" : " ") + sql;
    }

    public QueryAbstractController end() {
//        this.query += " ) ";
        if(this instanceof BuilderSelect)
            return new BuilderSQLQuery(this.query, this.papiMySQL);
        else if(this instanceof BuilderInsert)
            return new BuilderSQLUpdate(this.query, this.papiMySQL);
        return null;
    }
}
