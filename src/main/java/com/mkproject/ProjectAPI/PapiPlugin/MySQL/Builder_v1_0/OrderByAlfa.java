package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public class OrderByAlfa extends BuilderElement {

    public OrderByAlfa(Builder builder) {
        super(builder);
    }

    public OrderByBeta addAsc(String table, String column) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql("ORDER BY", table + "." + column + " ASC");
        return new OrderByBeta(this.getBuilder());
    }

    public OrderByBeta addDesc(String table, String column) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql("ORDER BY", table + "." + column + " DESC");
        return new OrderByBeta(this.getBuilder());
    }
}
