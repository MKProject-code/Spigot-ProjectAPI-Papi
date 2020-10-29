package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class SelectBeta extends BuilderElement {

    protected SelectBeta(Builder builder) {
        super(builder);
    }

    public SelectGamma add(String table, String column) {
        return this.add(table, column, null);
    }

    public SelectGamma add(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql("SELECT", table + "." + column + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addCount(String table, String column) {
        return this.addCount(table, column, null);
    }

    public SelectGamma addCount(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql("SELECT", "COUNT(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addAvg(String table, String column) {
        return this.addAvg(table, column, null);
    }

    public SelectGamma addAvg(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql("SELECT", "AVG(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addSum(String table, String column) {
        return this.addSum(table, column, null);
    }

    public SelectGamma addSum(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql("SELECT", "SUM(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }
}