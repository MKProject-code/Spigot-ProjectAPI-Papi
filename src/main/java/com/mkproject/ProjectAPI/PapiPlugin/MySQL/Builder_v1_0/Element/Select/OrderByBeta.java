package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.ElementAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build.BuilderSQLQuery;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

public final class OrderByBeta extends ElementAbstractController {

    public OrderByBeta(BuilderAbstractController builder) {
        super(builder);
    }

    public BuilderSQLQuery end() {
        return (BuilderSQLQuery) this.getBuilder().end();
    }

    public OrderByBeta addAsc(String table, String column) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql(",", table + "." + column + " ASC");
        return new OrderByBeta(this.getBuilder());
    }

    public OrderByBeta addDesc(String table, String column) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql(",", table + "." + column + " DESC");
        return new OrderByBeta(this.getBuilder());
    }
}
