package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractElement;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

public final class OrderByAlfa extends BuilderAbstractElement {

    public OrderByAlfa(BuilderAbstractController builder) {
        super(builder);
    }

    public OrderByBeta addAsc(String table, String column) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql("ORDER BY", table + "." + column + " ASC");
        return new OrderByBeta(this.getBuilder());
    }

    public OrderByBeta addDesc(String table, String column) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql("ORDER BY", table + "." + column + " DESC");
        return new OrderByBeta(this.getBuilder());
    }
}
