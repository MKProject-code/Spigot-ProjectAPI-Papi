package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public class OrderByBeta extends BuilderElement {

    public OrderByBeta(Builder builder) {
        super(builder);
    }

    public OrderByBeta addAsc(String table, String column) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql(",", table + "." + column + " ASC");
        return new OrderByBeta(this.getBuilder());
    }

    public OrderByBeta addDesc(String table, String column) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql(",", table + "." + column + " DESC");
        return new OrderByBeta(this.getBuilder());
    }

    public Builder end() {
        return this.getBuilder().end();
    }
}
